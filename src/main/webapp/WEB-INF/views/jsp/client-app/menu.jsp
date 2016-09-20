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
        <th>Название блюда</th>
        <th>Цена</th>
        <th>Вес</th>
        <th>Мера</th>
    </tr>

    <c:forEach var="dishes" items="${menu.dishes}" >

        <tr>
            <td><a href="/dish?dishName=${dishes.name}"> ${dishes.name}</a></td>
            <%--<td>${dishes.name}</td>--%>
            <td>${dishes.price}</td>
            <td>${dishes.weight}</td>
            <td>${dishes.measure}</td>

                <%--<td>${employee.salary}</td>--%>
        </tr>

    </c:forEach>
    <tr>
        <%--<td>${menu.name}</td>--%>
        <%--<td>${dish.name}</td>--%>

    </tr>

</table>
<a href="/">Go Home</a>
<a href="/menus">Show all menus</a>
</center>
</body>
</html>
