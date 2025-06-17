<%-- 
    Document   : search
    Created on : Jun 15, 2025, 9:33:18 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="tuonglh.registration.SigninDTO" %>
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
                                value=" <%= request.getParameter("txtSearchValue") %>" /></br>
            <input type="submit" value="Search" name="btAction" />
        </form> </br>
        <% 
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



        %>
        
        
    </body> 
</html>
