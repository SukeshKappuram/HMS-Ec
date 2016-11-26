<%-- 
    Document   : viewAppointments
    Created on : Nov 24, 2016, 12:59:32 AM
    Author     : iamsu
--%>

<%@page import="com.hms.model.Report"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="Welcome.jsp"%>
        <%
            Appointment apps=(Appointment)session.getAttribute("appointment");
        %>
        <div class="container">
        <c:if test="${user.role=='Doctor'}">
        <div class="row">
            <div class="col-md-4">
                <b>Appointment Date</b>
            </div>
            <div class="col-md-4">
                <b>Doctor</b>
            </div>
            <div class="col-md-4">
                <b>Patient</b>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
                ${appointment.getAppointmentdate()}
            </div>
            <div class="col-md-4">
                ${appointment.getDoctor().getFirstName()} ${appointment.getDoctor().getLastName()}
            </div>
            <div class="col-md-4">
                ${appointment.getPatient().getFirstName()} ${appointment.getPatient().getLastName()}
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
            <form method="POST" action="Upload.do" enctype="multipart/form-data">
                <input type="hidden" name="apptId" value="${appointment.id}"/>
                <div class="form-group">
                <label for="desc">Prescription</label>
                <textarea class="form-control" rows="4" placeholder="reason" name="desc"></textarea>
                </div>
                <div class="form-group">
                <label for="file">Upload Reports</label>
                <input type="file" name="data" />
                </div>
                <input type="submit" class="btn btn-default" value="Upload" />
            </form>
            </div>    
        </div>
        </c:if>
            
            <div class="row">
                `<table class = "table table-striped">
            <caption>Reports </caption>
            <thead>
                <tr>
                    <th>Appointment Time</th>
                    <th>Description</th>
                    <th>Reports</th>
                </tr>
            </thead>
            <tbody>
        <%
            for(Report a:ad.getReports(apps.getId())){
                %>
                    <tr>
                        <td><a href='Report.do?app=<%=a.getId()%>'><%=a.getAppintmentId()%></a></td>
                        <td><%=a.getDescription()%></td>
                        <td><a href='assets/reports/<%=a.getFileName()%>'><%=a.getFileName()%></a></td>
                    </tr>
                <%
            }
        %>
            </tbody>
        </table>
            </div>
      </div>      
    </body>
</html>
