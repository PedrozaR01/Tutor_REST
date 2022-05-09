/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rob.entities;

import com.rob.entities.Subject;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ManyToAny;

/**
 *
 * @author Antonio Pedroza
 */

@Entity
@Table(name = "tutor")
public class Tutor implements Serializable {
    
    @Id
    @Column(name = "tutor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tutor_id;
    @Column(name = "email")
    private String email;
    @Column(name = "pass")
    private String pass;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "intro")
    private String intro;
    @Column(name = "tutor_img")
    private String tutorImg;
    @Column(name = "zip_code")
    private String zipCode;
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "tutor_subject", joinColumns = {@JoinColumn(name = "tutor_id")},
           inverseJoinColumns = {
            @JoinColumn(name = "subject_id")
        } )
    private Set<Subject> subject = new HashSet<Subject>(0);

    public void addSubject(Subject subject){
        this.subject.add(subject);
        subject.getTutor().add(this);
    }
    
    public void removeSubject(Subject subject){
        this.getSubject().remove(subject);
        subject.getTutor().remove(this);
    }
    
    public void removeSubjects(){
        for (Subject subject : new HashSet<>(subject)) {
            removeSubject(subject);
        }
    }
    
    
    public Integer getTutorId() {
        return tutor_id;
    }

    public void setTutorId(Integer tutorId) {
        this.tutor_id = tutorId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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

    
    public String getTutorImg() {
        return tutorImg;
    }

    public void setTutorImg(String tutorImg) {
        this.tutorImg = tutorImg;
    }
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    
    public Set<Subject> getSubject() {
        return subject;
    }

    public void setSubject(Set<Subject> subject) {
        this.subject = subject;
    }

    
    
    
    
}
