<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 26/10/21
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <style>
        .form{
            width: 150px;
            height: 300px;
            margin: auto;
            padding: 20px;
            border: 2px brown; background-color: antiquewhite
        }
        .form input {
            width: 140px;
            height: 20px;
            border: 1px solid gray;
        }
    </style>
</head>
<body>
<form action="/discount_product">
    <div class="form">
        <p> Product Description </p>
        <input type="text" name="Description" placeholder="Product Description"><br>
        <p> List Price </p>
        <input type="text" name="Price" placeholder="List Price"><br>
        <p> Discount Percent </p>
        <input type="text" name="Discount" placeholder="Discount Percent"><br>
        <p></p>
        <input type="submit" name="Submit">
    </div>
</form>
</body>
</html>
