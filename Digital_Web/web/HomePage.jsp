<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <div class="header">
                <h3>My digital news</h3>
            </div>
            <div class="menu">
                <a href="#">News</a>
            </div>
            <div class="main">
                <div class="left">
                    <div class="title">${top1.title}</div>
                    <div class="image">
                        <img src="${imagePath}${top1.image}" alt=""/>
                    </div>
                    <div class="description">${top1.description}</div>
                    <div class="information">${top1.author} | ${top1.timePost}</div>
                </div>
                <div class="right">
                    <div class="newR">Digital News</div>
                    <div class="shortDes">${top1.shortDes}</div>
                    <div class="newR">Search</div>
                    <div class="Search">
                        <input class="inputTxt" type="text" name="txtSearch">
                        <input class="submitTxt" type="submit" value="Go">
                    </div>
                    <div class="newR">Last Articles</div>
                    <c:forEach var="x" items="${top5}">
                        <div class="lastArticles">
                            <a href="#">${x.title}</a>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <div class="footer"></div>
        </div>
    </body>
</html>