<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

</head>
<body>
<center>


    <table style="align-items:center">
        <tr>
            <th>Меню</th>

        </tr>
        <c:forEach var="menusAll" items="${menusE}" >

            <tr>
                    <%--<td><a href="/ingredient?ingredientName=${ingredient.name}"> ${ingredient.name}</a></td>--%>
                <td>${menusAll.name}</td>

                <td>
                    <a href="edit?name=${menusAll.name}">Edit</a>
                    <a href="delete?name=${menusAll.name}">Delete</a>
                </td>
            </tr>

        </c:forEach>

    </table>

    <a href="/">Go Home</a>
    <%--<a href="/">Short info</a>--%>
</center>

<%--<spring:url value="/menus/${menu.name}/addDish" var="menuActionUrl"/>--%>

<%--<form:form action="${menuActionUrl}" modelAttribute="dish" method="post">--%>

    <%--<spring:bind path="dish">--%>
        <%--<label class="col-sm-2 control-label"><h4>Select a dish to add to the menu:</h4></label>--%>
        <%--<div class="col-sm-2">--%>

            <%--<form:select path="name" class="form-control" multiple="false">--%>
                <%--<form:option value="NONE" label="--SELECT--"/>--%>
                <%--<form:options items="${dishNameList.values()}"/>--%>
            <%--</form:select>--%>
        <%--</div>--%>
    <%--</spring:bind>--%>

    <%--<button type="submit" class="btn-lg btn-primary ">Add dish</button>--%>
<%--</form:form>--%>

<%--<a href="/menus/edit/add" button type="submit" class="btn-lg btn-danger">Add Menu</a></button>--%>

</body>
</html>
