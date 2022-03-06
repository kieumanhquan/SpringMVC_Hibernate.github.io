<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Danh Sách Tuyến Đường</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
</head>
<body>
<%@ include file="common/header.jsp"%>
<div class="container">
    <a type="button" class="btn btn-primary btn-md ms-4 mt-5" href="${pageContext.request.contextPath}/add-line">Thêm Quãng Đường</a>
    <table class="table table-striped table-dark mt-5" id="table-data">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Id</th>
                <th scope="col">Khoảng Cách(Km)</th>
                <th scope="col">Số điểm dừng</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="line" items="${lines}">
                <tr>
                    <td>
                        <a type="button" class="btn btn-success"
                           href="${pageContext.request.contextPath}/update-line?id=${line.id}">Cập nhật</a>
                        <a type="button" class="btn btn-warning"
                           href="${pageContext.request.contextPath}/delete-line?id=${line.id}">Xóa</a>
                    </td>
                    <td class="id">${line.id}</td>
                    <td class="distance">${line.distance}</td>
                    <td class="stopPoint">${line.stopPoint}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
