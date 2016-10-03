<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Контакты</title>

    <div class="container">
        <div class="clearfix">
            <div class="h_left">
                <center>
                    <h2>РЕСТОРАН "ТОчКА"</h2>
                </center>
                <a class="h_phone" href="tel:+38099495988">+ 38 099 888 90 09</a>
                <span class="h_phone-info">Единый телефон ресторана "ТОчКА"</span>
            </div>
            <div class="h_right">
                <div class="h_lang"><a href="about.html">RU</a> / <a
                        href="http://translate.google.com/translate?sl=ru&tl=en&u=http://rappoport.restaurant/about.html">EN</a>
                </div>

                <a class="h_email" href="mailto:info@krya-krya.restaurant">info@tochka.restaurant</a>
            </div>
        </div>
        <nav>
            <div class="menu-box clearfix">
                <ul class="menu menu__left">
                    <li class="information">Контакты: г.Киев, ул. Главная, Д.1</li>
                </ul>
            </div>
        </nav>
    </div>

</head>
<body>

<center>
    <h2>Схема проезда</h2>
</center>

<div style="margin-left: 20px">
    <table style="width: 100%">

        <td>
            <h2>Схема проезда</h2>
            <img src="<c:url value="/resources/images/proezd.jpg"/>">
        </td>

    </table>

</div>
<a href="/">Go Home</a>
</body>
</html>
