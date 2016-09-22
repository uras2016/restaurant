<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Admin page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<td>

    <table style="align-items:center">
        <tr>
            <th>Опции</th>
        </tr>


                 <div style="position:absolute; top:100px; left:50px;"><a href="/admin/menus" button type="submit"
                                                                 class="btn btn-primary">Изменения в меню</a>
                 </div>

                <div style="position:absolute; top:100px; left:210px;"><a href="/dishes" button type="submit"
                                                                          class="btn btn-primary">Все блюда</a></div>

                <div style="position:absolute; top:100px; left:310px;"><a href="/employees" button type="submit"
                                                                          class="btn btn-primary">Персонал</a></div>

                <div style="position:absolute; top:100px; left:425px;"><a href="/store" button type="submit"
                                                                          class="btn btn-primary">Склад</a>
                </div>

                <div style="position:absolute; top:100px; left:500px;"><a href="/history" button type="submit"
                                                                  class="btn btn-primary">История заказов</a>
                </div>

                <div style="position:absolute; top:100px; left:700px;"><a href="/ingredients/edit" button type="submit"
                                                                  class="btn btn-primary">Изменение ингредиентов</a>
                </div>


        </tr>
    </table>

    <a href="/">Go Home</a>
</body>
</html>
