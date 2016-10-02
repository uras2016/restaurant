<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


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


    <h1>Все заказы</h1>



    <table table class="sort" align="center" border="0.2" style="align-items: center" class="table table-striped">
        <thead style = "color:white;background-color:#2e6da4">
        <tr>
            <td>Номер заказа</td>
            <td>Столик</td>
            <td>Официант</td>
            <td>Дата заказа</td>
            <td>Выполнен</td>
            <td colspan="2" align="center">Опции</td>
        </tr>
        </thead>

        <c:forEach var="order" items="${orders}">
            <tr>
                <td><a href="/admin/orders/order/${order.id}">${order.id}</a></td>
                <td>${order.tableNumber}</td>
                <td>${order.waiter.name}</td>
                <td>${order.orderDate}</td>
                <td>${order.status}</td>

                <td style="align-items: center; width: 20px">
                    <spring:url value="/admin/orders/${order.id}/delete" var="deleteUrl"/>
                    <a href="${deleteUrl}">Delete</a>
                </td>
                <td style="align-items: center; width: 20px">
                    <spring:url value="/admin/orders/${order.id}/close" var="closeUrl"/>
                    <a href="${closeUrl}">Close</a>
                </td>

                </td>

            </tr>

        </c:forEach>

    </table>

    <script type="text/javascript">
        <!--
        /*
         originally written by paul sowden <paul@idontsmoke.co.uk> | http://idontsmoke.co.uk
         modified and localized by alexander shurkayev <alshur@ya.ru> | http://htmlcssjs.ru
         */

        var img_dir = "/resources/images/"; // папка с картинками
        var sort_case_sensitive = false; // вид сортировки (регистрозависимый или нет)

        // ф-ция, определяющая алгоритм сортировки
        function _sort(a, b) {
            var a = a[0];
            var b = b[0];
            var _a = (a + '').replace(/,/, '.');
            var _b = (b + '').replace(/,/, '.');
            if (parseFloat(_a) && parseFloat(_b)) return sort_numbers(parseFloat(_a), parseFloat(_b));
            else if (!sort_case_sensitive) return sort_insensitive(a, b);
            else return sort_sensitive(a, b);
        }

        // ф-ция сортировки чисел
        function sort_numbers(a, b) {
            return a - b;
        }

        // ф-ция регистронезависимой сортировки
        function sort_insensitive(a, b) {
            var anew = a.toLowerCase();
            var bnew = b.toLowerCase();
            if (anew < bnew) return -1;
            if (anew > bnew) return 1;
            return 0;
        }

        // ф-ция регистрозависимой сортировки
        function sort_sensitive(a, b) {
            if (a < b) return -1;
            if (a > b) return 1;
            return 0;
        }

        // вспомогательная ф-ция, выдирающая из дочерних узлов весь текст
        function getConcatenedTextContent(node) {
            var _result = "";
            if (node == null) {
                return _result;
            }
            var childrens = node.childNodes;
            var i = 0;
            while (i < childrens.length) {
                var child = childrens.item(i);
                switch (child.nodeType) {
                    case 1: // ELEMENT_NODE
                    case 5: // ENTITY_REFERENCE_NODE
                        _result += getConcatenedTextContent(child);
                        break;
                    case 3: // TEXT_NODE
                    case 2: // ATTRIBUTE_NODE
                    case 4: // CDATA_SECTION_NODE
                        _result += child.nodeValue;
                        break;
                    case 6: // ENTITY_NODE
                    case 7: // PROCESSING_INSTRUCTION_NODE
                    case 8: // COMMENT_NODE
                    case 9: // DOCUMENT_NODE
                    case 10: // DOCUMENT_TYPE_NODE
                    case 11: // DOCUMENT_FRAGMENT_NODE
                    case 12: // NOTATION_NODE
                        // skip
                        break;
                }
                i++;
            }
            return _result;
        }

        // суть скрипта
        function sort(e) {
            var el = window.event ? window.event.srcElement : e.currentTarget;
            while (el.tagName.toLowerCase() != "td") el = el.parentNode;
            var a = new Array();
            var name = el.lastChild.nodeValue;
            var dad = el.parentNode;
            var table = dad.parentNode.parentNode;
            var up = table.up;
            var node, arrow, curcol;
            for (var i = 0; (node = dad.getElementsByTagName("td").item(i)); i++) {
                if (node.lastChild.nodeValue == name){
                    curcol = i;
                    if (node.className == "curcol"){
                        arrow = node.firstChild;
                        table.up = Number(!up);
                    }else{
                        node.className = "curcol";
                        arrow = node.insertBefore(document.createElement("img"),node.firstChild);
                        table.up = 0;
                    }
                    arrow.src = img_dir + table.up + ".gif";
                    arrow.alt = "";
                }else{
                    if (node.className == "curcol"){
                        node.className = "";
                        if (node.firstChild) node.removeChild(node.firstChild);
                    }
                }
            }
            var tbody = table.getElementsByTagName("tbody").item(0);
            for (var i = 0; (node = tbody.getElementsByTagName("tr").item(i)); i++) {
                a[i] = new Array();
                a[i][0] = getConcatenedTextContent(node.getElementsByTagName("td").item(curcol));
                a[i][1] = getConcatenedTextContent(node.getElementsByTagName("td").item(1));
                a[i][2] = getConcatenedTextContent(node.getElementsByTagName("td").item(0));
                a[i][3] = node;
            }
            a.sort(_sort);
            if (table.up) a.reverse();
            for (var i = 0; i < a.length; i++) {
                tbody.appendChild(a[i][3]);
            }
        }

        // ф-ция инициализации всего процесса
        function init(e) {
            if (!document.getElementsByTagName) return;

            for (var j = 0; (thead = document.getElementsByTagName("thead").item(j)); j++) {
                var node;
                for (var i = 0; (node = thead.getElementsByTagName("td").item(i)); i++) {
                    if (node.addEventListener) node.addEventListener("click", sort, false);
                    else if (node.attachEvent) node.attachEvent("onclick", sort);
                    node.title = "Нажмите на заголовок, чтобы отсортировать колонку";
                }
                thead.parentNode.up = 0;

                if (typeof(initial_sort_id) != "undefined"){
                    td_for_event = thead.getElementsByTagName("td").item(initial_sort_id);
                    if (document.createEvent){
                        var evt = document.createEvent("MouseEvents");
                        evt.initMouseEvent("click", false, false, window, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, td_for_event);
                        td_for_event.dispatchEvent(evt);
                    } else if (td_for_event.fireEvent) td_for_event.fireEvent("onclick");
                    if (typeof(initial_sort_up) != "undefined" && initial_sort_up){
                        if (td_for_event.dispatchEvent) td_for_event.dispatchEvent(evt);
                        else if (td_for_event.fireEvent) td_for_event.fireEvent("onclick");
                    }
                }
            }
        }

        // запускаем ф-цию init() при возникновении события load
        var root = window.addEventListener || window.attachEvent ? window : document.addEventListener ? document : null;
        if (root){
            if (root.addEventListener) root.addEventListener("load", init, false);
            else if (root.attachEvent) root.attachEvent("onload", init);
        }
        //-->
    </script>
    <spring:url value="/admin/orders/add" var="addUrl" />
    <button class="btn btn-primary" onclick="location.href='${addUrl}'">Добавить заказ</button>
    <br>
    <br>

</div>
<p><a href="/admin">Go to options</a></p>

<jsp:include page="../fragments/footer.jsp" />

</body>


</html>