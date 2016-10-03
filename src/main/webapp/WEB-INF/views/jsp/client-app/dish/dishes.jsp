<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

</head>
<body>
<table align="center" style="align-items:center">
    <tr>
        <th>Блюдо</th>
        <th>Цена</th>
        <th>Вес</th>
        <th>Мера</th>

    </tr>
    <c:forEach var="dish" items="${dishes}" >

        <tr>
            <td><a href="/dish?dishName=${dish.name}"> ${dish.name}</a></td>
            <%--<td>${dish.name}</td>--%>
            <td>${dish.price}</td>
            <td>${dish.weight}</td>
            <td>${dish.measure}</td>

                <%--<td>${employee.salary}</td>--%>
        </tr>

    </c:forEach>

</table>
<a href="/">Go Home</a>
</body>
</html>
