<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<jsp:include page="../admin/fragments/header.jsp" />

<head>
    <title>Admin page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>

<div style="width: 50%; margin-left: 20px">


    <h1>Выберите раздел</h1>

    <table border="0.2" style="align-items: center" class="table table-striped">

        <tr>
            <p><col style="align-items: center; width: 20px">
            <a href="/admin/menus" button type="submit"
                   class="btn btn-primary">Меню</a></p>
            <p><col style="align-items: center; width: 20px">
                <a href="/admin/dishes" button type="submit"
                   class="btn btn-primary">Блюда</a></p>
            <col style="align-items: center; width: 20px">
                <a href="/admin/employees" button type="submit"
                   class="btn btn-primary">Персонал</a></p>
            <col style="align-items: center; width: 20px">
                <a href="/admin/store" button type="submit"
                   class="btn btn-primary">Склад</a></p>
            <col style="align-items: center; width: 20px">
                <a href="/admin/orders" button type="submit"
                   class="btn btn-primary">Заказы</a><p>
            <col style="align-items: center; width: 20px">
                <a href="/admin/ingredients" button type="submit"
                   class="btn btn-primary">Ингредиенты</a></col>
            </tr>
        </table>


</div>
    <a href="/">Go Home</a>
    <jsp:include page="../admin/fragments/footer.jsp" />

</body>
</html>
