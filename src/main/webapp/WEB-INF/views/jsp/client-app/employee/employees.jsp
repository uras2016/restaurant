<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <h2 align="center">Наш персонал</h2>

</head>
<body>
<center>
    <div style="width: 60%; margin-left: 100px">
        <table style="align-items:center">

            <tr>
                <td>
                    <table border="0.2" style="align-items: center" class="table ">

                        <tr>

                            <td height="140" style="align-items: center" ; width="20%">
                                <img src="<c:url value="/resources/images/muzhik1.jpg"/>"/>
                            </td>
                        <tr>
                            <td height="140" style="align-items: center" ; width="20%">
                                <img src="<c:url value="/resources/images/muzhik2.jpg"/>"/>
                            </td>
                        <tr>
                            <td height="140" style="align-items: center" ; width="20%">
                                <img src="<c:url value="/resources/images/katya.jpg"/>"/>
                            </td>
                        </tr>
                        <tr>
                            <td height="140" style="align-items: center" ; width="20%">
                                <img src="<c:url value="/resources/images/anna.jpg"/>"/>
                            </td>
                        <tr>
                            <td height="140" style="align-items: center" ; width="20%">
                                <img src="<c:url value="/resources/images/muzhik3.jpg"/>"/>
                            </td>
                        </tr>
                    </table>
                </td>
                <td>
                        <table border="0.2" style="align-items: center" class="table ">

                        <c:forEach var="employee" items="${employees}">

                            <tr>

                                <td height="140"><a href="/employee?employeeName=${employee.name}"> ${employee.name}</a></td>
                                <%--<td height="15">${employee.position}</td>--%>

                            </tr>

                        </c:forEach>
                    </table>
                </td>
            </tr>

        </table>
    </div>

    <a href="/">Go Home</a>
    <%--<a href="/">Short info</a>--%>
</center>
</body>
</html>
