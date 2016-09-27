<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<body>

<h2 style="margin-left: 50px; color: #23527c">${dish.name}</h2>
<div style="width: 75%; margin-left: 20px">

<hr>
<h3 style="margin-left: 50px; color: #23527c">Ингредиенты:</h3>

<div style="width: 20%; margin-left: 20px">
    <table border="0.2" style="align-items: center" class="table table-striped">
        <thead style = "color:white;background-color:#a947e4">
        <tr>
            <th>Название ингредиента</th>
        </tr>
        </thead>

        <c:forEach items="${ingredients}" var="ingredient">
        <tr>
            <td>${ingredient.name}</td>
        </tr>

        </c:forEach>

</div>


</body>
</html>