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

            $('.sendFileToDBWithAjax').on('click', function () {
                $.ajax({
                    url: '/load-file', data: (  {file: $('.file')}  ), success: function (data) {
                        alert('updated');
                    }
                })
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

<form enctype="multipart/form-data" method="POST">
    <p>Загрузить файл на сервер</p>
    <input class="file" type="file" name="file">
</form>
<button class="sendFileToDBWithAjax">Отправить</button>

<form method="POST" action="/delete-all">
    <input type="submit" name="delallbtn" value="Delete all"/>
</form>
<button class="showWithAjax">Show all with ajax</button>

<table class="resultTable"></table>

</body>
</html>
<%--<form method="POST" action="/look-all">--%>
<%--<input type="submit" name="showallbtn" value="Show all"/>--%>
<%--</form>--%>