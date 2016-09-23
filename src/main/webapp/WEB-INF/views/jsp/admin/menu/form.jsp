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
        <c:when test="${menuForm['new']}">
            <h1>Добавить новое меню</h1>
        </c:when>
        <c:otherwise>
            <h1>Изменить меню</h1>
        </c:otherwise>
    </c:choose>
    <br />

    <spring:url value="/admin/menus" var="menuActionUrl"/>

    <form:form class="form-horizontal" method="post" modelAttribute="menuForm" action="${menuActionUrl}">

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


        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${menuForm['new']}">
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