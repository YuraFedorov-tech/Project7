<%--
  Created by IntelliJ IDEA.
  User: 00sna
  Date: 13.03.2020
  Time: 0:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>crud</title>

</head>
<body>

<form method="post" action="/deleteUser">
    <table>
        <tr>
            <td>ID</td>
            <td>NAME</td>
            <td>PASSWORD</td>
        </tr>
        <c:forEach items="${userInJDBC}" var="User">
            <tr>
                <th>${User.id}</th>
                <th>${User.name}</th>
                <th>${User.password}</th>
                <td>
                    <a href="/updateUser?id=<c:out value='${User.id}' />">Edit</a>
                </td>
                <!---------Check box Delete----------->
                <td id="deleteUser">
                    <input type="checkbox" name="Delete" value=${User.id}>
                </td>
            </tr>
        </c:forEach>
    </table>
    <!------------ button Clear Cart--------------->
    <div class="button-update">
        <input type="submit" name="Delete" value="Delete selected cars">
    </div>
</form>
<h5>it`s clever man</h5>
</br>
</br>
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
</br>
<a href="/logout">Выход</a>
</body>
</html>
