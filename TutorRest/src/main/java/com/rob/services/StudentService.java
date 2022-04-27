/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rob.services;

import com.rob.entities.Student;
import com.rob.repositories.StudentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Antonio Pedroza
 */

@Service
public class StudentService {
    @Autowired
    private StudentRepository repo;
    
    public List<Student> listAll(){
        return repo.findAll();
    }
    
    public void save(Student student){
        repo.save(student);
    }
    
    public Student get(Integer id) {
		return repo.findById(id).get();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
    
    
}
