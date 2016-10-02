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
        <th>First Name</th>
        <th>Last Name</th>
        <th>Position</th>
        <th>Phone Number</th>
        <th>Salary</th>
    </tr>
        <tr>
            <td>${employee.name}</td>
            <td>${employee.surname}</td>
            <td>${employee.position}</td>
            <td>${employee.telephone}</td>
            <td>${employee.salary}</td>
        </tr>

</table>
<div align="center">
<a href="/">Go Home</a>
<a href="/employees">Show all employees</a>
</div>
</body>
</html>
