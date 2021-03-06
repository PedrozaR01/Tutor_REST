/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.rob.repositories;

import com.rob.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Antonio Pedroza
 */
@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer>{
    public Subject findBysubjectTitle(String subjectTitle);
}
