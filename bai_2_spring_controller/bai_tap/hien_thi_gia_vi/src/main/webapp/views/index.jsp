<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 11/18/2021
  Time: 8:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Sandwick Condiments</h3>
<form action="/controllersave" method="post">
    <input type="checkbox" name="condiment" value="Lettuce">Lettuce
    <input type="checkbox" name="condiment" value="Tomato">Tomato
    <input type="checkbox" name="condiment" value="Mustard">Mustard
    <input type="checkbox" name="condiment" value="Sprouts">Sprouts<br>
    <input type="submit" value="Save" style="margin-top: 10px"><br>
    <p>Các gia vị đã lựa chọn là:</p>
    <c:forEach var="condiment" items="${condiments}">
        <span>${condiment}</span>
    </c:forEach>
</form>
</body>
</html>
