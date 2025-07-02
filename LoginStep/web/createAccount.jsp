<%-- 
    Document   : createAccount
    Created on : Jul 2, 2025, 9:56:04 AM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
            <c:set var="errors" value="${requestScope.CREATE_ERRORS}" />
            PhoneNumber* <input type="text" name="txtPhoneNumber" value="${param.txtPhoneNumber}" /><br/>
            <c:if test="${not empty errors.phoneNumberNotFormat}">
                <font color="red">
                ${errors.phoneNumberNotFormat} 
                </font> <br/>
            </c:if> 
            <c:if test="${not empty errors.phoneNumberIsExist}">
                <font color="red">
                ${errors.phoneNumberIsExist} 
                </font> <br/>
            </c:if> 
            Password* <input type="password" name="txtPassword" value="" /><br/>
            <c:if test="${not empty errors.passwordNotLengthErr}">
                <font color="red">
                ${errors.passwordNotLengthErr}
                </font> <br/>
            </c:if>
            Confirm <input type="text" name="txtConfirm" value="" /><br/>
            <c:if test="${not empty errors.confirmNotMatch}">
                <font color="red">
                ${errors.confirmNotMatch} 
                </font> <br/>
            </c:if>
                FullName* <input type="text" name="txtFullName" value="${param.txtFullName}" /><br/>
            <c:if test="${not empty errors.fullNameNotLengthErr}">
                <font color="red">
                ${errors.fullNameNotLengthErr} 
                </font> <br/>
            </c:if>
            <input type="submit" value="Registration" name="btAction" />
            <input type="reset" value="Reset" name="btAction" />
        </form>
    </body>
</html>
