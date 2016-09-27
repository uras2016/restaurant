<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src='js/login.js' type='text/javascript'></script>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
    <style>
    /* наша HTML таблица */
    table.sort{
    border-spacing:0.1em;
    margin-bottom:1em;
    margin-top:1em
    }

    /* ячейки таблицы */
    table.sort td{
    border:1px solid #CCCCCC;
    padding:0.3em 1em
    }

    /* заголовки таблицы */
    table.sort thead td{
    cursor:pointer;
    cursor:hand;
    font-weight:bold;
    text-align:center;
    vertical-align:middle
    }

    /* заголовок отсортированного столбца */
    table.sort thead td.curcol{
    background-color:#999999;
    color:#FFFFFF
    }
    </style>
</head>

<jsp:include page="../fragments/header.jsp" />

<body>



<div style="width: 35%; margin-left: 30px">


    <h1>Все меню</h1>



        <table class="sort" align="center" border="0.2" style="align-items: center" >


            <thead style = "color:white;background-color:#2e6da4">
        <tr>
            <td>Название</td>
            <td>Опции</td>
            <td></td>
        </tr>
        </thead>

        <c:forEach var="menu" items="${menus}">
            <tbody>
            <tr>
                <td><a href="/admin/menus/menu/${menu.id}">${menu.name}</a></td>

                <td style="align-items: center; width: 20px">
                    <spring:url value="/admin/menus/${menu.id}/delete" var="deleteUrl"/>
                    <a href="${deleteUrl}">Delete</a>
                </td>
                <td style="align-items: center; width: 20px">
                    <spring:url value="/admin/menus/${menu.id}/update" var="updateUrl"/>
                    <a href="${updateUrl}">Edit</a>

                </td>
            </tr>
            </tbody>

        </c:forEach>

    </table>



        <spring:url value="/admin/menus/add" var="addUrl" />
        <button class="btn btn-primary" onclick="location.href='${addUrl}'">Добавить меню</button>
        <br>
        <br>

</div>
<p><a href="/admin">Go to options</a></p>

<jsp:include page="../fragments/footer.jsp" />

</body>


</html>