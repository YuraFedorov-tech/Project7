<%--
  Created by IntelliJ IDEA.
  User: 00sna
  Date: 13.03.2020
  Time: 0:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>add User in dataBase</h4>
<form method="post" action="/addUser">
    <label for="name">
        <input id="name" name="name" value="name">
    </label></br>
    <label for="password">
        <input id="password" name="password" value="password">
    </label></br>
    <input type="submit" value="inside car in DB">
</form>
</br>
<a href="/logout">Выход</a>
</body>
</html>
