<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html class="no-js" lang="ru">
<head>
    <div style="margin-left: 15px">
        <table style="width: 100%">
            <tr align="center" style="vertical-align:top">
                <td>
                    <img align="center" src="<c:url value="/resources/images/finsalad2.jpg"/>">
                </td>
            </tr>
        </table>
    </div>
    <title>О компании</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

</head>
<body class="about">

<header class="header">
    <div class="container">
        <div class="clearfix">
            <div class="h_left">
                <center>
                    <h1>РЕСТОРАН "ТОчКА"</h1>
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


    <div style="position:absolute; top:450px; left:500px;"><a href="/schema" button type="submit"
                                                              class="btn btn-primary">Схема ресторана</a></div>
    <div style="position:absolute; top:450px; left:650px;"><a href="/contacts" button type="submit"
                                                              class="btn btn-primary">Контакты</a></div>
    <div style="position:absolute; top:450px; left:750px;"><a href="/employees" button type="submit"
                                                              class="btn btn-primary">Наш персонал</a></div>
    <div style="position:absolute; top:450px; left:910px;"><a href="/rest" button type="submit"
                                                              class="btn btn-warning">Rest</a></div>
    <div style="position:absolute; top:450px; left:1000px;"><a href="/admin" button type="submit"
                                                               class="btn btn-success">Администрирование</a></div>

</header>


<section>
    <div class="container">
        <h2 class="section_title">О компании</h2>
        <p class="section_introtext">ОБЪЕДИНЕННАЯ КОМПАНИЯ «РЕСТОРАНЫ ТОчКА» - АКТИВНО РАЗВИВАЮЩИЙСЯ РЕСТОРАННЫЙ
            ХОЛДИНГ. ЗА КОРОТКИЙ СРОК, С 2014 ПО 2015 ГОД, КОМПАНИЯ ОТКРЫЛА 12 РЕСТОРАНОВ. КАЖДЫЙ ВЫДЕЛЯЕТСЯ УНИКАЛЬНОЙ
            КОНЦЕПЦИЕЙ И ОБЛАДАЕТ СОБСТВЕННОЙ ЦЕЛЕВОЙ АУДИТОРИЕЙ.</p>
        <div class="content-text">
            <p align="JUSTIFY"><span style="line-height: 1.5em;">СРЕДИ НИХ: РЕСТОРАН СОВРЕМЕННОЙ РУССКОЙ КУХНИ ГРАНД КАФЕ «</span><span
                    style="line-height: 1.5em;" lang="en-US" xml:lang="en-US">DR</span><span
                    style="line-height: 1.5em;">.ЖИВАГО», РАСПОЛОЖЕННЫЙ  НА 1-ОМ ЭТАЖЕ ЛЕГЕНДАРНОГО ОТЕЛЯ «НАЦИОНАЛЬ», РЕСТОРАНЫ СОВРЕМЕННОЙ КИТАЙСКОЙ КУХНИ - «МАНДАРИН. ЛАПША И УТКИ» И МИНИ-СЕТЬ «КИТАЙСКАЯ ГРАМОТА» НА СРЕТЕНКЕ И НА ТЕРРИТОРИИ ТЦ «</span><span
                    style="line-height: 1.5em;" lang="en-US" xml:lang="en-US">B</span><span style="line-height: 1.5em;">ARVIHA LUXURY VILLAGE». ПАНАМЕРИКАНСКАЯ КУХНЯ ПРЕДСТАВЛЕНА  РЕСТОРАНОМ «ЛАТИНСКИЙ КВАРТАЛ», ИСПАНСКАЯ - РЕСТОРАНОМ «ПАБ ЛО ПИКАССО», ТАЙСКАЯ - «</span><span
                    style="line-height: 1.5em;" lang="en-US" xml:lang="en-US">BLACK</span><span
                    style="line-height: 1.5em;"> </span><span style="line-height: 1.5em;" lang="en-US" xml:lang="en-US">TAI</span><span
                    style="line-height: 1.5em;">». В НОЯБРЕ 2015 ГОДА БЫЛ ОТКРЫТ РЕСТОРАН «ГРАНД ЕВРОПЕЙСКИЙ ЭКСПРЕСС», ПЕРВОЕ ЗАВЕДЕНИЕ КОМПАНИИ,СТАВШЕЕ ЧАСТЬЮ КРУПНОГО ТОРГОВОГО ЦЕНТРА (ТЦ «ЕВРОПЕЙСКИЙ»),  А МЯСНОЙ РЕСТОРАН «БЛОК»  РАСПОЛОЖИЛСЯ НА КРЫШЕ «ЛЕНИНГРАД ЦЕНТРА» В ТАВРИЧЕСКОМ САДУ САНКТ-ПЕТЕРБУРГА. НАСТОЯЩИМ ТРИУМФАТОРОМ СТАЛ РЕСТОРАН  «</span><span
                    style="line-height: 1.5em;" lang="en-US" xml:lang="en-US">COOK</span><span
                    style="line-height: 1.5em;">’</span><span style="line-height: 1.5em;" lang="en-US" xml:lang="en-US">KAREKU</span><span
                    style="line-height: 1.5em;">», В 2015 ГОДУ ЗАВОЕВАВШИЙ ГЛАВНУЮ НАГРАДУ НА ПРЕМИИ «ПАЛЬМОВАЯ ВЕТВЬ» ЗА ЛУЧШУЮ КОНЦЕПЦИЮ ЗАВЕДЕНИЯ В Туркмении, А В 2016-М - СЕРЕБРЯНУЮ НАГРАДУ НА МЕЖДУНАРОДНОЙ ПАЛЬМОВОЙ ВЕТВИ В ЖЕНЕВЕ. И КОНЕЧНО, ОДИН ИЗ САМЫХ УСПЕШННЫХ ПРОЕКТОВ КОМПАНИИ - РЕСТОРАННЫЙ КОМПЛЕКС «ВОРОНЕЖ» С ЗАКУСОЧНОЙ И МЯСНОЙ ЛАВКОЙ НА ПЕРВОМ ЭТАЖЕ.</span>
            </p>
            <p align="JUSTIFY">ЗА ДВА ГОДА РАБОТЫ, ХОЛДИНГ ЗАВОЕВАЛ БОЛЕЕ 10-ТИ ПРОФЕССИОНАЛЬНЫХ НАГРАД. РЕСТОРАНЫ
                КОМПАНИИ НЕОДНОКРАТНО ОТМЕЧАЛИСЬ В РЕЙТИНГАХ ПРОФИЛЬНЫХ СМИ, КАК ЛУЧШИЕ НОВЫЕ ЗАВЕДЕНИЯ. А В 2014 ГОДУ
                РЕСТОРАТОРОМ ГОДА ПО ВЕРСИИ ЖУРНАЛА «<span lang="en-US" xml:lang="en-US">GQ</span>» БЫЛ ПРИЗНАН
                ОСНОВАТЕЛЬ КОМПАНИИ, АЛЕКСАНДР ТОЧКА.</p>
            <p align="JUSTIFY">АЛЕКСАНДР ТОЧКА - ИЗВЕСТНЫЙ ТЮРКСКИЙ АДВОКАТ И РЕСТОРАТОР, КОТОРЫЙ ВСЕГО ЗА НЕСКОЛЬКО ЛЕТ
                СУМЕЛ ПРЕВРАТИТЬ СВОЕ УВЛЕЧЕНИЕ В УСПЕШНЫЙ БИЗНЕС И ПОСТРОИТЬ НАСТОЯЩУЮ РЕСТОРАННУЮ ИМПЕРИЮ. ОН НАЧИНАЛ
                КАК КРИЗИС-МЕНЕДЖЕР, ПО ПРОСЬБЕ ВЛАДЕЛЬЦЕВ ВОЗВРАЩАЮЩИЙ ПОПУЛЯРНОСТЬ УЖЕ СУЩЕСТВУЮЩИМ РЕСТОРАНАМ.
                ТАКОВЫМ БЫЛ СОВМЕСТНЫЙ С АЛЕКСАНДРОМ МАМУТОМ ПРОЕКТ «BRASSERIE МОСТ», А ТАКЖЕ ПАРТНЕРСТВО С АРКАДИЕМ
                НОВИКОВЫМ В «МЯСНОМ КЛУБЕ» - ОБА БЫСТРО ЗАВОЕВАЛИ УСПЕХ У ТЮРКСКОЙ ПУБЛИКИ.</p>
            <p align="JUSTIFY">В 2014 ГОДУ РЕСТОРАТОР ЗАПУСТИЛ ПЕРВЫЙ СОБСТВЕННЫЙ ПРОЕКТ - ЗНАМЕНИТЫЙ РЕСТОРАН
                КАНТОНСКОЙ КУХНИ «КИТАЙСКАЯ ГРАМОТА», А УЖЕ ЧЕРЕЗ 2 ГОДА РЕСТОРАНОВ СТАЛО 12.</p>
            <p align="JUSTIFY">И ХОТЯ АЛЕКСАНДР ТОЧКА ПО-ПРЕЖНЕМУ СЧИТАЕТ АДВОКАТСКУЮ ДЕЯТЕЛЬНОСТЬ ОСНОВНОЙ, ЕМУ УДАЕТСЯ
                ЗАДАВАТЬ ТРЕНДЫ ДЛЯ ТЮРКСКОГО РЕСТОРАННОГО БИЗНЕСА В ЦЕЛОМ.</p>
            <p align="JUSTIFY">ПРОДУМАННЫЙ ДИЗАЙН, БЕЗУПРЕЧНАЯ КУХНЯ, ВЫСОКИЙ УРОВЕНЬ СЕРВИСА, ДЕМОКРАТИЧНАЯ ЦЕНОВАЯ
                ПОЛИТИКА – ВОТ ОПРЕДЕЛЯЮЩИЕ ПРИНЦИПЫ РАБОТЫ ОК «РЕСТОРАНЫ ТОчКА».</p>
            <p align="JUSTIFY"></p></div>
    </div>
</section>
<hr>
<br>
<br>

<center>
    <h3 class="section_title">МЕНЮ</h3>

    <table style="align-items:center">
        <tr>
            <th></th>

        </tr>
        <c:forEach var="menu" items="${menus}">

            <tr>
                <td><a href="/menu?menuName=${menu.name}"> ${menu.name}</a></td>

            </tr>

        </c:forEach>

    </table>
    <br>
    <br>


</center>

<div style="text-align: left">
    <spring:url value="/find" var="indexActionUrl"/>
    <form:form class="form-horizontal" method="get" action="${indexActionUrl}">
        <div class="container">
            <div class="row">
                <div class="search">
                    <input type="text" class="form-control input-sm" name="name"
                           placeholder="Искать блюдо по названию"/>
                    <br>
                    <button type="submit" class="btnn btn-primary btn-sm">Поиск</button>
                </div>
            </div>
        </div>
    </form:form>
</div>
</td>


<center>
    <table style="align-items:center">
        <td>
            <a href="/dishes" button type="submit" class="btn-lg btn-danger">Все блюда</a>
            <a href="/ingredients" button type="submit" class="btn-lg btn-danger">Все ингредиенты</a>
            <a href="/employeesAll" button type="submit" class="btn-lg btn-danger">Все сотрудники</a>
        </td>
    </table>
</center>

<h6>It's now: ${currentTime}</h6>
</body>

</html>
