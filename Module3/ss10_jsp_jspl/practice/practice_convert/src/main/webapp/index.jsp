<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 26/10/21
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <style>
    .form {
      height: 260px;
      width: 200px;
      background-color: beige ;
    }
    .form label {
      width: 100px;
      padding: 10px 10px;
    }

  </style>
  <body>
  <form class="form" action="converter.jsp">
    <h4>Currency Convert</h4>
    <div>
      <p>Rate</p>
      <label><input type="text" name="rate" placeholder="22000" value="22000"></label>
      <p>USD</p>
      <label><input type="text" name="usd" placeholder="input USD"></label>
      <p> </p>
      <label><input type="submit" name="Convert"></label>
    </div>
  </form>
  </body>
</html>
