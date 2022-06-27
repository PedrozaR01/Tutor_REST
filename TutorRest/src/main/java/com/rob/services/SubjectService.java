/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rob.services;

import com.rob.entities.Subject;
import com.rob.repositories.SubjectRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Antonio Pedroza
 */
@Service
public class SubjectService {
    
    @Autowired
    SubjectRepository repo;
    
    public List<Subject> listAll(){
        return repo.findAll();
    }
    
    public void Save(Subject subject){
        repo.save(subject);
    }
    
    public Subject get(Integer Id){
        return repo.findById(Id).get();
    }
    
    public void delete(Integer Id){
        repo.deleteById(Id);
    }
}
