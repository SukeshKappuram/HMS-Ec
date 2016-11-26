<%-- 
    Document   : Register
    Created on : Mar 10, 2016, 6:57:03 PM
    Author     : BackOffice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .Banner{
                background-image: url("http://www.powerhms.com/images/3.jpg");
                background-size: 100% 600px;
                float: left;
                width: 70%;
                height: 600px;
                color: #808000;
                font-size: 50px;
            }
            .register table{
                width: 200%;
                float: right;
            }
            .register td input{
                width: 40%;
                height: 40px;
                text-align: center;
                border: none;
                background: #d9dee2;
                border-radius: 10px;
            }
            .register td input[type=radio]{
                width: 20px;
                height: 20px;
                text-align: center;
                border: none;
            }
            #data{
                border-style: none none ridge none;
                border-color: #cccccc;
                border-width: 1px;
            }
            #data:focus{
                border-color: #ff6600;
            }
            .register td input[type=submit]{
                border-radius: 10px;
                background-color: #808000;
                color:aliceblue;
                border: none;
            }
            .register input:focus{
                outline: none;
                border-bottom: #808000 solid 2px;
            }
            .register td{
                text-align: center;
            }
        </style>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="Banner" >
                <p>Sign Up as ${param.r}</p>
        </div>
        
        <form action="Authenticate" class="register" method="POST" style="float:right;">
                <table>
                    <tr>
                        <td><input type="email" name='mailId' placeholder="Mail Id" required="required"/><br/><br/></td>
                    </tr>
                    <tr>
                        <td><input type="text" name='firstName' placeholder="First Name" required="required"/> 
                            <input type="text" name='lastName' placeholder="Last Name" required="required"/><br/><br/></td>
                    </tr>
                    <tr>
                        <td><input type="text" name='phone' placeholder="Mobile Number" required="required"/><br/><br/></td>
                    </tr>
                    <c:if test="${param.r!='Doctor'}">
                    <tr>
                        <td><input type="number" name='height' placeholder="Height" required="required"/>
                        <input type="number" name='weight' placeholder="Weight" required="required"/><br/><br/></td>
                    </tr>
                    </c:if>
                    <c:if test="${param.r=='Doctor'}">
                    <tr>
                        <td><input type="text" name='practiceName' placeholder="Practice Name" required="required"/>
                        <input type="text" name='practiceType' placeholder="Practice Type" required="required"/><br/><br/></td>
                    </tr>
                    </c:if>
                    <tr>
                        <td><input type="radio" name='gender' value="Male" checked="checked"/><small> Male </small> &nbsp;&nbsp;&nbsp;&nbsp;
                            <input type="radio" name='gender' value="Female" /><small> Female </small></td>
                    </tr>
                    <tr>
                        <td><input type="date" name='dob' title="Date of Birth" placeholder="DOB" required="required"/><br/><br/></td>
                    </tr>
                    <c:if test="${param.r=='Doctor'}">
                    <tr>
                        <td><input type="text" name='position' placeholder="Position" required="required"/>
                        <input type="text" name='npi' placeholder="NPI" required="required"/><br/><br/></td>
                    </tr>
                    </c:if>
                    <tr>
                        <td><input type="tel" name='ssn' placeholder="Social Security Number" required="required"/><br/><br/></td>
                    </tr>
                    <tr>
                        <td><input type="text" name='zipcode' placeholder="Zip Code" required="required"/><br/><br/></td>
                    </tr>
                    <tr>
                        <td><input type="password" name='password' placeholder="Password" required="required"/>
                        <input type="password" name='cpassword' placeholder="Confirm Password" required="required"/><br/><br/></td>
                    </tr>
                    <tr>
                         <td><input type="hidden" name='role' value="${param.r}"/></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Register"/></td>
                    </tr>
                    <tr>
                        <td><a href="index.jsp?r=${param.r}">already registered ?</a></td>
                    </tr>
                </table>
        </form>
        <%@include file="footer.html" %>
    </body>
</html>