<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 11/11/21
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
</head>
<body>
<div class="container col-8 " >
    <div>
        <h4>CALCULATOR</h4>
    </div>
    <form class="row g-3" method="post" action="/calculator">
        <div class="mb-3">
            <label class="form-label">Number one</label>
            <input type="text" class="form-control" name="numberOne"  placeholder="Input number one">
        </div>
        <div class="mb-3">
            <label class="form-label"> Choose calculation</label>
            <select name="calculation">
                <option>Choose ...</option>
                <option value="+">Addition</option>
                <option value="-">Subtraction</option>
                <option value="*">Multiplication</option>
                <option value="/">Division</option>
            </select>
        </div>
        <div class="mb-3">
            <label class="form-label">Number two</label>
            <input type="text" class="form-control" name="numberTwo" placeholder="Input number two">
        </div>

        <div class="mb-3">
            <button type="submit" class="btn btn-primary">Calculate</button>
        </div>
        <div class="mb-3">
            <h4>Result is:</h4>
            <h4>${result}</h4>
        </div>
    </form>
</div>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
