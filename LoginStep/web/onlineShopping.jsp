<%-- 
    Document   : onlineShopping
    Created on : Jul 8, 2025, 6:21:01 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Book Store</h1>
        <form action="searchItem">
            SearchName <input type="text" name="txtSearchItem" value="${param.txtSearchItem}" />
            <input type="submit" value="SearchItem" name="btAction" />
        </form>
        <c:set var="searchItem" value="${param.txtSearchItem}" />
        <c:if test="${not empty searchItem}" >
            <c:set var="items" value="${requestScope.ITEM_VALUE}" />
            <c:if test="${not empty items}" >
                <table border="1">
                    <thead>
                        <tr>
                            <th>ItemID</th>
                            <th>Name</th>
                            <th>Price</th>
                        </tr>
                    </thead>
                    <c:forEach var="dto" items="${items}" varStatus="counter" >
                        <tbody>
                            <tr>
                                <td>
                                    ${dto.itemID}
                                </td>
                                <td>
                                    ${dto.name}
                                </td>
                                <td>
                                    ${dto.price}
                                </td>
                            </tr>
                        </tbody>
                    </c:forEach>
                </table>

                <form action="DispatchServlet">
                    Choose your items<select name="cboBook">

                    </select><br/>
                    <input type="submit" value="Add item to cart" name="btAction" />
                    <input type="submit" value="View your cart" name="btAction" />
                </form>
            </c:if>
            <c:if test="${empty items}" >
                No recording
            </c:if>
        </c:if>
    </body>
</html>
