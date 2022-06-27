/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rob.util;

import com.rob.security.entity.Role;
import com.rob.security.enums.RoleName;
import com.rob.security.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author Antonio Pedroza
 */
@Component
public class CreateRoles implements CommandLineRunner {

    @Autowired
    RoleService roleServ;
    
    @Override
    public void run(String... args) throws Exception {
        /*Role roleAdmin = new Role(RoleName.ROLE_ADMIN);
        Role roleTutor = new Role(RoleName.ROLE_TUTOR);
        Role roleStudent = new Role(RoleName.ROLE_STUDENT);
        
        roleServ.save(roleTutor);
        roleServ.save(roleAdmin);
        roleServ.save(roleStudent);*/
    }
    
    
}
