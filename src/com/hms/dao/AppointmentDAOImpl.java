/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hms.dao;

import com.hms.db.DataSouce;
import com.hms.model.Appointment;
import com.hms.model.Hospital;
import com.hms.model.Report;
import com.hms.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author iamsu
 */
public class AppointmentDAOImpl implements AppointmentDAO{

    DataSouce ds= new DataSouce();
    UserDAO ud=new UserDAOImpl();
    
    @Override
    public void createAppointment() {
        
    }

    @Override
    public int deleteAppointment() {
        int deleted=0;
        return 0;
    }

    @Override
    public List<Appointment> getAppointments(User user) throws SQLException,ClassNotFoundException {
        List<Appointment> appointments =new ArrayList<>();
        ds.createConnection();
        ResultSet rs=ds.getSt().executeQuery("select * from Appointments where "+user.getRole()+"Id = "+user.getId()+" ");
        while(rs.next()){
            appointments.add(new Appointment(rs.getInt("Id"),rs.getDate("appointmentdate"),ud.getPatient(rs.getInt("patientId")), ud.getDoctor(rs.getInt("doctorId")), rs.getString("problem")));
        }
        ds.closeConnection();
        return appointments;
    }
    
    public List<Hospital> getHospitals() throws SQLException, ClassNotFoundException{
        List<Hospital> hospitals =new ArrayList<>();
         ds.createConnection();
         ResultSet rs=ds.getSt().executeQuery("select * from Hospitals");
          while(rs.next()){
              hospitals.add(new Hospital(rs.getInt("Id"), rs.getString("hospitalName"), rs.getString("zipcode")));
          }
         ds.closeConnection();
        return hospitals;
    }
    
    public Appointment getAppointment(int appointmentId) throws SQLException, ClassNotFoundException{
        ds.createConnection();
        String str="select * from APPOINTMENTS where id="+appointmentId;
         ResultSet rs=ds.getSt().executeQuery(str);
         Appointment ap=new Appointment();
         ap.setErrorMessage("Start");
         if(rs.next()){
              ap=new Appointment(rs.getDate("appointmentdate"),ud.getPatient(rs.getInt("patientId")), ud.getDoctor(rs.getInt("doctorId")), rs.getString("problem"));
              ap.setId(appointmentId);
              ap.setErrorMessage("Loaded" + str);
         }
         ds.closeConnection();
        return ap;
    }
    
    public List<Report> getReports(int appointmentId) throws SQLException, ClassNotFoundException{
        ds.createConnection();
        String str="select * from reports where appointmentId="+appointmentId;
        ResultSet rs=ds.getSt().executeQuery(str);
        List<Report> rpList=new ArrayList<>();
         while(rs.next()){
              rpList.add(new Report(rs.getInt("Id"),rs.getInt("appointmentId"), rs.getString("description"), rs.getString("FileName")));
         }
        ds.closeConnection();
        return rpList;
    }
    
     public static void main(String[] arg) throws SQLException, ClassNotFoundException{
        AppointmentDAO ad= new AppointmentDAOImpl();
        
         System.err.println(ad.getReports(1001));
     }
}
