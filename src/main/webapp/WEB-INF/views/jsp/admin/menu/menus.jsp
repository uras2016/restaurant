<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html lang="en">

<jsp:include page="../menu/header.jsp" />

<body>

<div style="width: 50%; margin-left: 20px">

    <%--<c:if test="${not empty msg}">--%>
        <%--<div class="alert alert-${css} alert-dismissible" role="alert">--%>
            <%--<button type="button" class="close" data-dismiss="alert" aria-label="Close">--%>
                <%--<span aria-hidden="true">&times;</span>--%>
            <%--</button>--%>
            <%--<strong>${msg}</strong>--%>
        <%--</div>--%>
    <%--</c:if>--%>

    <h1>Все меню</h1>



        <table border="0.2" style="align-items: center" class="table table-striped">
            <thead style = "color:white;background-color:grey">
        <tr>
            <th>Название меню</th>
            <th></th>
            <th></th>
        </tr>
        </thead>

        <c:forEach var="menu" items="${menus}">
            <tr>
                <td><a href="/admin/menus/menu/${menu.id}">${menu.name}</a></td>

                <td style="align-items: center; width: 20px">
                    <spring:url value="/admin/menus/${menu.id}/delete" var="deleteUrl"/>
                    <a href="${deleteUrl}">Delete</a>
                </td>
                <td style="align-items: center; width: 20px">
                    <spring:url value="/admin/menus/${menu.id}/update" var="updateUrl"/>
                    <a href="${updateUrl}">Edit</a>

                </td>
            </tr>

        </c:forEach>

    </table>
        <spring:url value="/admin/menus/add" var="addUrl" />
        <button class="btn btn-primary" onclick="location.href='${addUrl}'">Добавить меню</button>
        <br>
        <br>

</div>
<p><a href="/admin">Go to options</a></p>

<jsp:include page="../fragments/footer.jsp" />

</body>


</html>