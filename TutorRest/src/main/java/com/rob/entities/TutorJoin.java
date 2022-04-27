/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rob.entities;

import java.io.Serializable;

/**
 *
 * @author Antonio Pedroza
 */
public class TutorJoin implements Serializable {
    
    private Integer tutor_id;
    private String firstName;
    private String lastName;
    private String intro;
    private Integer subjectId;
    private String subjectTitle;

    public TutorJoin() {
    }

    public TutorJoin(Integer tutorId, String firstName, String lastName, String intro, Integer subjectId, String subjectTitle) {
        this.tutor_id = tutorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.intro = intro;
        this.subjectId = subjectId;
        this.subjectTitle = subjectTitle;
    }

    public Integer getTutorId() {
        return tutor_id;
    }

    public void setTutorId(Integer tutorId) {
        this.tutor_id = tutorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectTitle() {
        return subjectTitle;
    }

    public void setSubjectTitle(String subjectTitle) {
        this.subjectTitle = subjectTitle;
    }
    
    public String toString(){
        return "TutorJoin [tutor_id = "+tutor_id+", firstname = "+firstName+", lastName = "+ lastName +", intro = "+intro+", subjectId = "+subjectId+", subjectTitle = "+subjectTitle+"]";
    }
    
}
