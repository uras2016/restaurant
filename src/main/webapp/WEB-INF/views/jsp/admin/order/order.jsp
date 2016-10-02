<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp" />

<div>
    <div style="width: 35%; margin-left: 30px">
        <h2>Заказ ${order.id}</h2>

        <table border="3" style="align-items: center" class="table table-view">
            <thead style = "color:white;background-color:#2e6da4">
            <tr>
                <th>Название блюда</th>
                <th>Категория</th>
                <th>Цена</th>
                <th>Вес</th>
                <th>Мера</th>
                <th>Опция</th>

            </tr>
            </thead>


            <c:forEach  var="dish" items="${order.dishes}">
                <tr>
                    <td>${dish.name}</td>
                    <td>${dish.category}</td>
                    <td>${dish.price}</td>
                    <td>${dish.weight}</td>
                    <td>${dish.measure}</td>
                    <td style="align-items: center; width: 1px">
                        <spring:url value="/admin/orders/${order.id}/deleteDish/${dish.id}" var="deleteDishFromOrderUrl"/>
                        <a href="${deleteDishFromOrderUrl}">Delete</a>
                    </td>
                </tr>
            </c:forEach>

        </table>

    </div>
    <hr>
    <br>
    <br>
    <br>


    <spring:url value="/admin/orders/${order.id}/addDish" var="orderActionUrl"/>

    <form:form action="${orderActionUrl}" modelAttribute="dish" method="post">

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


</div>
</body>
<p><a href="/admin/orders">Go to order list</a></p>
</html>
