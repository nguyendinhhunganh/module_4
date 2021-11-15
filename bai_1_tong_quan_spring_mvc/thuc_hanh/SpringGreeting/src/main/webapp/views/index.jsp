<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 11/13/2021
  Time: 3:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Hello Spring MVC ${name}
<form method="get" action="/index">
    <input name="name">
    <input type="submit" value="Ok">
</form>
</body>
</html>
