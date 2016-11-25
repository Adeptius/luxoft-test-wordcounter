<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Владелец
  Date: 24.11.2016
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="POST" action="/scan-file">
    Path file to scan and add to DB: <input type="text" name="path">
    <input type="submit" name="okbutton" value="OK" />
</form>
<form method="POST" action="/delete-all">
    <input type="submit" name="okbutton" value="Delete all" />
</form>

<table>
    <!--tr - строка-->
    <!--td - столбец-->
    <!--th - заголовок столбца-->
    <tr>
        <th>String</th>
        <th>length</th>
        <th>Shortest</th>
        <th>Longest</th>
        <th>Word avg length</th>
        <th>File name</th>
    </tr>
    <c:forEach var="stat" items="${list}" >
    <tr>
            <td>${stat.line}</td>
            <td>${stat.lineLength}</td>
            <td>${stat.shortest}</td>
            <td>${stat.longest}</td>
            <td>${stat.average}</td>
            <td>${stat.filename}</td>
    </tr>
    </c:forEach>
</table>







</body>
</html>
