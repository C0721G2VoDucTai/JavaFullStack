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
        <h4>SANDWICH SPICE FORM</h4>
        <p>Please choice your sandwich style like form</p>
    </div>
    <form class="row g-3" method="post">
        <div class="col-md-3">
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="condiment" value="lettuce">
                <label class="form-check-label">
                   Lettuce
                </label>
            </div>
        </div>
        <div class="col-md-3">
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="condiment" value="tomato">
                <label class="form-check-label">
                   Tomato
                </label>
            </div>
        </div>
        <div class="col-md-3">
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="condiment" value="mustard">
                <label class="form-check-label">
                  Mustard
                </label>
            </div>
        </div>
        <div class="col-md-3">
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="condiment" value="sprouts">
                <label class="form-check-label">
                    Sprouts
                </label>
            </div>
        </div>
        <div class="col-12">
            <button type="submit" class="btn btn-primary">Save</button>
        </div>
        <div class="col-12">
            <h4>Your sandwich spice is:</h4>
            <c:forEach items="${condiment}" var="temp" >
                <h5>${temp}</h5>
            </c:forEach>
            <p>Thank you and waiting for a minute, your order will be service</p>
        </div>
    </form>
</div>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
