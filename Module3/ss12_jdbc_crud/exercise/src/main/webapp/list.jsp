<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 29/10/21
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List User</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
    <style>
        * {
            margin: 0px 0px;
            padding: 0px 0px;
        }
    </style>
</head>
<body>
<div class="container col-12">
    <div class="row">
        <div class="col-3" >
            <button class="btn btn-primary text-white">
            <a class="text-white" href="/user?notice=create">Add new user</a>
            </button>
        </div>
        <div class="col-3">
            <form action="/user?notice=sort" method="post">
                <button type="submit" class="btn btn-primary text-white">Sort by name</button>
            </form>
        </div>
        <div class="col-6" style="text-align: right">
            <form action="/user?notice=search" method="post">
                <label> <input type="search" name="countryName" placeholder="Country name"></label>
                <button type="submit" class="btn btn-primary text-white">Search</button>
            </form>
        </div>
    </div>
</div>

<div class="container">
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${userList}">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>${user.country}</td>
                <td><a href="user?notice=edit&id=${user.id}">Edit</a></td>
                <td><a href="user?notice=delete&id=${user.id}">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
