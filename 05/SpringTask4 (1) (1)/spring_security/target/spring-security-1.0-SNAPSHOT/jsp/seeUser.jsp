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
    <title>SeeUser</title>
</head>
<br>

<tr>
    <td>ID</td>
    <td>NAME</td>
    <td>PASSWORD</td>
</tr>
</br>
<tr>
    <th>${userInJDBC.id}</th>
    <th>${userInJDBC.name}</th>
    <th>${userInJDBC.password}</th>
</tr>
<a href="/logout">Выход</a>

</br>
</br>


</body>
</html>

