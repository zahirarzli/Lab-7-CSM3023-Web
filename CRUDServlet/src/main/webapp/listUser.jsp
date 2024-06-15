<%-- 
    Document   : listUser
    Created on : Jun 15, 2024, 4:23:04 PM
    Author     : S67554
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User Lists</title>
</head>
<body>
    <h1>List of Users</h1>
    <table border="1">
        <thead>
            <tr>
                <th>User Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th colspan="2">Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td><c:out value="${user.userId}"/></td>
                    <td><c:out value="${user.firstName}"/></td>
                    <td><c:out value="${user.lastName}"/></td>
                    <td>
                        <a href="UserController?action=edit&userId=<c:out value="${user.userId}"/>">Update</a>
                    </td>
                    <td>
                        <a href="UserController?action=delete&userId=<c:out value="${user.userId}"/>">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <br>
    <p><a href="UserController?action=insert">Add User</a></p>
</body>
</html>