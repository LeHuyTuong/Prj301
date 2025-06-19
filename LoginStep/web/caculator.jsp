<%-- 
    Document   : caculator
    Created on : Jun 19, 2025, 11:28:53 AM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Calculator</title>
    </head>
    <body>
        <form action="DispatchServlet">
            Number 1 <input type="text" name="txtNum1" value="" /> </br>
            Number 2 <input type="text" name="txtNum2" value="" /> </br>
            <input type="submit" value="Caculator" name="btAction" />
            <input type="reset" value="Reset" />
        </form> </br>
        Total <b>${sessionScope.result}</b>

        
    </body>
</html>
