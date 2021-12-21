<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 31/10/21
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create service</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-10">
            <img src="https://sohanews.sohacdn.com/2017/2-1509544156756.jpg" width="20%">
        </div>
        <div class="col-2 m-auto">
            <p>Nguyễn Văn A</p>
        </div>
    </div>
</div>
<nav class="navbar navbar-expand-lg navbar-light bg-success">
    <div class="container-fluid  ">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse " id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 ">
                <li class="nav-item ">
                    <a class="nav-link active text-light" aria-current="page" href="/home">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-light" href="/employee">Employee</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-light" href="/customer">Customer</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-light" href="/service">Service</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-light" href="/contract">Contract</a>
                </li>
            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success text-light" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<div class="container-fluid">
    <form class="col-6  m-auto" method="post">
        <div>
            <h4>Create new service</h4>
            <p>
                <c:if test='${requestScope["message"] != null}'>
                    <span class="message">${requestScope["message"]}</span>
                </c:if>
            </p>
        </div>
        <div class="form-group col-12">
            <label class="col-12 float-left">Name:</label>
            <input type="text" name="name" class="form-control col-12 float-left mt-2"
                   placeholder="Enter Name">
        </div>
        <div class="form-group col-12">
            <label class="col-12 float-left">Area</label>
            <input type="text" name="area" class="form-control col-12 float-left mt-2"
                   placeholder="Enter Area">
        </div>
        <div class="form-group col-12">
            <label class="col-12 float-left">Cost:</label>
            <input type="text" name="cost" class="form-control col-12 float-left mt-2"
                   placeholder="Enter Cost">
        </div>
        <div class="form-group col-12">
            <label class="col-12 float-left">Number of person:</label>
            <input type="text" name="numberOfPerson" class="form-control col-12 float-left mt-2"
                   placeholder="Enter Number of person">
        </div>
        <div class="form-group col-12">
            <label class="col-12 float-left mt-1">Rental type:</label>
            <select name="rentalTypeId" class="form-control col-12 float-left">
                <option>Chose option ...</option>
                <c:forEach var="item" items="${rentalTypeList}">
                    <option value="${item.getId()}"> ${item.getId()} - ${item.getName()} </option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group col-12">
            <label class="col-12 float-left mt-1">Service type:</label>
            <select name="serviceTypeId" class="form-control col-12 float-left">
                <option>Chose option ...</option>
                <c:forEach var="item" items="${serviceTypeList}">
                    <option value="${item.id}"> ${item.id} - ${item.name} </option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group col-12">
            <label class="col-12 float-left">Standard room:</label>
            <input type="text" name="standardRoom" class="form-control col-12 float-left mt-2"
                   placeholder="Enter Standard room">
        </div>
        <div class="form-group col-12">
            <label class="col-12 float-left">Description:</label>
            <input type="text" name="description" class="form-control col-12 float-left mt-2"
                   placeholder="Enter Description">
        </div>
        <div class="form-group col-12">
            <label class="col-12 float-left">Pool area:</label>
            <input type="text" name="poolArea" class="form-control col-12 float-left mt-2"
                   placeholder="Enter Pool area">
        </div>
        <div class="form-group col-12">
            <label class="col-12 float-left">Number of floor:</label>
            <input type="text" name="numberOfFloor" class="form-control col-12 float-left mt-2"
                   placeholder="Enter Number of floor">
        </div>
        <div class="col-12 " style="padding: 2% 0%">
            <button type="submit" class="btn btn-primary float-right">Create</button>
            <a href="/service">
                <button type="button" class="btn btn-info float-right">Back</button>
            </a>
        </div>
    </form>
</div>
<div class="col-12 bg-success m-auto text-light ">
    <div class="row">
        <div align="center">
            <p class="fs-6">Mọi nội dung tại đây © 2005 – 2021 Công ty TNHH Tư nhân Agoda. Bảo Lưu Mọi Quyền.
                Agoda.com
                là thành viên của Tập đoàn Booking Holdings, nhà cung cấp dịch vụ du lịch trực tuyến & các dịch
                vụ có liên quan hàng đầu thế giới.</p>
        </div>
    </div>
</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>