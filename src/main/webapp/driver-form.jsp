<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Quản Lý Lái Xe</title>
    <style>
        label{
            color: cadetblue;
        }
    </style>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
</head>
<body>
<%@ include file="common/header.jsp"%>
<div class="container">
    <h1 style="text-align: center">Nhập Lái Xe</h1>
    <form class="needs-validation" modelAttribute="driver" method="POST">
        <div class="form-group mb-3">
            <label for="fullName">Họ và Tên: </label>
            <input path="fullName" type="text" class="form-control" id="fullName" placeholder="Nhập họ và tên" name="fullName"
                   required
                   maxlength="50">
            <span id="name_error"></span>
        </div>
        <div class="form-group mb-3">
            <label for="address">Địa chỉ: </label>
            <input path="address" type="text" class="form-control" id="address" placeholder="Nhập địa chỉ" name="address"
                   required
                   maxlength="50">
            <span id="address_error"></span>
        </div>
        <div class="form-group mb-3">
            <label for="phoneNumber">Số điện thoại: </label>
            <input path="phoneNumber" type="number" class="form-control" id="phoneNumber" placeholder="Nhập số điện thoại"
                   name="phoneNumber" required >
            <span id="phone_error"></span>
        </div>
        <div class="form-group mb-5">
            <label for="driveLevel" style="margin-right: 10px">Trình độ: </label>
            <select path="driveLevel" id="driveLevel" name="driveLevel" style="padding-right: 20px;padding-left: 20px">
                <option value="A">Bằng A</option>
                <option value="B">Bằng B</option>
                <option value="C">Bằng C</option>
                <option value="D">Bằng D</option>
                <option value="E">Bằng E</option>
                <option value="F">Bằng F</option>
            </select>
            <span id="driveLevel_error"></span>
        </div>
        <button type="submit" class="btn btn-info" id="saves-button">Lưu</button>
        <button type="button" onclick=handleReset() class="btn btn-info" id="save-reset">Lưu Sửa</button>
    </form>
</div>
<script>
    function handleReset() {
        document.getElementById("fullName").value = "";
        document.getElementById("address").value = "";
        document.getElementById("phoneNumber").value = "";
    }
</script>
</body>
</html>
