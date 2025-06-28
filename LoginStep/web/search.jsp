<%-- 
    Document   : search
    Created on : Jun 15, 2025, 9:33:18 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- 
<%@page import="java.util.List" %>
<%@page import="tuonglh.registration.SigninDTO" %>
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
    </head>
    <body>
        <font color = "red">
        Welcome , ${sessionScope.USER_INFO.name}
        </font>
        <h1>Search Page</h1>
        <form action="DispatchServlet">
            Search Value <input type="text" name="txtSearchValue" 
                                value="${param.txtSearchValue}" /></br>
            <input type="submit" value="Search" name="btAction" />
        </form> </br>

        <c:set var="searchValue" value="${param.txtSearchValue}"/>
        <c:if test="${not empty searchValue}">   
            <c:set var="result" value="${requestScope.SEARCH_RESULT}" />
            <c:if test="${not empty result}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Username</th>
                            <th>Password</th>
                            <th>Full name</th>
                            <th>Role</th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto" items="${result}" varStatus="counter">
                        <form  action="DispatchServlet" method="POST">
                            <tr>
                                <td>
                                    ${counter.count}
                                .</td>
                                <td>
                                    ${dto.phoneNumber}
                                    <input type="hidden" name="txtphoneNumber" 
                                           value="${dto.phoneNumber}" />
                                </td>
                                <td>
                                    <input type="text" name="txtPassword" 
                                           value="${dto.password}" />
                                </td>
                                <td>
                                    ${dto.name}
                                </td>
                                <td>
                                    <input type="checkbox" name="chkRole" value="ON" 
                                    <c:if test="${dto.role}">
                                        checked = "checked";
                                    </c:if>
                                    />
                                </td>
                                <td>
                                    <c:url var="deleteLink" value="DispatchServlet">
                                        <c:param name="btAction" value="Delete" />
                                        <c:param name="pk" value="${dto.phoneNumber}" />
                                        <c:param name="lastSearchValue"
                                                 value="${param.txtSearchValue}" />
                                    </c:url>
                                    <a href="${deleteLink}">Delete</a>
                                </td>
                                <td>
                                    <input type="hidden" name="lastSearchValue" 
                                           value="${searchValue}" />
                                    <input type="submit" value="Update" name="btAction" />
                                </td>
                            </tr>
                        </form>    
                        </c:forEach>
                    </tbody>
                </table>

            </c:if>
            <c:if test="${empty result}">
                <h2>
                    <font color ="red">
                    No record is matched !!!
                    </font>
                </h2>
            </c:if>
        </c:if>


        <%-- <% 
            String searchValue = request.getParameter("txtSearchValue");
            if(searchValue != null){
                List<SigninDTO> result = 
                (List<SigninDTO>) request.getAttribute("SEARCH_RESULT"); // setAttribute cua searchLastName
                if(result != null){ // found
                %>
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Phone</th>
                            <th>Password</th>
                            <th>role</th>
                            <th>name</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            int count = 0;
                            for(SigninDTO dto : result){
                            %>
                        <tr>
                            <td>
                                <%= ++count %>.
                            </td>
                            <td>
                                <%= dto.getPhoneNumber() %>
                            </td>
                            <td>
                                <%= dto.getPassword() %>
                            </td>
                            <td>
                                <%= dto.isRole() %>
                            </td>
                            <td>
                                <%= dto.getName() %>
                            </td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>

        <%
                }else{//not found
                %>
                <h2>
                    <font color ="red">
                    No record is matched!!
                </h2>
        <%
                }
            }
        %> --%>
    </body> 
</html>
