<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 27/10/21
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="/calculator" method="post">
    <h4>Calculator</h4>
    <div>
       <p>First operator</p>
        <label><input type="text" placeholder="input first operator " name="First"></label> <br>
       <select name="Operator">
            <option value="+"> Addition</option>
            <option value="-"> Subtraction</option>
            <option value="*"> Multiplication</option>
            <option value="/"> Division</option>
        </select>
       <p>Second operator</p>
        <label><input type="text" placeholder="input second operator " name="Second"></label><br>
        <label><input type="submit" name="Submit"></label>
    </div>
</form>
</body>
</html>
