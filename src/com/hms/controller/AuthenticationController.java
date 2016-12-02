/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hms.controller;

import com.hms.dao.UserDAO;
import com.hms.dao.UserDAOImpl;
import com.hms.model.Doctor;
import com.hms.model.Patient;
import com.hms.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author 11502-CL02
 */
@WebServlet(name = "AuthenticationController", urlPatterns = {"/Authenticate"})
public class AuthenticationController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        PrintWriter out=response.getWriter();
        
        try{
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session=request.getSession();
        String referer=request.getHeader("referer");
        String mailId=request.getParameter("mailId");
        String password=request.getParameter("password");
        String role=request.getParameter("role");
        UserDAO ud=new UserDAOImpl();
        User u=null;
        RequestDispatcher rd=request.getRequestDispatcher("index.jsp?r="+role);
        if(referer.contains("index")){
            if(role.equals("Doctor")){
                u=new Doctor(mailId, password);
            }
            else{
                u=new Patient(mailId, password);
            }
            u.setRole(role);
            ud.verifyUser(u);
            session.setAttribute("user", ud.getUser());
             if(ud.isValidUser()){
                 out.println("<script>alert('Login Successfull!!!');</script>");
                 rd=request.getRequestDispatcher("Welcome.jsp?app=y");
             }
        }
        else{
            String firstName=request.getParameter("firstName");
            String lastName=request.getParameter("lastName");
            long ssn=Long.parseLong(request.getParameter("ssn"));
            
            //====Date Conversion
            
            String dBirth=request.getParameter("dob");
            Date dob=null;
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            try {
                dob = df.parse(dBirth);
            } catch (ParseException e) {
                    e.printStackTrace();
            }
            //=====
            
            char gender=request.getParameter("gender").charAt(0);
            
            String zipCode=request.getParameter("zipcode");
            String phoneNumber=request.getParameter("phoneNo");
            String cPassword=request.getParameter("cpassword");
            
            if(password.equals(cPassword)){
                if(role.equals("Doctor")){
                    long npi=Long.parseLong(request.getParameter("npi"));
                    String practiceName=request.getParameter("practiceName");
                    String practiceType=request.getParameter("practiceType");
                    String position=request.getParameter("position");
                    u=new Doctor(npi, practiceName, practiceType, position, firstName, lastName, mailId, ssn, role, dob, gender, password, role, zipCode);
                }
                else{
                    float height=Float.parseFloat(request.getParameter("height"));
                    float weight=Float.parseFloat(request.getParameter("weight"));
                    u=new Patient(height, weight, firstName, lastName, mailId, ssn, role, dob, gender, password, role, zipCode);
                }
                u.setStatus("Active");
                if(ud.addUser(u)>0){
                    out.println("<script>alert('Registration Successfull!!!');</script>");
                } 
                
            }
            else{
               out.println("Password does not match");
               rd=request.getRequestDispatcher("signUp.html");
           }
        }
        if(!ud.isValidUser()){
            out.print(u.getErrorCode() +" :: "+u.getErrorMessage());
        }
        rd.forward(request, response);
        }catch(Exception e){
           //out.println(e);
           response.sendRedirect("index.jsp");
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AuthenticationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AuthenticationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
