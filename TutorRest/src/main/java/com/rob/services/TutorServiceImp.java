/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rob.services;

import com.rob.entities.Subject;
import com.rob.entities.Tutor;
import com.rob.entities.TutorDTO;
import com.rob.repositories.SubjectRepository;
import com.rob.repositories.TutorRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Antonio Pedroza
 */
@Service
public class TutorServiceImp implements TutorService {
    
    @Resource
    private TutorRepository tutorRepo;
    @Resource
    private SubjectRepository subjectRepo;

    @Transactional
    @Override
    public TutorDTO addTutor(TutorDTO tutorDto) {
        Tutor tutor = new Tutor();
        mapDtoToEntity(tutorDto, tutor);
        Tutor savedTutor = tutorRepo.save(tutor);
        return mapEntityToDto(savedTutor);
        
    }

    @Override
    public List<TutorDTO> getAllTutors() {
        List<TutorDTO> tutorsDto = new ArrayList<>();
        List<Tutor> tutors = tutorRepo.findAll();
        tutors.stream().forEach(tutor -> {
            TutorDTO tutorDto = mapEntityToDto(tutor);
            tutorsDto.add(tutorDto);
        });
        return tutorsDto;
    }
    
     @Override
    public TutorDTO getTutor(Integer tutorId) {
    Tutor ttr = tutorRepo.getById(tutorId);
    TutorDTO tutorDto = mapEntityToDto(ttr);
    return tutorDto;
    
    }
    
    @Transactional
    @Override
    public TutorDTO UpdateTutor(Integer tutorId, TutorDTO tutor) {
        Tutor ttr = tutorRepo.getOne(tutorId);
        ttr.getSubject().clear();
        mapDtoToEntity(tutor, ttr);
        Tutor tut = tutorRepo.save(ttr);
        return mapEntityToDto(tut);
    }

    @Override
    public String deleteTutor(Integer tutorId) {
        Optional<Tutor> tutor = tutorRepo.findById(tutorId);
        if(tutor.isPresent()) {
            tutor.get().removeSubjects();
            tutorRepo.deleteById(tutor.get().getTutorId());
            return "Tutor with id: " + tutorId + " has been deleted"; 
        }
        return null;
    }
    
    private void mapDtoToEntity(TutorDTO tutorDto, Tutor tutor){
        tutor.setFirstName(tutorDto.getFirstName());
        tutor.setLastName(tutorDto.getLastName());
        tutor.setIntro(tutorDto.getIntro());
        tutor.setTutorImg(tutorDto.getTutorImg());
        if(null == tutor.getSubject()){
            tutor.setSubject(new HashSet<>());
        }
        tutorDto.getSubjects().stream().forEach(subjectTitle -> {
        Subject subject = subjectRepo.findBysubjectTitle(subjectTitle);
        if (null == subject) {
            subject = new Subject();
            subject.setTutor(new HashSet<>());
        }
        subject.setSubjectTitle(subjectTitle);
        tutor.addSubject(subject);
        });
    }
    
    private TutorDTO mapEntityToDto(Tutor tutor){
        TutorDTO responseDto = new TutorDTO();
        responseDto.setTutor_id(tutor.getTutorId());
        responseDto.setFirstName(tutor.getFirstName());
        responseDto.setLastName(tutor.getLastName());
        responseDto.setTutorImg(tutor.getTutorImg());
        responseDto.setIntro(tutor.getIntro());
        responseDto.setSubjects(tutor.getSubject().stream().map(Subject::getSubjectTitle).collect(Collectors.toSet()));
        return responseDto;
    }

   
}
