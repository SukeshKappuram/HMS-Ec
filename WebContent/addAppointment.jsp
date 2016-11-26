<%-- 
    Document   : addAppointment
    Created on : Nov 24, 2016, 1:00:49 AM
    Author     : iamsu
--%>

<%@page import="com.hms.model.User"%>
<%@page import="com.hms.model.Doctor"%>
<%@page import="com.hms.dao.UserDAOImpl"%>
<%@page import="com.hms.dao.UserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .user .row{
              color: white;
              background-color: #808000;    
              padding: 2% 30px 2% 30px;
            }
            .user .row .col-xs-4{
                text-align: center;
            }
            .user .row .col-xs-4 a{
                color: whitesmoke;
            }
        </style>
    </head>
    <body>
       <%@include file="Welcome.jsp" %>
       <%
        String s="";
       %>
       <c:if test="${not empty param.s}" >
           <% s=request.getParameter("s"); %>
       </c:if>
        <div class="container">
            <h2>Appointment</h2>
            <form action="Appointment.do">
                <div class="form-group">
                    <label for="pur">Doctor</label>
                    <select class="form-control" id="pur" name="doctorId">
                        <option>Select Doctor</option>
                        <%
                            for(User u:ud.getDoctors(s)){
                                Doctor d=(Doctor)u;
                                %>
                                    <option value="<%=d.getId()%>"> <%=d.getFirstName()%> <%=d.getLastName()%> </option>
                                <%
                            }
                        %>
                        
                    </select>
                </div>
                <input type="text" value="${user.id}" name="patientId">
                <div class="form-group">
                    <label for="dt">Date</label>
                    <input type="date" class="form-control" id="dt" name="dt" placeholder="Enter Date">
                </div>
                <div class="form-group">
                    <label for="tm">Time</label>
                    <input type="time" class="form-control" id="tm" name="tm" placeholder="Enter Time">
                </div>
                <div class="form-group">
                    <label for="res">Reason</label>
                    <textarea class="form-control" id="res" placeholder="Reason" name="problem" cols="30" rows="3"></textarea>
                </div>
                <div class="checkbox">
                    <label><input type="checkbox"> Visited Previously</label>
                </div>
                <button type="submit" class="btn btn-success">Create Appointment</button>
            </form>
        </div>
        <%@include file="footer.html" %>
    </body>
</html>