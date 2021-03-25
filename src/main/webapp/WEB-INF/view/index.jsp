<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25.03.2021
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Accident</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
</head>
<body>


<div class="container ">
    <h2 class="text-center">Hello : Accident</h2>
    <table class="table table-striped table-dark">
        <thead>
        <tr>
            <td>id</td>
            <td>name</td>
            <td>description</td>
            <td>address</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="string" items="${accident}">
            <tr>
                <td>${string.id}</td>
                <td>${string.name}</td>
                <td>${string.text}</td>
                <td>${string.address}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
