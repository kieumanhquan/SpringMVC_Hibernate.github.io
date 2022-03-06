<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Quản Lý Công Việc</title>
    <style>
        label {
            color: cadetblue;
        }
    </style>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
</head>
<body>
<%@ include file="common/header.jsp" %>
<div class="container">
    <h1 style="text-align: center">Quản Lý Phân Công</h1>
    <form class="needs-validation" modelAttribute="assignment" method="POST">
        <div class="form-group mb-5">
            <label for="driverId" style="margin-right: 10px">Lái Xe</label>
            <select path="driverId" id="driverId" name="driverId" style="border-radius: 5px;
                                                                         padding: 10px 100px 2px 20px;">
                <c:forEach var="driver" items="${drivers}">
                    <option value="${driver.id}">${driver.id}-${driver.fullName}</option>
                </c:forEach>
            </select>
            <span id="driver_error"></span>
        </div>
        <div class="form-group mb-5">
            <label for="lineId" style="margin-right: 10px">Tuyến Đường</label>
            <select path="lineId" id="lineId" name="lineId" style="border-radius: 5px;
                                                                   padding: 10px 100px 2px 20px;">
                <c:forEach var="line" items="${lines}">
                    <option value="${line.id}">${line.id}</option>
                </c:forEach>
            </select>
            <span id="line_error"></span>
        </div>
        <div class="form-group mb-3">
            <label for="turnNumber">Số Lượt</label>
            <input path="turnNumber" type="number" class="form-control" id="turnNumber" placeholder="Nhập số lượt lái"
                   name="turnNumber" required>
            <span id="turnNumber_error"></span>
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
