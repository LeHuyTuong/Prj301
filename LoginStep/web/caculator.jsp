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
        Total <b>${applicationScope.result}</b>
        <form method="POST">          
            Num 1 <input type="text" name="num1" value="${param.num1}" /> <br/>
            Num 2 <input type="text" name="num2" value="${param.num2}" /> <br/>
            Total : ${param["num1"] + param.num2} <br/>
            Avg : ${ (param.num1 + param["num2"]) / 2 } <br/>
            <input type="submit" value="Calculate" />
        </form>
            <a href="login.html">Return to login page</a>
    </body>
</html>
