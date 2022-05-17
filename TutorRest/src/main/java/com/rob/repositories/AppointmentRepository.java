/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.rob.repositories;

import com.rob.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Antonio Pedroza
 */
public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{
    
}
