<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<center>
<table style="align-items:center">

    <tr>
        <th>Ингредиент</th>
        <%--<th>Salary</th>--%>
    </tr>
    <c:forEach var="ingredient" items="${dish.ingredients}">
        <tr>
            <td>${ingredient.name}</td>

        </tr>
    </c:forEach>
</table>
<a href="/">Go Home</a>
<a href="/menus">Show all menus</a>
<a href="/dishes">Show all dishes</a>
</center>
</body>
</html>
