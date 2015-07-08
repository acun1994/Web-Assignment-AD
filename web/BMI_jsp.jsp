<%-- 
    Document   : BMI_jsp
    Created on : 08-Jul-2015, 09:57:56
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="resources/css/bootstrap.css" type="text/css"/>
        <script src="resources/js/jquery.js" type="text/javascript"></script>
        <script src="resources/js/bootstrap.js" type="text/javascript"></script>
    </head>
    <body>
        <div class ="container">
            <%@include file = "navbar.html"%>
            
        <h1 class =" text-center"> BMI Calculator </h1>
        <div>
            <form name="bmiform" action="./BMI_jsp.jsp">
                    Height: <input type="text" class="form-control" name="height" value = "<%if (request.getParameter("height")!=null) out.println(request.getParameter("height"));%>" placeholder="Height in metres"><br>
                    Weight: <input type="text" class="form-control" name="weight" value = "<%if (request.getParameter("weight")!=null) out.println(request.getParameter("weight"));%>" placeholder="Weight in kg"><br>
                    <input type="submit" class="btn btn-default">
                    <a href="./BMI_jsp.jsp" type="button" class="btn btn-default"> Reset </a>
            </form>  
        </div>
        <% if ((request.getParameter("height")!=null) && (request.getParameter("weight")!=null)){ %>
        
        <%
            boolean err_flg = false;
            if (request.getParameter("height")==""){
                out.println("<div class='text-center'>Missing height value</div>");
                err_flg = true;
            }
                    
            if (request.getParameter("weight")==""){
                out.println("<div class='text-center'>Missing weight value</div>");
                err_flg = true;
            }
            
            if (err_flg) return;
                
            double height = Double.parseDouble(request.getParameter("height"));
            double weight = Double.parseDouble(request.getParameter("weight"));
            
            double bmi=weight/height/height;
        %>
        <table align="center">
            <tr>
                <td class = "text-right"> Height : </td>
                <td> <%= height%> m</td>
            </tr>
            <tr>
                <td class = "text-right"> Weight : </td>
                <td> <%= weight%> kg</td>
            </tr>
            <tr>
                <td class = "text-right"> BMI : </td>
                <td> <%= String.format("%.2f", bmi)%> </td>
            </tr>
            <tr>
                <td colspan ="2"><%
                    if (bmi<18.5) out.println("You are underweight");
                    else if (bmi<25) out.println("You are of normal weight");
                    else if (bmi<30) out.println("You are overweight");
                    else out.println("You are obese");
            }%>
                </td>
            </tr>
        </table>
        
        </div>
    </body>
</html>
