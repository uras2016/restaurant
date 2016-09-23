<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<head>
    <title>Spring MVC Form Handling Example</title>

    <spring:url value="/resources/core/css/hello.css" var="coreCss" />
    <spring:url value="/resources/core/css/bootstrap.min.css"
                var="bootstrapCss" />
    <link href="${bootstrapCss}" rel="stylesheet" />
    <link href="${coreCss}" rel="stylesheet" />
</head>

<spring:url value="/" var="urlHome" />
<%--<spring:url value="/admin/menus/add" var="urlAddMenu" />--%>

<nav class="navbar navbar-inverse ">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="${urlHome}">Главная</a>
        </div>
        <%--<div id="navbar">--%>
            <%--<ul class="nav navbar-nav navbar-right">--%>
                <%--<li class="active"><a href="${urlAddMenu}">Добавить меню</a></li>--%>
            <%--</ul>--%>
        <%--</div>--%>
    </div>
</nav>