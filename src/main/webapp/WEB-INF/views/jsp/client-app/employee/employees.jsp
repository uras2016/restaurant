<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <div style="margin-left: 20px">
        <table style="width: 100%">
            <center>

            <td>
                <h2>Наш персонал</h2>
                <img src="<c:url value="/resources/images/personal.jpg"/>">
            </td>
            </center>

        </table>

    </div>
</head>
<body>
<center>
<table style="align-items:center">
    <tr>
        <th>Имя официанта</th>
        <th>Позиция</th>
    </tr>
    <c:forEach var="employee" items="${employees}" >

        <tr>
            <td><a href="/employee?employeeName=${employee.name}"> ${employee.name}</a></td>
            <td>${employee.position}</td>

        </tr>

    </c:forEach>

</table>
<a href="/">Go Home</a>
<%--<a href="/">Short info</a>--%>
</center>
</body>
</html>
