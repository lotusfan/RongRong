<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>pictureTbDB</title>
    <script src="<c:url value="/jsdb/jquery-1.11.1.js"/> " language="JavaScript"></script>
    <script src="<c:url value="/jsdb/jquery.json-2.4.js"/> " language="JavaScript"></script>
    <script src="<c:url value="/jsdb/pictureTb.js"/> " language="JavaScript"></script></head>
<body>

<table>
    <tr>
        <td>id</td>
        <td>type</td>
        <td>url</td>
        <td>relationId</td>
        <td>status</td>
        <td>createTime</td>
    </tr>
    <c:forEach var="oo" items="${pictureTb}">
        <tr>
        <td><input class="ooid" value="${oo.id}" readonly="true" /></td>
        <td><input class="ootype" value="${oo.type}" /></td>
        <td><input class="oourl" value="${oo.url}" /></td>
        <td><input class="oorelationId" value="${oo.relationId}" /></td>
        <td><input class="oostatus" value="${oo.status}" /></td>
        <td><input class="oocreateTime" value="${oo.createTime}" /></td>
        <td><button class="alb">修改</button></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>