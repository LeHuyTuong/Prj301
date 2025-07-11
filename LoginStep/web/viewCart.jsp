<%-- 
   Document   : viewCart
   Created on : Jul 6, 2025, 5:53:46 PM
   Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online Shopping</title>
    </head>
    <body>
        <h1>Your cart include</h1>
        <c:set var="cart" value="${sessionScope.CART}"/>
        <c:if test="${not empty cart and not empty cart.items}" >
            <form action="cart" method="POST">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>Item</th>
                            <th>Count</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <c:forEach var="entry" items="${cart.items}" varStatus="counter">
                        <tbody>
                            <tr>
                                <td>${counter.count}</td>
                                <td>${entry.key}</td>
                                <td>${entry.value}</td>
                                <td>
                                    <input type="checkbox" name="chkItems" value="${entry.key}"/>
                                </td>
                            </tr>
                        </tbody>
                    </c:forEach>

                    <input type="submit" value="Remove" name="btAction" />
                </table>
            </form>
        </c:if>
        <c:if test="${empty cart}" >
            No items
        </c:if><br/>
        <a href="onlineShopping.jsp">Continue Shopping</a>


    </body>
</html>
