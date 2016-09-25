<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp" />

<body>

<div style="width: 35%; margin-left: 30px">


    <h1>Персонал</h1>



    <table border="0.2" style="align-items: center" class="table table-striped">
        <thead style = "color:white;background-color:#2e6da4">
        <tr>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Позиция</th>

            <th colspan="2" align="center">Опции</th>
        </tr>
        </thead>

        <c:forEach var="employee" items="${employees}">
            <tr>
                <td><a href="/admin/employees/employee/${employee.id}">${employee.name}</a></td>
                <td>${employee.surname}</td>
                <td>${employee.position}</td>

                <td style="align-items: center; width: 20px">
                    <spring:url value="/admin/employees/${employee.id}/delete" var="deleteUrl"/>
                    <a href="${deleteUrl}">Delete</a>
                </td>
                <td style="align-items: center; width: 20px">
                    <spring:url value="/admin/employees/${employee.id}/update" var="updateUrl"/>
                    <a href="${updateUrl}">Edit</a>

                </td>
            </tr>

        </c:forEach>

    </table>
    <spring:url value="/admin/employees/add" var="addUrl" />
    <button class="btn btn-primary" onclick="location.href='${addUrl}'">Добавить нового сотрдуника</button>
    <br>
    <br>

</div>
<p><a href="/admin">Go to options</a></p>

<jsp:include page="../fragments/footer.jsp" />

</body>


</html>