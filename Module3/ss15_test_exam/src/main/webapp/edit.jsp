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
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
    <%--    <style>--%>
    <%--        * {--%>
    <%--            margin: auto;--%>
    <%--            padding: 0px 0px;--%>
    <%--        }--%>
    <%--    </style>--%>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-10">
            <img src="https://www.logodesign.net/logo/letter-k-in-front-of-house-5053ld.png?size=2&industry=company&bg=0" width="10%">
        </div>
        <div class="col-2 m-auto">
            <p>Vo Duc Tai</p>
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
                    <a class="nav-link text-light" href="/book">Employee</a>
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
        </div>
    </div>
</nav>
<div class="container-fluid">
    <form class="col-6  m-auto" method="post">
        <div>
            <h4>Edit book</h4>
            <p>
                <c:if test='${message != null}'>
                    <span class="message">${message}</span>
                </c:if>
            </p>
        </div>
        <div class="form-group col-12">
            <label class="col-12 ">Id:</label>
            <input type="text" name="id" class="form-control col-12  mt-2"
                   value="${ticket.book.id}" readonly>
        </div>
        <div class="form-group col-12">
            <label class="col-12 ">Name:</label>
            <input type="text" name="name" class="form-control col-12  mt-2"
                   value="${ticket.book.id}" readonly>
        </div>
        <div class="form-group col-12">
            <label class="col-12 float-left">Student Name:</label>
            <select name="studentNameId" class="form-control col-12 float-left">
                <option>Chose option ...</option>
                <c:forEach var="temp" items="${studentList}">
                    <c:choose>
                        <c:when test="${temp.id == ticket.student.id}">
                            <option value="${temp.id}" selected> ${temp.name}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${temp.id}">${temp.name}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
        </div>
        <div class="form-group col-12">
            <label class="col-12 float-left">Star day:</label>
            <input type="date" name="startDay" class="form-control col-12 float-left mt-2"
                   value="${ticket.starDay}">
        </div>
        <div class="form-group col-12">
            <label class="col-12 float-left">End day:</label>
            <input type="text" name="endDay" class="form-control col-12 float-left mt-2"
                   value="${ticket.endDay}">
        </div>
        <div class="col-12 " style="padding: 2% 0%">
            <button type="submit" class="btn btn-primary float-right">Save</button>
            <a href="">
                <button type="button" class="btn btn-info float-right">Back</button>
            </a>
        </div>
    </form>
</div>
<div class="col-12 bg-success m-auto text-light ">
    <div class="row">
        <div align="center">
            <p class="fs-6">International company</p>
        </div>
    </div>
</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
>