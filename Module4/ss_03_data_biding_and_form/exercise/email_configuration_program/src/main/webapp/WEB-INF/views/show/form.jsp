<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 11/11/21
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
</head>
<body>
<h3>SETTINGS</h3>
<form:form action="/form" method="post" modelAttribute="configEmail">
    <form:label path="language">Language:</form:label>
    <form:select path="language">
        <form:options items="${languages}"></form:options>
    </form:select>
    <form:label path="pageSize">Email per page:</form:label>
    <form:select path="pageSize">
        <form:options items="${pageSizes}"></form:options>
    </form:select>
    <form:label path="spamsFilter">Email per page:</form:label>
    <form:checkbox path="spamsFilter"></form:checkbox>
    <form:label path="signature">Email per page:</form:label>
    <form:textarea path="signature"></form:textarea>
    <input type="submit" value="Create">
</form:form>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
