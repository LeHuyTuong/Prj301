<%-- 
    Document   : createAccount
    Created on : Jul 2, 2025, 9:56:04 AM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Create new Account </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Create new Account</h1>
        <form action="DispatchServlet" method="POST">
        
        Username* <input type="text" name="txtUsername" value="" /><br/>
        Password* <input type="password" name="txtPassword" value="" /><br/>
        Confirm <input type="text" name="txtConfirm" value="" /><br/>
        FullName* <input type="text" name="txtFullName" value="" /><br/>
        <input type="submit" value="Registration" name="btAction" />
        <input type="reset" value="Reset" name="btAction" />
        </form>
    </body>
</html>
