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
    <style>
        table{
            width: 80%;
            background-color: aliceblue;
            margin-left: 10%;
            margin-top: 5%;
            border-radius: 10px;
            border: 5px solid green;
        }

        th{
            background-color: aqua;
        }
        tr{
            border-bottom: solid;
            border-color: brown;
        }
    </style>

</head>
<body>



<table>
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
