<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<body>

<h1 style="text-align: center; color: #761c19">Menu: ${menu.name}</h1>

<hr>

<div style="width: 50%; margin-left: 20px">

    <h1 style="color: #985f0d"> List of dishes: </h1>


    <table border="1" style="align-items: center" class="table table-striped">
        <thead>
        <tr>
            <th>Name</th>
            <th>Dish Category</th>
            <th>Price</th>
            <th>Weight</th>

        </tr>
        </thead>

        <c:forEach items="${menu.dishes}" var="dishes">
            <tr>
                <td>${dishes.name}</td>
                <td>${dishes.category}</td>
                <td>${dishes.price}</td>
                <td>${dishes.weight}</td>
            </tr>
        </c:forEach>

    </table>
</div>
<hr>

<spring:url value="/menus/${menu.name}/addDish" var="menuActionUrl"/>

<form:form action="${menuActionUrl}" modelAttribute="dish" method="post">

    <spring:bind path="dish">
        <label class="col-sm-2 control-label"><h4>Select a dish to add to the menu:</h4></label>
        <div class="col-sm-2">

            <form:select path="name" class="form-control" multiple="false">
                <form:option value="NONE" label="--SELECT--"/>
                <form:options items="${dishNameList.values()}"/>
            </form:select>
        </div>
    </spring:bind>

    <button type="submit" class="btn-lg btn-primary ">Add dish</button>
</form:form>


<%--<h3>Add Dish to Menu:</h3>
<form action="/menus/addDish" method="post">
    <input type="hidden" name="menuId" id="menuId" value=${menu.id}>
    <label for="dishId">Dish:</label>
<select id="dishId" name="dishId">
    <c:forEach var="list" items="${dishNameList}">
        <option value="${list.key}">${list.value}</option>
    </c:forEach>
</select>
<button class="btn btn-default" onclick="addDishToMenu(${menu.id}, document.getElementById('dishId'))">Add Dish</button>
</form>--%>


</body>
</html>