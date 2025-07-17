<%-- 
    Document   : addNewItem
    Created on : Jul 16, 2025, 8:44:44 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>DashBoard</h1>
        <c:set var="user" value="${sessionScope.USER_INFO}" />
        Welcome he he ${user.name}
        <form action="cart" method="POST">
            Price <input type="text" name="txtPrice" value="" /><br/>
            Name <input type="text" name="txtName" value="" /><br/>
            <input type="submit" value="Add New Item" name="btAction" />
        </form>
    </body>
</html>
