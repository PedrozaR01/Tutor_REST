/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rob.services;

import com.rob.entities.TutorJoin;
import com.rob.repositories.SubjectRepository;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author Antonio Pedroza
 */

@Service
public class JoinService {
    
    @Resource
    private SubjectRepository subRepo;
    
    public List<TutorJoin> getTutorJoin(){
        List<TutorJoin> list = subRepo.fectchTutorInnerJoin();
        return list;
    }
}
