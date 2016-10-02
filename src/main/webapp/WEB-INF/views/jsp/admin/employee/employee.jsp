<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp"/>

<div>
    <c:if test="${not empty msg}">
        <div class="alert alert-${css} alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
            <strong>${msg}</strong>
        </div>
    </c:if>

    <div style="width: 35%; margin-left: 30px">
        <h2>${employee.name}</h2> <h2>${employee.surname}</h2>

        <table border="3" style="align-items: center" class="table table-view">
            <thead style="color:white;background-color:#2e6da4">
            <tr>
                <th>Имя</th>
                <th>Фамилия</th>
                <th>Должность</th>
                <th>Телефон</th>
                <th>Оклад</th>

            </tr>
            </thead>


            <tr>
                <td>${employee.name}</td>
                <td>${employee.surname}</td>
                <td>${employee.position}</td>
                <td>${employee.telephone}</td>
                <td>${employee.salary}</td>
            </tr>
        </table>

    </div>
    <hr>
    <br>
    <br>
    <br>




</div>
</body>
<p><a href="/admin/employees">Go to employee list</a></p>
</html>
