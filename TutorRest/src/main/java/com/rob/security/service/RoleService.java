/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rob.security.service;

import com.rob.security.entity.Role;
import com.rob.security.enums.RoleName;
import com.rob.security.repository.RoleRepository;
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
public class RoleService {
    @Autowired 
    RoleRepository roleRepo;
    
    public Optional<Role> getByRoleName(RoleName roleName){
        return roleRepo.findByRoleName(roleName);
    }
    
    public void save(Role role){
        roleRepo.save(role);
    }
}
