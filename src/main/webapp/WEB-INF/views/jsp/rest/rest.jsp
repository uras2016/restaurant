<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<jsp:include page="../rest/fragments/header.jsp" />

<head>
    <title>Rest page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>

<p style="width: 50%; margin-left: 20px">


    <h1>Выберите задачу</h1>

    <p border="0.2" style="align-items: center" class="table table-striped">

        <p>
            <col style="align-items: center; width: 20px">
                <a href="/rest/menus" button type="submit"
                   class="btn btn-danger">Список Меню</a></p>

            <spring:url value="/rest/menus/findId" var="storeActionUrl"/>
            <form:form class="form-horizontal" method="get" action="${storeActionUrl}">
        <div class="container">
            <div class="row">
                <div class="search">
                    <input type="number" class="form-control input-sm" name="id" placeholder="Поиск меню по ID"/>
                    <button type="submit" class="btnn btn-primary btn-sm">Меню по ID</button>
                </div>
            </div>
        </div>
        </form:form>
    </p>

    <spring:url value="/rest/menus/find" var="storeActionUrl"/>
    <form:form class="form-horizontal" method="get" action="${storeActionUrl}">
        <div class="container">
            <div class="row">
                <div class="search">
                    <input type="text" class="form-control input-sm" name="name" placeholder="Поиск меню по имени"/>
                    <button type="submit" class="btnn btn-primary btn-sm">Меню по имени</button>
                </div>
            </div>
        </div>
    </form:form>
    </p>


            <col style="align-items: center; width: 20px">
            <a href="/rest/orders" button type="submit"
               class="btn btn-danger">Все заказы</a>
            <span style='padding-left:10px;'> </span>
            <a href="/rest/openOrders" button type="submit"
               class="btn btn-danger">Список открытых заказов</a>
            <span style='padding-left:10px;'> </span>
            <a href="/rest/closedOrders" button type="submit"
               class="btn btn-danger">Список закрытых заказов</a>
    </p>
    <spring:url value="/rest/orders/findId" var="storeActionUrl"/>
    <form:form class="form-horizontal" method="get" action="${storeActionUrl}">
        <div class="container">
            <div class="row">
                <div class="search">
                    <input type="number" class="form-control input-sm" name="id" placeholder="Поиск заказа по ID"/>
                    <button type="submit" class="btnn btn-primary btn-sm">Заказ по ID</button>
                </div>
            </div>
        </div>
    </form:form>
    </p>

            <col style="align-items: center; width: 20px">
            <a href="/rest/employees" button type="submit"
               class="btn btn-danger">Список сотрудников</a>
            </p>
<spring:url value="/rest/employees/findId" var="storeActionUrl"/>
<form:form class="form-horizontal" method="get" action="${storeActionUrl}">
    <div class="container">
        <div class="row">
            <div class="search">
                <input type="number" class="form-control input-sm" name="id" placeholder="Поиск сотрудника по ID"/>
                <button type="submit" class="btnn btn-primary btn-sm">Сотрудник по ID</button>
            </div>
        </div>
    </div>
</form:form>
</p>

<spring:url value="/rest/employees/findName" var="storeActionUrl"/>
<form:form class="form-horizontal" method="get" action="${storeActionUrl}">
    <div class="container">
        <div class="row">
            <div class="search">
                <input type="text" class="form-control input-sm" name="name" placeholder="Поиск сотрудника по имени"/>
                <button type="submit" class="btnn btn-primary btn-sm">Сотрудник по имени</button>
            </div>
        </div>
    </div>
</form:form>
</p>
<spring:url value="/rest/employees/findSurname" var="storeActionUrl"/>
<form:form class="form-horizontal" method="get" action="${storeActionUrl}">
    <div class="container">
        <div class="row">
            <div class="search">
                <input type="text" class="form-control input-sm" name="surname" placeholder="Поиск сотрудника по фамилии"/>
                <button type="submit" class="btnn btn-primary btn-sm">Сотрудник по фамилии</button>
            </div>
        </div>
    </div>
</form:form>
</p>
<spring:url value="/rest/employees/findNameAndSurname" var="storeActionUrl"/>
<form:form class="form-horizontal" method="get" action="${storeActionUrl}">
    <div class="container">
        <div class="row">
            <div class="search">
                <input type="text" class="form-control input-sm" name="name" placeholder="Имя"/>
                <input type="text" class="form-control input-sm" name="surname" placeholder="Фамилия"/>
                <button type="submit" class="btnn btn-primary btn-sm">Сотрудник по имени и фамилии</button>
            </div>
        </div>
    </div>
</form:form>
</p>


        </tr>
    </table>


</div>
<a href="/">Go Home</a>
<jsp:include page="../rest/fragments/footer.jsp" />

</body>
</html>
