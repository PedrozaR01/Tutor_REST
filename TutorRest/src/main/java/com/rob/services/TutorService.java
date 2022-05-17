/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.rob.services;

import com.rob.entities.TutorDTO;
import java.util.List;

/**
 *
 * @author Antonio Pedroza
 */
public interface TutorService {
    
    public TutorDTO addTutor(TutorDTO tutorDto);
    
    public List<TutorDTO> getAllTutors();
    
    public TutorDTO getTutor(Integer tutorId);
    
    public TutorDTO UpdateTutor(Integer tutorId, TutorDTO tutor);
    
    public String deleteTutor(Integer tutorId);
}
