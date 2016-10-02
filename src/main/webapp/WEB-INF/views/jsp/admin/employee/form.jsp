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
        <c:when test="${employeeForm['new']}">
            <h1>Добавить нового сотрудника</h1>
        </c:when>
        <c:otherwise>
            <h1>Изменить данные</h1>
        </c:otherwise>
    </c:choose>
    <br />

    <spring:url value="/admin/employees" var="employeeActionUrl"/>

    <form:form class="form-horizontal" method="post" modelAttribute="employeeForm" action="${employeeActionUrl}">

        <form:hidden path="id" />

        <spring:bind path="name">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Имя</label>
                <div class="col-sm-10">
                    <form:input path="name" type="text" class="form-control " id="name" placeholder="Name" required="required"/>
                    <form:errors path="name" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="surname">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Фамилия</label>
                <div class="col-sm-10">
                    <form:input path="surname" type="text" class="form-control " id="surname" placeholder="Surname" required="required"/>
                    <form:errors path="surname" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="telephone">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Телефон</label>
                <div class="col-sm-10">
                    <form:input path="telephone" type="text" class="form-control " id="telephone" placeholder="Phone number" required="required"/>
                    <form:errors path="telephone" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="position">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Должность</label>
                <div class="col-sm-10">
                    <form:input path="position" type="text" class="form-control " id="Position" placeholder=" WAITER, COOKER, MANAGER " required="required"/>
                    <form:errors path="position" class="control-label" />
                </div>
            </div>
        </spring:bind>


        <spring:bind path="salary">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Оклад</label>
                <div class="col-sm-10">
                    <form:input path="salary" type="text" class="form-control " id="salary" placeholder="Salary" required="required"/>
                    <form:errors path="salary" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="birthday">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">ДР</label>
                <div class="col-sm-10">
                    <form:input path="birthday" type="text" class="form-control " id="birthday" placeholder="Birthday" required="required"/>
                    <form:errors path="birthday" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${employeeForm['new']}">
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