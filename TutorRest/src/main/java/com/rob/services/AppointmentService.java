/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rob.services;

import com.rob.entities.Appointment;
import com.rob.repositories.AppointmentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Antonio Pedroza
 */
@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository repo;
    
    public List<Appointment> listAll(){
        return repo.findAll();
    }
    
    public void Save (Appointment appointment){
        repo.save(appointment);
    }
    
    public Appointment get(Integer Id){
        return repo.findById(Id).get();
    }
    
    public void delete(Integer Id){
        repo.deleteById(Id);
    }
}
