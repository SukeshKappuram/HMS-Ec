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
public class Appointment extends DomainObject{
    private int id;
    private Date appointmentdate;
    private Patient patient;
    private Doctor doctor;
    private String problem;

    public Appointment() {
    }
    
    public Appointment(int id, Date appointmentdate, Patient patient, Doctor doctor, String problem) {
        this.id = id;
        this.appointmentdate = appointmentdate;
        this.patient = patient;
        this.doctor = doctor;
        this.problem = problem;
    }
    
    public Appointment(Date appointmentdate, Patient patient, Doctor doctor, String problem) {
        this.appointmentdate = appointmentdate;
        this.patient = patient;
        this.doctor = doctor;
        this.problem = problem;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getAppointmentdate() {
        return appointmentdate;
    }

    public void setAppointmentdate(Date appointmentdate) {
        this.appointmentdate = appointmentdate;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }
    
    
}
