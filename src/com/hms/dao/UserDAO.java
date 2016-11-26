/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hms.dao;

import com.hms.model.Doctor;
import com.hms.model.Patient;
import com.hms.model.User;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author iamsu
 */
public interface UserDAO {
    public int addUser(User user);
    public void verifyUser(User user);
    public int updateUser(User user);
    public User getUser();
    public boolean isValidUser();
    public List<User> getDoctors(String s) throws SQLException, ClassNotFoundException;
    public Doctor getDoctor(int doctorId) throws SQLException, ClassNotFoundException;
    public Patient getPatient(int patientId) throws SQLException, ClassNotFoundException ;
    public List<Doctor> getSpecialists() throws SQLException, ClassNotFoundException;
}
