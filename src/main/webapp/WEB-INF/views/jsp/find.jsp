<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>

<body>

<div style="width: 50%; margin-left: 20px">


    <h2 style="text-align: center; color: #23527c">Блюдо</h2>
    <br>

    <spring:url value="/find" var="indexActionUrl"/>
    <form:form class="form-horizontal" method="get" action="${indexActionUrl}">
        <div class="container">
            <div class="row">
                <div class="search">
                    <input type="text" class="form-control input-sm" name="name" placeholder="Введите название"/>
                    <button type="submit" class="btnn btn-primary btn-sm">Поиск</button>
                </div>
            </div>
        </div>
    </form:form>

    <table border="0.2" style="align-items: center" class="table table-striped">
        <thead style="color:white;background-color:dimgrey">
        <tr>
            <th>Блюдо</th>
            <th>Категория</th>
            <th>Цена</th>
            <th>Вес</th>
            <th>Мера</th>
        </tr>
        </thead>


        <tr>
            <td><a href="/find/${dishes.name}">${dishes.name}</a></td>
            <td>${dishes.category}</td>
            <td>${dishes.price}</td>
            <td>${dishes.weight}</td>
            <td>${dishes.measure}</td>

            </td>
        </tr>


    </table>
</div>
<br/>

</body>
</html>