<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>prPraiseTbDB</title>
    <script src="<c:url value="/jsdb/jquery-1.11.1.js"/> " language="JavaScript"></script>
    <script src="<c:url value="/jsdb/jquery.json-2.4.js"/> " language="JavaScript"></script>
    <script src="<c:url value="/jsdb/prPraiseTb.js"/> " language="JavaScript"></script></head>
<body>

<table>
    <tr>
        <td>id</td>
        <td>projectId</td>
        <td>praiseUserId</td>
        <td>createTime</td>
    </tr>
    <c:forEach var="oo" items="${prPraiseTb}">
        <tr>
        <td><input class="ooid" value="${oo.id}" readonly="true" /></td>
        <td><input class="ooprojectId" value="${oo.projectId}" /></td>
        <td><input class="oopraiseUserId" value="${oo.praiseUserId}" /></td>
        <td><input class="oocreateTime" value="${oo.createTime}" /></td>
        <td><button class="alb">修改</button></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>