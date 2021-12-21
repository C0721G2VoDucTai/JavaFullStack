<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 11/11/21
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
0
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
            <label for="formGroupExampleInput" class="form-label">Currency rate</label>
            <input type="text" class="form-control" id="formGroupExampleInput" value="22000">
        </div>
        <div class="mb-3">
            <label for="formGroupExampleInput2" class="form-label">USD</label>
            <input type="text" class="form-control" id="formGroupExampleInput2" name="usd"
                   placeholder="Enter number of USD">
        </div>
        <div class="mb-3">
            <label for="formGroupExampleInput2" class="form-label">VND</label>
            <input type="text" class="form-control" value="${vnd}" placeholder="Currency number of VND">
        </div>
        <div class="mb-3">
            <label for="formGroupExampleInput2" class="form-label"></label>
            <button type="submit" class="btn btn-primary">Convert</button>
        </div>

    </form>
</div>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
