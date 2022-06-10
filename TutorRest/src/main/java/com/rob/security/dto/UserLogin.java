/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rob.security.dto;


import javax.validation.constraints.NotBlank;

/**
 *
 * @author Antonio Pedroza
 */
public class UserLogin {
    @NotBlank
    private String userName;
    
    @NotBlank
    private String password; 

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
