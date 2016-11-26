<%-- 
    Document   : Login
    Created on : Mar 10, 2016, 3:26:46 PM
    Author     : BackOffice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            td input{
                width: 220px;
                height: 30px;
                text-align: center;
                border-radius: 10px;
            }
            td input[type=radio]{
                width: 20px;
                height: 10px;
                text-align: center;
                border-radius: 10px;
            }
            td{
                text-align: center;
            }
        </style>
    </head>
    <body>
        <div style="margin-left: 100px;">
        <form action="Authenticate" method="POST" target="_top">
            <fieldset>
                <legend>${param.r} Login </legend>
                <table align="center">
                    <tr>
                        <td><input type="text" name='mailId' placeholder="Login Id" required="required"/></td>
                    </tr>
                    <tr>
                        <td><input type="password" name='password' placeholder="Password" required="required"/></td>
                    </tr>
                     <tr>
                         <td><input type="hidden" name='role' value="${param.r}"/></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Login"/></td>
                    </tr>
                    <tr>
                        <td><a href="">Forgot Password ?</a></td>
                    </tr>
                    <tr>
                        <td><a href="signUp.jsp?r=${param.r}">New User ?</a></td>
                    </tr>
                </table>
            </fieldset>
        </form>
        </div>
    </body>
</html>
