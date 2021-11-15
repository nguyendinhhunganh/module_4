<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 11/13/2021
  Time: 4:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Ung Dung Chuyen Doi Tien Te</h1>
<form action="/change" method="post">
    <label>Số USD cần đổi</label>
    <input name="usd">
    <label>Tỷ giá</label>
    <input name="rate">
    <input type="submit" value="Change">
    <p>Giá trị quy đổi là:</p> ${vnd}
</form>
</body>
</html>
