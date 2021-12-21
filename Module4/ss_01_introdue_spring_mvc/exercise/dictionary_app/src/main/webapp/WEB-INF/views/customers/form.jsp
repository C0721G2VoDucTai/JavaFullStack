<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 11/11/21
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
</head>
<body>
<div class="col-8">
    <form method="post">
        <div class="mb-3">
            <h4 class="form-label">Dictionary</h4>
        </div>
        <div class="mb-3">
            <label for="formGroupExampleInput2" class="form-label">Vietnamese word</label>
            <input type="text" class="form-control" id="formGroupExampleInput2" name="vietnameseWord"
                   placeholder="Enter vietnamese word">
        </div>
        <div class="mb-3">
            <label for="formGroupExampleInput2" class="form-label">English word</label>
            <input type="text" class="form-control" value="${english}">
        </div>
        <div class="mb-3">
            <label for="formGroupExampleInput2" class="form-label"></label>
            <button type="submit" class="btn btn-primary">Translate</button>
        </div>

    </form>
</div>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
