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
    <div class="row">
        <div class="col-3 ">
            <img src="https://q-xx.bstatic.com/xdata/images/hotel/840x460/62371531.jpg?k=144be5406597c55916e8eed20518059cf2e35d32e2b417f27b37ad35b5d5a4cf&o="
                 width="100%">
            <img src="https://scontent.fhan14-2.fna.fbcdn.net/v/t39.30808-6/241561138_10161700790251151_552339790438478868_n.jpg?_nc_cat=109&ccb=1-5&_nc_sid=730e14&_nc_ohc=WjSrK2irKOUAX8hHOyk&_nc_oc=AQk412Qvb_sTfiswIS5UgQNgJwc_wbL2ypKxIYkEShDhZTHhdIiYvsjaVQnGw17zjGA&_nc_ht=scontent.fhan14-2.fna&oh=415be1558c6b68c782b785c0d019de4d&oe=618635F0"
                 width="100%">
            <img src="https://scontent.fhan14-1.fna.fbcdn.net/v/t39.30808-6/240604376_10161594116166151_4100165210774289023_n.jpg?_nc_cat=101&ccb=1-5&_nc_sid=730e14&_nc_ohc=ZlTcuuBfCLwAX_zWkId&_nc_ht=scontent.fhan14-1.fna&oh=18aefd8adf7751cbd9cd6fd6adec48c2&oe=61856892"
                 width="100%">
        </div>
        <div class="col-9">
            <div class="col-12">

                      <img src="https://furamavietnam.com/wp-content/uploads/2018/08/Vietnam_Danang_Furama_Garden-Deluxe-twin-bed-M-1047x563.jpg" width="98%">
                <p>
                    Hướng ra bãi biển Đà Nẵng trải dài cát trắng, Furama Resort Đà Nẵng là cửa ngõ đến với 3 di sản văn
                    hoá thế giới: Hội An (20 phút), Mỹ Sơn (90 phút) và Huế (2 tiếng. 196 phòng hạng sang cùng với 70
                    căn biệt thự từ hai đến bốn phòng ngủ có hồ bơi riêng đều được trang trí trang nhã, theo phong cách
                    thiết kế truyền thống của Việt Nam và kiến trúc thuộc địa của Pháp, biến Furama thành khu nghỉ dưỡng
                    danh giá nhất tại Việt Nam – vinh dự được đón tiếp nhiều người nổi tiếng, giới hoàng gia, chính
                    khách, ngôi sao điện ảnh và các nhà lãnh đạo kinh doanh quốc tế.</p>
            </div>


        </div>

    </div>

</div>
<div class="container-fluid bg-success text-light ">
    <div class="row">
        <div align="center">
            <p class="fs-6">Mọi nội dung tại đây © 2005 – 2021 Công ty TNHH Tư nhân Agoda. Bảo Lưu Mọi Quyền. Agoda.com
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
>