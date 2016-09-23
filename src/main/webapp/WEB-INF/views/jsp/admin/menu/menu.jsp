<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<!DOCTYPE html>
<html lang="en">

<jsp:include page="../menu/header.jsp" />

<body>
<h1>Меню ${menu.name}</h1>

<table border="1" style="align-items: center" class="table table-striped">
    <thead style = "color:white;background-color:grey">
    <tr>
        <th>Название блюда</th>
        <th>Категория</th>
        <th>Цена</th>
        <th>Вес</th>
        <th>Мера</th>
        <th></th>

    </tr>
    </thead>


    <c:forEach  var="dish" items="${menu.dishes}">
        <tr>
            <td>${dish.name}</td>
            <td>${dish.category}</td>
            <td>${dish.price}</td>
            <td>${dish.weight}</td>
            <td>${dish.measure}</td>
            <td style="align-items: center; width: 20px">
                <spring:url value="/admin/menus/${menu.id}/deleteDish/${dish.id}" var="deleteDishFromMenuUrl"/>
                <a href="${deleteDishFromMenuUrl}"></a>
            </td>
        </tr>
    </c:forEach>

</table>

</div>
<hr>
<br>
<br>
<br>


<spring:url value="/admin/menus/${menu.id}/addDish" var="menuActionUrl"/>

<form:form action="${menuActionUrl}" modelAttribute="dish" method="post">

    <spring:bind path="dish">
        <label class="col-sm-2 control-label"><h4>Выберите блюдо</h4></label>
        <div class="col-sm-2">

            <form:select path="name" class="form-control" multiple="false">
                <form:option value="NONE" label="--SELECT--"/>
                <form:options items="${dishNameList.values()}"/>
            </form:select>
        </div>
    </spring:bind>

    <button type="submit" class="btn-lg btn-primary ">Добавить</button>
</form:form>



</body>
<p><a href="/admin/menus">Go to menu list</a></p>
</html>
