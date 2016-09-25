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
        <c:when test="${dishForm['new']}">
            <h1>Добавить новое блюдо</h1>
        </c:when>
        <c:otherwise>
            <h1>Изменить блюдо</h1>
        </c:otherwise>
    </c:choose>
    <br />

    <spring:url value="/admin/dishes" var="dishActionUrl"/>

    <form:form class="form-horizontal" method="post" modelAttribute="dishForm" action="${dishActionUrl}">

        <form:hidden path="id" />

        <spring:bind path="name">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Название</label>
                <div class="col-sm-10">
                    <form:input path="name" type="text" class="form-control " id="name" placeholder="Name" required="required"/>
                    <form:errors path="name" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="category">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Категория</label>
                <div class="col-sm-10">
                    <form:input path="category" type="text" class="form-control " id="category" placeholder="Category" required="required"/>
                    <form:errors path="category" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="price">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Цена</label>
                <div class="col-sm-10">
                    <form:input path="price" type="text" class="form-control " id="price" placeholder="Price" required="required"/>
                    <form:errors path="price" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="weight">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Вес</label>
                <div class="col-sm-10">
                    <form:input path="weight" type="text" class="form-control " id="weight" placeholder="Weight" required="required"/>
                    <form:errors path="weight" class="control-label" />
                </div>
            </div>
        </spring:bind>


        <spring:bind path="measure">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Мера</label>
                <div class="col-sm-10">
                    <form:input path="measure" type="text" class="form-control " id="measure" placeholder="Measure" required="required"/>
                    <form:errors path="measure" class="control-label" />
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

</body>
</html>