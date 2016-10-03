<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

</head>
<body>
<table align="center" style="align-items:center">
    <tr>
        <th>Ингредиент</th>

    </tr>
    <c:forEach var="ingredient" items="${ingredients}" >

        <tr>
            <td>${ingredient.name}</td>


        </tr>

    </c:forEach>

</table>
<a href="/">Go Home</a>
</body>
</html>
