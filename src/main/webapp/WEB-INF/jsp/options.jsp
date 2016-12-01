<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

    <script type="text/javascript">
        $(document).ready(function () {
            $('.showWithAjax').on('click', function doAjax() {
                $.ajax('/load-table', {
                    success: function (data) {
                        var table = $('.resultTable');
                        table.hide();
                        table.text('');
                        table.append(data);
                        table.slideDown();
                    }
                });
            })
        });
    </script>

    <style>
        table {
            width: 80%;
            background-color: aliceblue;
            margin-left: 10%;
            margin-top: 5%;
            border-radius: 10px;
            border: 5px solid green;
            display: none;
        }

        th {
            background-color: aqua;
        }

        tr {
            border-bottom: solid;
            border-color: brown;
        }
    </style>

</head>
<body>
<form enctype="multipart/form-data" method="POST" action="/load-file">
    <p>Загрузите файл на сервер</p>
    <p><input type="file" name="file">
        <input type="submit" value="Отправить"></p>
</form>

<form method="POST" action="/delete-all">
    <input type="submit" name="delallbtn" value="Delete all"/>
</form>

<form method="POST" action="/look-all">
    <input type="submit" name="showallbtn" value="Show all"/>
</form>

<button class="showWithAjax">Show all with ajax</button>


<table class="resultTable">

</table>


</body>
</html>
