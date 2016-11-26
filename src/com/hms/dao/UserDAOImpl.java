/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hms.dao;

import com.hms.db.DataSouce;
import com.hms.model.Doctor;
import com.hms.model.Patient;
import com.hms.model.User;
import java.nio.ByteBuffer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iamsu
 */
public class UserDAOImpl implements UserDAO{
    
    User user;
    String table="User";
    String SQL="";
    DataSouce ds= new DataSouce();
    boolean isValidUser=false;
    DateFormat ndf = new SimpleDateFormat("dd/MM/yyyy");
    
    @Override
    public int addUser(User user) {
        int added=0;
        table=user.getRole();
        user.setErrorCode("404");
        user.setErrorMessage("Table "+table);
        try {
            if(table.equals("Doctor")){
                user.setErrorMessage("inserting "+table);
                Doctor d=(Doctor)user;            
                ds.createConnection();
                user.setErrorMessage("Object Changed "+ds.getSt());
                added=ds.getSt().executeUpdate("insert into "+table+" values ("+ds.getNewId(table)+",'"+user.getFirstName()+"', '"+user.getLastName()+"', '"+user.getMailId()+"', "+user.getSsn()+", '"+user.getPhone()+"', TO_DATE('"+ndf.format(user.getDob())+"','DD/MM/YYYY'), '"+user.getGender()+"', '"+user.getPassword()+"', '"+user.getZipCode()+"','"+d.getNpi()+"','"+d.getPracticeName()+"','"+d.getPracticeType()+"','"+d.getPosition()+"','"+user.getStatus()+"',sysdate)");
            }
            else{
               user.setErrorMessage("inserting "+table);
               Patient p=(Patient)user; 
               ds.createConnection();
               user.setErrorMessage("Object Changed "+ds.getSt());
               SQL="insert into "+table+" values ("+ds.getNewId(table)+",'"+user.getFirstName()+"', '"+user.getLastName()+"', '"+user.getMailId()+"', "+user.getSsn()+", '"+user.getPhone()+"', TO_DATE('"+ndf.format(user.getDob())+"','DD/MM/YYYY'), '"+user.getGender()+"', '"+user.getPassword()+"', '"+user.getZipCode()+"',"+p.getHeight()+","+p.getWeight()+",'"+user.getStatus()+"',sysdate)";
               user.setErrorMessage("Qwery "+SQL);
               added=ds.getSt().executeUpdate(SQL);
            }
            if(added>0){user.setErrorCode("404");user.setErrorMessage("Inserted "+user.getMailId());}
            ds.closeConnection();
        } catch (Exception ex) {
            user.setErrorCode(ex.toString());
            user.setErrorMessage(ex.getMessage());
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return added;
    }

    @Override
    public int updateUser(User user) {
        int updated=0;
        try {
            ds.createConnection();
            if(table.equals("Doctor")){
                Doctor d=(Doctor)user;            
                ds.createConnection();
                updated=ds.getSt().executeUpdate("");
            }
            else{
               Patient p=(Patient)user; 
               updated=ds.getSt().executeUpdate("");
            }
            ds.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return updated;
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public List<User> getDoctors(String s) throws SQLException, ClassNotFoundException {
        List<User> doctorList =new ArrayList<>();
        ds.createConnection();
        ResultSet rs=ds.getSt().executeQuery("select * from Doctor where PracticeName like '%"+s+"%'");
        User u=null;
        while(rs.next()){
            u=new Doctor(rs.getString("firstName"), rs.getString("lastName"), rs.getString("mailId"), 10001, rs.getString("phone"), rs.getDate("dob"), rs.getString("gender").charAt(0), "Doctor", rs.getString("zipcode"));
            doctorList.add(u);
        }
        ds.closeConnection();
        return doctorList;
    }

    @Override
    public void verifyUser(User user) {
        try {
            table=user.getRole();
            ds.createConnection();
            ResultSet rs=ds.getSt().executeQuery("select * from "+table+" where mailId = '"+user.getMailId()+"'");
            user.setErrorCode("404");
            user.setErrorMessage(table);
            if(rs.next()){
                byte[] ssn=rs.getBytes("ssn");
                user.setErrorCode("404");
                user.setErrorMessage("Record Found");
                if(rs.getString("password").equals(user.getPassword())){
                    user.setErrorMessage("Password Matched");
                    user.setId(rs.getInt("Id"));
                    user.setFirstName(rs.getString("firstName"));
                    user.setLastName(rs.getString("lastName"));
                    ByteBuffer buffer = ByteBuffer.wrap(ssn);
                    user.setSsn(buffer.getLong());
                    user.setPhone(rs.getString("Phone"));
                    user.setDob(rs.getDate("dob"));
                    user.setGender(rs.getString("gender").charAt(0));
                    user.setZipCode(rs.getString("zipCode"));
                    if(table.equals("Doctor")){
                        Doctor d=(Doctor)user;        
                        user.setErrorMessage("Object To "+table);
                        d.setPracticeType(rs.getString("PracticeType"));
                        d.setPracticeName(rs.getString("PracticeName"));
                        d.setPosition(rs.getString("Position"));
                        d.setNpi(rs.getLong("npi"));
                    }
                    else{
                        Patient p=(Patient)user; 
                        p.setHeight(rs.getFloat("height"));
                        p.setWeight(rs.getFloat("weight"));
                    }
                    isValidUser=true;
                    this.user=user;
                }
            }
            ds.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean isValidUser() {
        return isValidUser;
    }
    
    public Patient getPatient(int patientId) throws SQLException, ClassNotFoundException {
        ds.createConnection();
        ResultSet rs=ds.getSt().executeQuery("select * from patient where Id = "+patientId);
        User u=null;
        if(rs.next()){
            u=new Patient(rs.getString("firstName"), rs.getString("lastName"), rs.getString("mailId"), 10001, rs.getString("phone"), rs.getDate("dob"), rs.getString("gender").charAt(0), "patient", rs.getString("zipcode"));
        }
        ds.closeConnection();
        return (Patient)u;
    }
    
    public Doctor getDoctor(int doctorId) throws SQLException, ClassNotFoundException {
        ds.createConnection();
        ResultSet rs=ds.getSt().executeQuery("select * from Doctor where Id = "+doctorId);
        User u=null;
        if(rs.next()){
            u=new Doctor(rs.getString("firstName"), rs.getString("lastName"), rs.getString("mailId"), 10001, rs.getString("phone"), rs.getDate("dob"), rs.getString("gender").charAt(0), "Doctor", rs.getString("zipcode"));
        }
        ds.closeConnection();
        return (Doctor)u;
    }
    
    public User getUser(int userId,String table) throws SQLException, ClassNotFoundException {
        ds.createConnection();
        ResultSet rs=ds.getSt().executeQuery("select * from "+table+" where Id = "+userId);
        User u=null;
        if(rs.next()){
            if(table.equals("Doctor")){
                u=new Doctor(rs.getString("firstName"), rs.getString("lastName"), rs.getString("mailId"), 10001, rs.getString("phone"), rs.getDate("dob"), rs.getString("gender").charAt(0), "Doctor", rs.getString("zipcode"));
            }
            else{
                u=new Patient(rs.getString("firstName"), rs.getString("lastName"), rs.getString("mailId"), 10001, rs.getString("phone"), rs.getDate("dob"), rs.getString("gender").charAt(0), "patient", rs.getString("zipcode"));
            }
        }
        ds.closeConnection();
        return (Doctor)u;
    }
    
    public List<Doctor> getSpecialists() throws SQLException, ClassNotFoundException{
        List<Doctor> specialList =new ArrayList<>();
        ds.createConnection();
        ResultSet rs=ds.getSt().executeQuery("select distinct(PRACTICENAME),PRACTICETYPE,Position,npi from Doctor");
        Doctor d=null;
        while(rs.next()){
           d=new Doctor(Long.parseLong(rs.getString("npi")),rs.getString("PRACTICENAME"),rs.getString("PRACTICETYPE"),rs.getString("Position"));
           specialList.add(d);
        }
        ds.closeConnection();
        return specialList;
    }
    
    public static void main(String[] arg) throws SQLException, ClassNotFoundException{
        DataSouce ds=new DataSouce();
        ds.createConnection();
        UserDAOImpl ud=new UserDAOImpl();
        User user = new Patient("iamsukeshk@hotmail.com","q");
        user.setRole("Patient");
        ud.verifyUser(user);
        System.out.print(user.getErrorCode() +" :"+ud.isValidUser+": "+user.getErrorMessage());
        ds.closeConnection();
    } 
}

