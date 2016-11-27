package com.hms.controller;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hms.dao.AppointmentDAO;
import com.hms.dao.AppointmentDAOImpl;
import com.hms.dao.UserDAO;
import com.hms.dao.UserDAOImpl;
import com.hms.model.Appointment;
import com.hms.model.Doctor;
import com.hms.model.Patient;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

/**
 * Servlet implementation class AppointmentController
 */
@WebServlet("/Appointment.do")
public class AppointmentController extends HttpServlet {
    
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, ClassNotFoundException, SQLException, java.text.ParseException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String appId=request.getParameter("del");
		try{
			int apptId=Integer.parseInt(appId);
			AppointmentDAO ad=new AppointmentDAOImpl();
			ad.deleteAppointment(apptId);
			response.sendRedirect("Welcome.jsp?app=y");
		}catch(Exception e){}
		UserDAO ud=new UserDAOImpl();
		String appointmentId=request.getParameter("appId");
		String doctorId=request.getParameter("doctorId");
        Doctor d=ud.getDoctor(Integer.parseInt(request.getParameter("doctorId")));
        String patientId=request.getParameter("patientId");
        Patient p=ud.getPatient(Integer.parseInt(request.getParameter("patientId")));
        Date appointmentdate=null;
        String dt=request.getParameter("dt");
        String tm=request.getParameter("tm");
        String problem=request.getParameter("problem");
        
        String appmtDt=dt+" "+tm+":00";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
        	appointmentdate = df.parse(appmtDt);
        	out.print(appointmentdate);
        } catch (ParseException e) {
                e.printStackTrace();
        }
        AppointmentDAO ad=new AppointmentDAOImpl();
        Appointment apt=new Appointment(appointmentdate, p, d, problem);
        try{
        	out.print("HI "+appointmentId);
        	if(!appointmentId.isEmpty()){out.print("There");
        		ad.updateAppointment(Integer.parseInt(appointmentId), apt);
        	}
        }catch(Exception e){
        	//out.print(e);
        	ad.createAppointment(apt);
        }
        response.sendRedirect("Welcome.jsp?app=y");
	}
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AuthenticationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AuthenticationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
