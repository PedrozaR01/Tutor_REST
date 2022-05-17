/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rob.controllers;

import com.rob.entities.Appointment;
import com.rob.services.AppointmentService;
import java.util.List;
import java.util.NoSuchElementException;
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
public class AppointmentController {
    
    @Autowired
    private AppointmentService appSer;
    
    @GetMapping("/appointments")
    public List<Appointment> getAll(){
        return appSer.listAll();
    }
    
    @GetMapping("/appointments/{id}")
    public ResponseEntity<Appointment> get(@PathVariable Integer Id){
        try {
            Appointment appt = appSer.get(Id);
            return new ResponseEntity<Appointment>(appt, HttpStatus.OK); 
        }catch (NoSuchElementException e){
            return new ResponseEntity<Appointment>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/appointments")
    public void add(@RequestBody Appointment appointment){
        appSer.Save(appointment);
    }
    
    @PutMapping("/appointments/{id}")
    public ResponseEntity<?> update(@RequestBody Appointment appointment, @PathVariable Integer id){
        try{
            Appointment existappointment = appSer.get(id);
            appSer.Save(appointment);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/appointments/{id}")
    public void delete(@PathVariable Integer id){
        appSer.delete(id);
    }
}
