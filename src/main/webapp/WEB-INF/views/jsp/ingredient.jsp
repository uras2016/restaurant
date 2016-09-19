<%--
  Created by IntelliJ IDEA.
  User: uras
  Date: 19.09.2016
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>

<table style="align-items:center">
    <tr>
        <th>Ингредиент</th>
        <%--<th>Salary</th>--%>
    </tr>
    <tr>
        <td>${ingredient.name}</td>

    </tr>

</table>
<a href="/">Go Home</a>
<a href="/menus">Show all menus</a>
<a href="/dishes">Show all dishes</a>

</body>
</html>

</body>
</html>
