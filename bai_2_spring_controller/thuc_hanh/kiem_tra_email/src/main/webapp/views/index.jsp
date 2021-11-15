<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 11/15/2021
  Time: 1:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/validate" method="post">
    <label>Nhap email:</label>
    <input name="email"><br>
    <input type="submit" value="Check"><br>
    ${message}

</form>
</body>
</html>
