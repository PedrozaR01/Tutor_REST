/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rob.controllers;

import com.rob.entities.TutorDTO;
import com.rob.services.TutorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Antonio Pedroza
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TutorController {
    @Autowired
    private TutorService tutorService;
    
    @GetMapping("/tutors")
    public ResponseEntity<List<TutorDTO>> getAllTutors() {
        List<TutorDTO> tutors = tutorService.getAllTutors();
        return new ResponseEntity<>(tutors, HttpStatus.OK);
    }
    
    @PostMapping("/tutors")
    public ResponseEntity<TutorDTO> getAllTutors(@RequestBody TutorDTO tutorDto) {
        TutorDTO tdto = tutorService.addTutor(tutorDto);
        return new ResponseEntity<>(tdto, HttpStatus.CREATED);
    }
    
    @PutMapping("/tutors/{id}")
    public ResponseEntity<TutorDTO> updateTutor(@PathVariable(name = "id") Integer id,
            @RequestBody TutorDTO tutor){
        TutorDTO tdto = tutorService.UpdateTutor(id, tutor);
        return new ResponseEntity<>(tdto, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/tutors/{id}")
    public ResponseEntity<String> deleteTutor(@PathVariable(name = "id") Integer tutorId) {
        String message = tutorService.deleteTutor(tutorId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    
}
