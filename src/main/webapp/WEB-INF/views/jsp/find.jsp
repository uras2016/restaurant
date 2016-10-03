<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>



<div align="center" style="width: 100%; margin-left: 1px">


    <h2 style="text-align: center; color: #23527c">Блюдо</h2>
    <br>

    <spring:url value="/find" var="indexActionUrl"/>
    <form:form class="form-horizontal" method="get" action="${indexActionUrl}">
        <div align="center" class="container">
            <div class="row">
                <div class="search">
                    <input type="text" class="form-control input-sm" name="name" placeholder="Название блюда"/>
                    <button type="submit" class="btnn btn-primary btn-sm">Поиск</button>
                </div>
            </div>
        </div>
    </form:form>

    <table align="center" border="0.2" style="align-items: center" class="table table-striped">
        <thead style="color:white;background-color:#2e6da4">
        <tr>
            <td>Блюдо</td>
            <td>Категория</td>
            <td>Цена</td>
            <td>Вес</td>
            <td>Мера</td>
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
<p><a href="/">Go home</a></p>

</html>