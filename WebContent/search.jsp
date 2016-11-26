<%-- 
    Document   : search
    Created on : Mar 28, 2016, 2:03:22 PM
    Author     : BackOffice
--%>
 <%@page import="com.hms.db.DataSouce"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            
        </script>
    </head>
    <body>
       
<%
try{
	String searchbox = request.getParameter("input");
	//String searchbox = "s";
        
	DataSouce db=new DataSouce();
        db.createConnection();
	String query = "select * from Hospitals where HospitalName like '%"+searchbox+"%' or zipcode like '%"+searchbox+"%'";
        Statement st = db.getSt();
	ResultSet rs = st.executeQuery(query);
	String result = "";
	while(rs.next()){
            result += "<li><a href='Welcome.jsp?app=s'>"+rs.getString(2)+"</a></li>";
	}
	out.println(result);
	db.closeConnection();
}catch(Exception e){
	out.println(e);
}
%>
    </body>
</html>
