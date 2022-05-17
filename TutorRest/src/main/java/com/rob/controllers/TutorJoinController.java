/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rob.controllers;

import com.rob.entities.Subject;
import com.rob.entities.TutorJoin;
import com.rob.services.JoinService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Antonio Pedroza
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TutorJoinController {
    
    @Autowired
    private JoinService joinServ;
    
    @GetMapping("/tutorsubject")
    public ResponseEntity<List<TutorJoin>> getTutorSubject(){
        return new ResponseEntity<List<TutorJoin>>(joinServ.getTutorJoin(), HttpStatus.OK);
    }
    
 
}
