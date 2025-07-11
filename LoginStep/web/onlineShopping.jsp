<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Book Store</title>
    </head>
    <body>
        <h1>Book Store</h1>

        <form action="cart">
            Search Name: <input type="text" name="txtSearchItem" value="${param.txtSearchItem}" />
            <input type="submit" value="Search Item" name="btAction" />
        </form>

        <form action="cart" style="margin-top: 20px;">
            <input type="submit" value="View your cart" name="btAction" />
        </form>    
        <c:if test="${not empty param.txtSearchItem}">
            <c:set var="items" value="${requestScope.ITEM_VALUE}" />

            <c:if test="${not empty items}">
                <table border="1" cellpadding="5" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Item ID</th>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Action</th>
                            <th>Add to cart</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto" items="${items}">
                        <form action="cart" method="post" style="display:inline;">
                            <tr>
                                <td>${dto.itemID}</td>
                                <td>${dto.name}</td>
                                <td>${dto.price}</td>
                                <td>${dto.dateTime}</td>
                                <td>
                                    <input type="hidden" name="lastSearchValue" value="${param.txtSearchItem}" />
                                    <input type="hidden" name="itemID" value="${dto.itemID}" />
                                    <input type="submit" value="Add to Cart" name="btAction" />
                                </td>
                            </tr>
                        </form>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>

        <c:if test="${empty items}">
            <p>No matching items found.</p>
        </c:if>

    </c:if>
</body>
</html>
