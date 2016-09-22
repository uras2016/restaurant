<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html lang="en">

<jsp:include page="../menu/header.jsp" />

<body>

<div class="container">

    <c:if test="${not empty msg}">
        <div class="alert alert-${css} alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
            <strong>${msg}</strong>
        </div>
    </c:if>

    <h1>Все меню</h1>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>Название меню</th>
        </tr>
        </thead>

        <c:forEach var="menu" items="${menus}">
            <tr>
                <td>${menu.name}</td>
                <td><c:forEach var="dish" items="${menu.dishes}" varStatus="loop">
                    ${framework}
                    <c:if test="${not loop.last}">,</c:if>
                </c:forEach></td>
                <td>
                    <spring:url value="/admin/menus/${menu.name}" var="userUrl" />
                    <spring:url value="/admin/menus/${menu.name}/delete" var="deleteUrl" />
                    <spring:url value="/admin/menus${menu.name}/update" var="updateUrl" />

                    <button class="btn btn-info" onclick="location.href='${userUrl}'">Query</button>
                    <button class="btn btn-primary" onclick="location.href='${updateUrl}'">Update</button>
                    <button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')">Delete</button></td>
            </tr>
        </c:forEach>
    </table>

</div>

<jsp:include page="../fragments/footer.jsp" />

</body>
</html>