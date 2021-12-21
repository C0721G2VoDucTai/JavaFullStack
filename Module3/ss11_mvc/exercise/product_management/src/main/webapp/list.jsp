<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 28/10/21
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h1>Product</h1>
<p>
<a href="/product?notice=create">Create new product</a>
</p>
<form action="/product?notice=search" method="post">
<input type="text" name="name" placeholder="Enter search name">
<input type="submit" value="Search">
</form>
<table border="1">
<tr>
    <th>id</th>
    <th>Name</th>
    <th>Price</th>
    <th>Description</th>
    <th>Brand</th>
    <th>Edit</th>
    <th>Delete</th>
</tr>
    <c:forEach items='${requestScope["product"]}' var="product">
    <tr>
        <td><a href="/product?notice=view&id=${product.getId()}">${product.getId()}</a></td>
        <td>${product.getName()}</td>
        <td>${product.getPrice()}</td>
        <td>${product.getDescription()}</td>
        <td>${product.getBrand()}</td>
        <td><a href="/product?notice=edit&id=${product.getId()}">edit</a></td>
        <td><a href="/product?notice=delete&id=${product.getId()}">delete</a></td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
