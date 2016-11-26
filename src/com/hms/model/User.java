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
public class User extends DomainObject{
    private int id;
    private String firstName;
    private String lastName;
    private String mailId;
    private long ssn;
    private String phone;
    private Date dob;
    private char gender;
    private String password;
    private String role;
    private String zipCode;
    
    public User(){}

    public User(String mailId, String password) {
        this.mailId = mailId;
        this.password = password;
    }

    public User(String firstName, String lastName, String mailId, long ssn, String phone, Date dob, char gender, String role, String zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mailId = mailId;
        this.ssn = ssn;
        this.phone = phone;
        this.dob = dob;
        this.gender = gender;
        this.role = role;
        this.zipCode = zipCode;
    }
    
    public User(String firstName, String lastName, String mailId, long ssn, String phone, Date dob, char gender, String password, String role,String zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mailId = mailId;
        this.ssn = ssn;
        this.phone = phone;
        this.dob = dob;
        this.gender = gender;
        this.password = password;
        this.role = role;
        this.zipCode=zipCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public long getSsn() {
        return ssn;
    }

    public void setSsn(long ssn) {
        this.ssn = ssn;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    
    
}   

