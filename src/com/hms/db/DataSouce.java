/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hms.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author iamsu
 */
public class DataSouce {
    private String url="jdbc:oracle:thin:@localhost:1521:XE";
    private String user="HMS";
    private String password="HMS";
    private String clazz="oracle.jdbc.driver.OracleDriver";
    
    Connection con;
    Statement st;
            
    public void createConnection() throws SQLException, ClassNotFoundException{
        Class.forName(clazz);
        con=DriverManager.getConnection(url, user, password);
        st=con.createStatement();
        System.out.println("Connection Created Successfully!!");
    }
    
    public int getNewId(String table) throws SQLException{
        int id=1001;
            ResultSet rs=st.executeQuery("select Max(Id)+1 from "+table);
            if(rs.next()){
                id=rs.getInt(1);
                if(id<1001){id=1001;}
            }
            rs.close();
        return id;
    }
    
    public void closeConnection() throws SQLException{
        st.close();
        con.close();
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public Statement getSt() {
        return st;
    }

    public void setSt(Statement st) {
        this.st = st;
    }
    
    public static void main(String[] arg) throws SQLException, ClassNotFoundException{
        DataSouce ds=new DataSouce();
        ds.createConnection();
        System.err.println(ds.getNewId("patient"));
        ds.closeConnection();
    }
}
