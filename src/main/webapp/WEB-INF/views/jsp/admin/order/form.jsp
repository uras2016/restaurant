<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp" />

<div class="container">

    <c:choose>
        <c:when test="${orderForm['new']}">
            <h1>Добавить новый заказ</h1>
        </c:when>
        <c:otherwise>
            <h1>Изменить заказ</h1>
        </c:otherwise>
    </c:choose>
    <br />

    <spring:url value="/admin/orders" var="orderActionUrl"/>

    <form:form class="form-horizontal" method="post" modelAttribute="orderForm" action="${orderActionUrl}">

        <form:hidden path="id" />

        <spring:bind path="tableNumber">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Столик</label>
                <div class="col-sm-10">
                    <form:input path="tableNumber" type="number" class="form-control " id="tableNumber" placeholder="Table" required="required"/>
                    <form:errors path="tableNumber" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="waiter">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Официант</label>
                <div class="col-sm-10">
                    <form:input path="waiter" type="number" class="form-control " id="waiter" placeholder="WAITER" required="required"/>
                    <form:errors path="waiter" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="orderDate">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Дата</label>
                <div class="col-sm-10">
                    <form:input path="orderDate" type="dateTime" class="form-control " id="orderDate" placeholder="Date" required="required"/>
                    <form:errors path="orderDate" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="status">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Вес</label>
                <div class="col-sm-10">
                    <form:input path="status" type="text" class="form-control " id="status" placeholder="OPEN, CLOSE" required="required"/>
                    <form:errors path="status" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${dishForm['new']}">
                        <button type="submit" class="btn-lg btn-primary pull-right">Добавить</button>
                    </c:when>
                    <c:otherwise>
                        <button type="submit" class="btn-lg btn-primary pull-left">Сохранить</button>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>

</div>

<jsp:include page="../fragments/footer.jsp" />
<p><a href="/admin">Go to options</a></p>

</body>
</html>