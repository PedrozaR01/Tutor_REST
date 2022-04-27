/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.rob.repositories;

import com.rob.entities.Subject;
import com.rob.entities.TutorJoin;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Antonio Pedroza
 */
public interface SubjectRepository extends JpaRepository<Subject, Integer>{
    
    @Query("SELECT new com.rob.entities.TutorJoin(t.tutor_id, t.firstName, t.lastName, t.intro, t.tutorImg, s.subjectId, s.subjectTitle) FROM Tutor t " 
            + " INNER JOIN t.subject s")
    List<TutorJoin> fectchTutorInnerJoin();    
    
}
