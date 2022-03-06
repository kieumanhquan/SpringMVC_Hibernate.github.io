<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Danh Sách Phân Công</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
</head>
<body>
<%@ include file="common/header.jsp" %>
<div class="container">
    <nav class="navbar">
        <a type="button" class="btn btn-primary btn-md ml-sm-3 mt-5"
           href="${pageContext.request.contextPath}/add-assignment">Phân Công Lái Xe</a>
        <a type="button" class="btn btn-primary btn-md ml-sm-3 mt-5"
           href="${pageContext.request.contextPath}/list-assignment-tables">Danh Sách</a>
    </nav>
    <nav class="navbar">
        <form action="${pageContext.request.contextPath}/list-assignment-drivers" method="get">
            <label>
                <input name="name" id="name" class="form-control" type="text" placeholder="Tìm kiếm">
            </label>
            <button class="btn btn-success">Tìm Kiếm</button>
        </form>
        <form action="${pageContext.request.contextPath}/list-filter-assignments" method="get">
            <label for="filter"></label>
            <select path="filter" id="filter" name="filter" style="padding:10px; border-radius: 5px;">
                <option value="driver-name">Họ Tên Lái Xe</option>
                <option value="turn-number">Số Lượt Lái</option>
            </select>
            <button class="btn btn-success">Sắp Xếp</button>
        </form>
    </nav>
    <table class="table table-striped table-dark" id="table-data">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Lái xe</th>
                <th scope="col">ID Tuyến</th>
                <th scope="col">Khoảng cách tuyến</th>
                <th scope="col">Số lượt</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="assignment" items="${assignments}">
                <tr>
                    <td>
                        <a type="button" class="btn btn-success"
                           href="${pageContext.request.contextPath}/update-assignment?driverId=${assignment.driver.id}&lineId=${assignment.line.id}">Cập nhật</a>
                        <a type="button" class="btn btn-warning"
                           href="${pageContext.request.contextPath}/delete-assignment?driverId=${assignment.driver.id}&lineId=${assignment.line.id}">Xóa</a>
                    </td>
                    <td class="fullName">${assignment.driver.fullName}</td>
                    <td class="id">${assignment.line.id}</td>
                    <td class="distance">${assignment.line.distance}</td>
                    <td class="turnNumber">${assignment.turnNumber}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>