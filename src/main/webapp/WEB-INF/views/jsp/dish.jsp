<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">


<div>
    <div  style="width: 100%; margin-left: 1px">

        <body>

        <h2 align="center" style="margin-left: 1px; color: #23527c">${dish.name}</h2>
        <div style="width: 100%; margin-left: 1px">

            <hr>
            <h3 align="center" style="margin-left: 50px; color: #23527c">Ингредиенты:</h3>

            <div align="center" align="center" style="width: 100%; margin-left: 20px">
                <table border="0.2" style="align-items: center" class="table table-striped">
                    <thead align="center" style="color:#2e6da4;background-color:transparent">
                    <tr>
                        <th></th>
                    </tr>
                    </thead>

                    <c:forEach items="${ingredients}" var="ingredient">
                        <tr>
                            <td>${ingredient.name}</td>
                        </tr>

                    </c:forEach>
                </table>
                <p><a href="/">Go home</a></p>
            </div>
        </div>
        </body>
    </div>
</div>
</html>
