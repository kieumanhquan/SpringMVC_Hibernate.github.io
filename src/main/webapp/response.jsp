<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
    <style>
        .feedback{
            color: cadetblue;
            text-align: center;
        }
        .container{
            margin-top: 10%;
        }
    </style>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
</head>
<body>
<%@ include file="common/header.jsp" %>
<div class="container">
    <h4 class="feedback">
        <a href="${pageContext.request.contextPath}/list-assignments">${message}</a>
    </h4>
    <p class="feedback">Thông tin không hơp lệ !</p>
</div>
</body>
</html>