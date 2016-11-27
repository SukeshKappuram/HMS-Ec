/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hms.dao;

import com.hms.model.Appointment;
import com.hms.model.Hospital;
import com.hms.model.Report;
import com.hms.model.User;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author iamsu
 */
public interface AppointmentDAO {
    public void createAppointment(Appointment appointment)throws ClassNotFoundException, SQLException;
    public void updateAppointment(int appointmentId,Appointment appointment)throws ClassNotFoundException, SQLException;
    public int deleteAppointment(int appointmentId)throws ClassNotFoundException, SQLException;
    public List<Appointment> getAppointments(User user) throws SQLException,ClassNotFoundException ;
    public List<Hospital> getHospitals() throws SQLException, ClassNotFoundException;
    public Appointment getAppointment(int appointmentId) throws SQLException, ClassNotFoundException;
    public List<Report> getReports(int appointmentId) throws SQLException, ClassNotFoundException;
}
