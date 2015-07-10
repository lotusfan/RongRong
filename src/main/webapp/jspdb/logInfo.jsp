<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>logInfoDB</title>
    <script src="<c:url value="/jsdb/jquery-1.11.1.js"/> " language="JavaScript"></script>
    <script src="<c:url value="/jsdb/jquery.json-2.4.js"/> " language="JavaScript"></script>
    <script src="<c:url value="/jsdb/logInfo.js"/> " language="JavaScript"></script></head>
<body>

<table>
    <tr>
        <td>id</td>
        <td>userId</td>
        <td>ip</td>
        <td>longitude</td>
        <td>latitude</td>
        <td>type</td>
        <td>uuid</td>
        <td>createTime</td>
    </tr>
    <c:forEach var="oo" items="${logInfo}">
        <tr>
        <td><input class="ooid" value="${oo.id}" readonly="true" /></td>
        <td><input class="oouserId" value="${oo.userId}" /></td>
        <td><input class="ooip" value="${oo.ip}" /></td>
        <td><input class="oolongitude" value="${oo.longitude}" /></td>
        <td><input class="oolatitude" value="${oo.latitude}" /></td>
        <td><input class="ootype" value="${oo.type}" /></td>
        <td><input class="oouuid" value="${oo.uuid}" /></td>
        <td><input class="oocreateTime" value="${oo.createTime}" /></td>
        <td><button class="alb">修改</button></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>