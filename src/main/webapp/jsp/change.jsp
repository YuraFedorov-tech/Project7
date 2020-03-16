<%--
  Created by IntelliJ IDEA.
  User: 00sna
  Date: 13.03.2020
  Time: 0:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>update</title>
</head>
<br>

<tr>
    <td>ID</td>
    <td>NAME</td>
    <td>PASSWORD</td>
</tr>
</br>
<tr>
    <th>${User.id}</th>
    <th>${User.name}</th>
    <th>${User.password}</th>
</tr>


</br>
</br>
<h5>Input new parametrs</h5>
<h4>update User in dataBase</h4>
<form method="post" action="/updateUser?id=<c:out value='${User.id}' />">
    <label for="name">
        <input id="name" name="name" value="name">
    </label></br>
    <label for="password">
        <input id="password" name="password" value="password">
    </label></br>

    <input type="submit" value="update in DB">
</form>
<a href="/logout">Выход</a>
</body>
</html>

