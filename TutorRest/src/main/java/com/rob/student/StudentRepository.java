/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.rob.student;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Antonio Pedroza
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {
    
}
