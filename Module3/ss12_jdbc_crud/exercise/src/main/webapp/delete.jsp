<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 29/10/21
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete</title>
</head>
<body>
<h1>Delete Product</h1>
<p>
    <a href="/user">Back to user list</a>
</p>
<form method="post">
    <h3>Are you sure delete this user?</h3>
    <fieldset>
        <legend>User information</legend>
        <table>
            <tr>
                <td>Name:</td>
                <td>${user.name}</td>
            </tr>
            <tr>
                <td>Email:</td>
                <td>${user.email}</td>
            </tr>
            <tr>
                <td>Country:</td>
                <td>${user.country}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete user"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
