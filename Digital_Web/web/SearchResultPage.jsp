<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Result</title>
        <link href="css/search.css" rel="stylesheet" type="text/css"/>
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
                <c:forEach items="${list}" var="x">
                    <div class="tittle">
                        <a href="DetailControl?id=${x.id}">      
                            ${x.title}
                        </a>
                    </div>
                    <div class="image_search">
                        <img src="${imagePath}${x.image}" alt=""/>
                    </div>
                    <div class="text_search">
                        ${x.shortDes}
                    </div>
                    <br>
                </c:forEach>
                <div class="paging">
                        <c:forEach begin="1" end="${endPage}" var="i">
                            <a class="${i==index?"active":""}" href="SearchControl?index=${i}&txtSearch=${txt}">${i}</a>
                        </c:forEach>
                </div>
                <div class="right">
                    <div class="newR">Digital News</div>
                    <div class="shortDes">${top1.shortDes}</div>
                    <div class="newst">
                        <div class="newR">
                            Search
                        </div>
                        <form action="SearchControl" method="post">
                            <input class="searchBox" type="text" name="txtSearch" size="15" required>
                            <input class="searchButton" type="submit" name="btnGo" value="Go">
                        </form> 
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
        
    </div>
</body>
</html>
