<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 01.04.2021
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<c:if test="${not empty errorMessage}">
    <div style="color: red; font-weight: bold; margin: 30px 0px;">
            ${errorMessage}
    </div>
</c:if>

<form name="login" action="<c:url value="/login"/>" method="post">
    <table>
        <tr>
            <td>Username:</td>
            <td>
                <input type="text" name="username">
            </td>
        </tr>
        <tr>
            <td>Password:</td>
            <td>
                <input type="password" name="password">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" name="submit" value="submit">
            </td>
        </tr>
    </table>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

</body>
</html>
