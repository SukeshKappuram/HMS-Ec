/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hms.model;

import java.util.Date;

/**
 *
 * @author iamsu
 */
public class Patient extends User{
    private float height;
    private float weight;

    public Patient(String mailId, String password) {
        super(mailId, password);
    }

    public Patient(String firstName, String lastName, String mailId, long ssn, String phone, Date dob, char gender, String role, String zipCode) {
        super(firstName, lastName, mailId, ssn, phone, dob, gender, role, zipCode);
    }
    
    public Patient(float height, float weight, String firstName, String lastName, String mailId, long ssn, String phone, Date dob, char gender, String password, String role, String zipCode) {
        super(firstName, lastName, mailId, ssn, phone, dob, gender, password, role, zipCode);
        this.height = height;
        this.weight = weight;
    }
    
    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    
}
