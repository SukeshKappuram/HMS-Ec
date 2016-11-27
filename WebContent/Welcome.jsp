<%-- 
    Document   : Welcome
    Created on : Nov 24, 2016, 12:50:51 AM
    Author     : iamsu
--%>

<%@page import="com.hms.model.Hospital"%>
<%@page import="com.hms.model.Doctor"%>
<%@page import="com.hms.model.Appointment"%>
<%@page import="com.hms.model.User"%>
<%@page import="com.hms.dao.*" %>
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
        <%@include file="header.jsp" %>
        <div class="user">
            <div class="row">
                <div class="col-xs-4"><a href="Welcome.jsp?app=s">Specialist</a></div>
                <div class="col-xs-4"><a href="Welcome.jsp?app=h">Clinics</a></div>
                <div class="col-xs-4"><a href="Welcome.jsp?app=y">Appointments</a></div>
            </div>
        </div>
        
        <div class="search">
            <form>
                <div id="container">
                    <div id="search-container" >
                        <button type="submit" class="btn btn-primary btn-sm" style="float: right;">Search</button>
                        <input id="search" class="form-control input-sm" maxlength="64" type="text" style="float: right;" placeholder="Search"/>
                        <ul></ul>
                    </div>
                </div>
            </form>
            <div>
            <img class="dImage" src="http://katarzyna-parkot.pl/img/tooth.png" alt="Dental"/>
            <img class="dImage" src="http://www.graybill.org/wp-content/uploads/2016/03/cardiology-icon.png" alt="cardiologist"/>
            <img class="dImage" src="https://practo-fabric.s3.amazonaws.com/chatterjee-skin-care-center-delhi-1446450760-563716483e7cc.jpg" alt="Dermatologist"/>
            <img class="dImage" src="https://cdn2.iconfinder.com/data/icons/medical-specialties-1/256/Neurology-512.png" alt="Neurologist"/>
            <img class="dImage" src="http://unconfirmedbreakingnews.com/wp-content/uploads/2014/03/8059487-757877-head-brain-vector-icon.jpg" alt="Psychiatrist"/>
            <img class="dImage" src="http://rathiorthoclinic.com/images/knee-icon2.png" alt="Orthopedic Surgeon"/>
            <img class="dImage" src="http://www.ogdenclinic.com/Static/ENT/desktop/img/throatIcon_2x.png" alt="ENT Specialist"/>
            <img class="dImage" src="http://www.mcw.edu/Medical-School-FileLibrary/DEPT-Graduate-School/icons/large/Grad_Physiology_Icon.png" alt="Physiologist"/>
            </div>
        </div>
        <!--
        <%--<jsp:useBean id="ad" scope="session" class="com.hms.dao.AppointmentDAOImpl">
        <div class="appointments">
            Hello1
                        <c:forEach var="x" items="${ad.getAppointments(user)}">
                            Hello
                            <c:out value="${x}"/>
                        </c:forEach>
                    
        </div>
        </jsp:useBean>--%>-->
        
        <br/><br/>
        <div class="container">
        <%
            User user = (User)session.getAttribute("user");
            AppointmentDAO ad=new AppointmentDAOImpl();
            UserDAO ud=new UserDAOImpl();
        %>
        <c:if test="${param.app=='y'}">
        <table class = "table table-striped">
            <caption>Appointments <c:if test="${user.role=='Patient'}"><a href="addAppointment.jsp" title="New Appointment"><i class="glyphicon glyphicon-plus" style="color: #808000;background-color: #f1f1f1;font-size: 30px;"></i></a></c:if></caption>
            <thead>
                <tr>
                    <c:if test="${user.role=='Patient'}">
                        <th>Doctor</th>
                    </c:if>
                    <c:if test="${user.role=='Doctor'}">
                        <th>Patient</th>
                    </c:if>
                    <th>Appointment Time</th>
                    <th>Problem</th>
                    <th>Modify</th>
                </tr>
            </thead>
            <tbody>
        <%
            for(Appointment a:ad.getAppointments(user)){
                %>
                    <tr>
                        <c:if test="${user.role=='Patient'}">
                            <td><a href='Report.do?app=<%=a.getId()%>'><%=a.getDoctor().getFirstName()%></a></td>
                        </c:if>
                        <c:if test="${user.role=='Doctor'}">
                            <td><a href='Report.do?app=<%=a.getId()%>'><%=a.getPatient().getFirstName()%></a></td>
                        </c:if>
                        <td><%=a.getAppointmentdate()%></td>
                        <td><%=a.getProblem()%></td>
                        <td> <a href='addAppointment.jsp?edit=<%=a.getId()%>'> <i class="fa fa-pencil"> </i> </a> &nbsp &nbsp <a href='Appointment.do?del=<%=a.getId()%>'> <i class="fa fa-trash"> </i> </a> </td>
                    </tr>
                <%
            }
        %>
            </tbody>
        </table>
        </c:if>
        <c:if test="${param.app=='s'}">
        <table class = "table table-striped">
            <caption>Specialists</caption>
            <thead>
                <tr>
                    <th>Practice Name</th>
                    <th>Practice Type</th>
                    <th>Position</th>
                </tr>
            </thead>
            <tbody>
        <%
            for(User u:ud.getSpecialists()){
                Doctor d=(Doctor)u;
                %>
                    <tr>
                        <td><a href='addAppointment.jsp?s=<%=d.getPracticeName()%>'><%=d.getPracticeName()%></a></td>
                        <td><%=d.getPracticeType()%></td>
                        <td><%=d.getPosition()%></td>
                    </tr>
                <%
            }
        %>
            </tbody>
        </table>
        </c:if>
        <c:if test="${param.app=='h'}">
        <table class = "table table-striped">
            <caption>Hospitals</caption>
            <thead>
                <tr>
                    <th>Hospital Name</th>
                    <th>Zip Code</th>
                </tr>
            </thead>
            <tbody>
        <%
            for(Hospital h:ad.getHospitals()){
                %>
                    <tr>
                        <td><a href='Welcome.jsp?app=s'><%=h.getHospitalName()%></a></td>
                        <td><a href='addAppointment.jsp?h=<%=h.getId()%>'><%=h.getZipcode()%></a></td>
                    </tr>
                <%
            }
        %>
            </tbody>
        </table>
        </c:if>
        </div>
        <%@include file="footer.html" %>
    </body>
</html>
