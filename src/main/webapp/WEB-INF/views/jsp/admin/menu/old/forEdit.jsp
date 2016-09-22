<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<body>

<div style="width: 50%; margin-left: 20px">

    <h1 style="text-align: center; color: #23527c">Our's menu</h1>

    <spring:url value="/menus/add" var="addUrl" />
    <button class="btn btn-primary" onclick="location.href='${addUrl}'">Add menu</button>
    <br>
    <br>

    <table border="1" style="align-items: center" class="table table-striped">
        <thead>
        <tr>
            <th>Name</th>
            <th></th>
            <th></th>

        </tr>
        </thead>

        <c:forEach items="${menus}" var="menu">
            <tr>
                <td><a href="/menus/show/${menu.name}">${menu.name}</a></td>
                    <%--<td>${menu.dishes}</td>--%>

                <td style="align-items: center; width: 20px">
                    <spring:url value="/menus/${menu.name}/delete" var="deleteUrl"/>
                    <a href="${deleteUrl}">
                    </a>
                </td>
                <td style="align-items: center; width: 20px">
                    <spring:url value="/menus/${menu.name}/update" var="updateUrl"/>
                    <a href="${updateUrl}">
                    </a>
                </td>
            </tr>

        </c:forEach>

    </table>
</div>
<br/>

</body>
</html>