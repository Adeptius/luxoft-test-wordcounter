<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>


</head>
<body>
<form enctype="multipart/form-data" method="POST" action="/load-file">
    <p>Загрузите ваши фотографии на сервер</p>
    <p><input type="file" name="file" >
        <input type="submit" value="Отправить"></p>
</form>

<form method="POST" action="/delete-all">
    <input type="submit" name="delallbtn" value="Delete all" />
</form>

<form method="POST" action="/look-all">
    <input type="submit" name="showallbtn" value="Show all" />
</form>


</body>
</html>
