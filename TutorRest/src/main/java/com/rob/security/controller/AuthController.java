/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rob.security.controller;

import com.rob.security.dto.JwtDto;
import com.rob.security.dto.NewUser;
import com.rob.security.dto.UserLogin;
import com.rob.security.entity.Role;
import com.rob.security.entity.User;
import com.rob.security.enums.RoleName;
import com.rob.security.jwt.JwtProvider;
import com.rob.security.service.RoleService;
import com.rob.security.service.UserService;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Antonio Pedroza
 */
@RestController
@RequestMapping("/auth")
@CrossOrigin("http://localhost:4200")
public class AuthController {
    
    @Autowired
    PasswordEncoder passEnc;
    
    @Autowired
    AuthenticationManager auth;
    
    @Autowired
    UserService userServ;
    
    @Autowired
    RoleService roleServ;
    
    @Autowired
    JwtProvider jwtProv;
    
    @PostMapping("/new")
    public ResponseEntity<?> save(@Valid @RequestBody NewUser newUser, BindingResult bindingRes){
        if(bindingRes.hasErrors()){
            return new ResponseEntity("Error", HttpStatus.BAD_REQUEST);
        }
        if(userServ.existsByUserName(newUser.getUserName())){
            return new ResponseEntity("Username already exists", HttpStatus.BAD_REQUEST);
        }
        if(userServ.existsByEmail(newUser.getEmail())){
            return new ResponseEntity("Email already registered", HttpStatus.BAD_REQUEST);
        }
        User user = new User(newUser.getName(), newUser.getUserName(), newUser.getEmail(),
        passEnc.encode(newUser.getPassword()));
        
        Set<Role> role = new HashSet<>();
        role.add(roleServ.getByRoleName(RoleName.ROLE_STUDENT).get());
        if(newUser.getRoles().contains("tutor"))
            role.add(roleServ.getByRoleName(RoleName.ROLE_TUTOR).get());
        user.setRole(role);
        userServ.save(user);
        return new ResponseEntity("User created", HttpStatus.CREATED);
    }
    
    @PostMapping("/login")
    public ResponseEntity<JwtDto> Login(@Valid @RequestBody UserLogin userLogin, BindingResult bindingResult){
        System.out.println(userLogin);
        if(bindingResult.hasErrors()){
            return new ResponseEntity("Error", HttpStatus.BAD_REQUEST);
        }
        Authentication authentication =
                auth.authenticate(new UsernamePasswordAuthenticationToken(userLogin.getUserName(), userLogin.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProv.generateToken(authentication);
        UserDetails userDet = (UserDetails) authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDet.getUsername(), userDet.getAuthorities());
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
}
