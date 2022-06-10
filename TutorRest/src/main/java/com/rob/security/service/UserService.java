/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rob.security.service;

import com.rob.security.entity.User;
import com.rob.security.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Antonio Pedroza
 */
@Service
@Transactional
public class UserService {
    
    @Autowired
    UserRepository userRepo;
    
    public Optional<User> getByUserName(String userName){
        return userRepo.findByUserName(userName);
    }
    
    public boolean existsByUserName(String userName){
        return userRepo.existsByUserName(userName);
    }
    
    public boolean existsByEmail(String email){
        return userRepo.existsByEmail(email);
    }
    
    public void save(User user){
        userRepo.save(user);
    }
    
}
