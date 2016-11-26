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
public class Doctor extends User{
        private long npi;
        private String practiceName;
        private String practiceType;
        private String position;
        
        public Doctor() {
			// TODO Auto-generated constructor stub
		}

    public Doctor(String mailId, String password) {
        super(mailId, password);
    }

    public Doctor(String firstName, String lastName, String mailId, long ssn, String phone, Date dob, char gender, String role, String zipCode) {
        super(firstName, lastName, mailId, ssn, phone, dob, gender, role, zipCode);
    }

    public Doctor(long npi, String practiceName, String practiceType, String position) {
        super();
        this.npi = npi;
        this.practiceName = practiceName;
        this.practiceType = practiceType;
        this.position = position;
    }
    
    public Doctor(long npi, String practiceName, String practiceType, String position, String firstName, String lastName, String mailId, long ssn, String phone, Date dob, char gender, String password, String role, String zipCode) {
        super(firstName, lastName, mailId, ssn, phone, dob, gender, password, role, zipCode);
        this.npi = npi;
        this.practiceName = practiceName;
        this.practiceType = practiceType;
        this.position = position;
    }
        
    public Doctor(int id, String firstName, String lastName, String mailId, long ssn, String phone, Date dob,
			char gender, String role, String zipCode) {
		super(id, firstName, lastName, mailId, ssn, phone, dob, gender,  role, zipCode);
		// TODO Auto-generated constructor stub
	}

	public long getNpi() {
        return npi;
    }

    public void setNpi(long npi) {
        this.npi = npi;
    }

    public String getPracticeName() {
        return practiceName;
    }

    public void setPracticeName(String practiceName) {
        this.practiceName = practiceName;
    }

    public String getPracticeType() {
        return practiceType;
    }

    public void setPracticeType(String practiceType) {
        this.practiceType = practiceType;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
        
    
        
}
