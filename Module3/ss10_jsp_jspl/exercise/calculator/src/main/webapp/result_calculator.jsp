<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 27/10/21
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<h3>Result</h3>
<c:out value="${calculatorResult}"></c:out>
<%--<%=request.getAttribute("calculatorResult") %>--%>
</body>
</html>
