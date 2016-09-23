<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <title>Admin</title>

    <spring:url value="/resources/core/css/hello.css" var="coreCss" />
    <spring:url value="/resources/core/css/bootstrap.min.css"
                var="bootstrapCss" />
    <link href="${bootstrapCss}" rel="stylesheet" />
    <link href="${coreCss}" rel="stylesheet" />
</head>

<spring:url value="/" var="urlHome" />


<nav class="navbar navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="${urlHome}">Главная</a>
        </div>

    </div>
</nav>