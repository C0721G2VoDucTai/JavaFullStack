<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 26/10/21
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
    <style>

        td , th {
            text-align: left;
            font-family: "Times New Roman";
            border-bottom: 1px solid grey;
        }
    </style>
</head>
<body>
<h4 style="text-align: center; width: 550px; font-family: 'Times New Roman'">DANH SÁCH KHÁCH HÀNG </h4>
<table style="width: 550px">
    <tr >
        <th width="150px " >Tên</th>
        <th width="150px">Ngày Sinh</th>
        <th width="150px">Địa Chỉ</th>
        <th width="100px">Ảnh</th>
    </tr>
    <c:forEach var="customerObj" items="${customerListServlet}" >
    <tr>
        <td> ${customerObj.name} </td>
        <td> ${customerObj.birthOfDay} </td>
        <td> ${customerObj.address}</td>
        <td> <img src= " <c:out value="${customerObj.img}" />" width="100px" ></td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
