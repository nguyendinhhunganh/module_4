<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 11/19/2021
  Time: 4:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Caculator</h2>
<form action="/calculate" method="post">
    <div>
        <input name="number1">
        <input name="number2">
    </div>
    <div>
        <input type="submit" name="calculate" value="Add">
        <input type="submit" name="calculate" value="Sub">
        <input type="submit" name="calculate" value="Mul">
        <input type="submit" name="calculate" value="Div">
    </div>
    Result Division: ${result}
</form>
</body>
</html>
