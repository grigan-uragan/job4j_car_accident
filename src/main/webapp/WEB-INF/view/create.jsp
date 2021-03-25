<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25.03.2021
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
          crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
            crossorigin="anonymous"></script>
</head>
<body>

<div class="container">
    <h2 class="text-center">Add Accident</h2>
    <form:form modelAttribute="accident" action="create">
        <form:hidden path="id"/>
        <div class="mb-3">
            <label for="name" class="form-label"/>
            Name <form:input path="name" id="name" cssClass="form-control"/>
        </div>
        <div class="mb-3">
            <label for="text" class="form-label"/>
            Description <form:textarea path="text" id="text" cssClass="form-control"/>
        </div>
        <div class="mb-3">
            <label for="address" class="form-label"/>
            Address <form:input path="address" id="address" cssClass="form-control"/>
        </div>
        <div class="mb-3"><input type="submit" value="save" class="btn btn-primary"></div>
    </form:form>
</div>

</body>
</html>
