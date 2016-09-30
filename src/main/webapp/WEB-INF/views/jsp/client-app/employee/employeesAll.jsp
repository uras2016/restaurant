<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
                     integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4VaPmSTsz/K68vbdEjh4u" crossorigin="anonymous">

</head>
<body>

<table align="center" style="align-items:center">
    <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Position</th>
            <%--<th>Salary</th>--%>
        </tr>
    <c:forEach var="employee" items="${employees}" >

            <tr>
                <td><a href="/employee?employeeName=${employee.name}"> ${employee.name}</a></td>
                <td>${employee.surname}</td>
                <td>${employee.position}</td>
                    <%--<td>${employee.salary}</td>--%>
            </tr>

        </c:forEach>

</table>
<a href="/">Go Home</a>

</body>
</html>