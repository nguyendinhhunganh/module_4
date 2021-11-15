<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 11/13/2021
  Time: 4:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<form action="traCuu" method="post">
    <label> Nhap tu can tra cuu</label>
    <input name="english"><br>
    <input type="submit" value="Dịch">
    <label> Kết quả:</label> ${vietNam}
</form>
</body>
</html>
