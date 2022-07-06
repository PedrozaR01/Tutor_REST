/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rob.controllers;

import com.rob.entities.Subject;
import com.rob.repositories.SubjectRepository;
import com.rob.services.SubjectService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Antonio Pedroza
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SubjectController {
    
    @Autowired
    SubjectService serv;
    
    @Autowired
    SubjectRepository repo;
    
    @GetMapping("/subjects")
    public ResponseEntity<List<Subject>> getAllSubjects(){
        List<Subject> subjects = serv.listAll();
        return new ResponseEntity<>(subjects, HttpStatus.OK);
} 
    
    @PostMapping("/subjects")
    public void add(@RequestBody Subject subject){
        Subject sbjt = repo.findBysubjectTitle(subject.getSubjectTitle());
        if(sbjt == null){
            serv.Save(subject);
        } else {
            System.out.println("Subject already exists");
        }
        
    }
    
    @DeleteMapping("/subjects/{id}")
    public void delete(@PathVariable Integer id){
        serv.delete(id);
    }
}
