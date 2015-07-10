<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>prCommentTbDB</title>
    <script src="<c:url value="/jsdb/jquery-1.11.1.js"/> " language="JavaScript"></script>
    <script src="<c:url value="/jsdb/jquery.json-2.4.js"/> " language="JavaScript"></script>
    <script src="<c:url value="/jsdb/prCommentTb.js"/> " language="JavaScript"></script></head>
<body>

<table>
    <tr>
        <td>id</td>
        <td>projectId</td>
        <td>userId</td>
        <td>content</td>
        <td>relationUserId</td>
        <td>createId</td>
    </tr>
    <c:forEach var="oo" items="${prCommentTb}">
        <tr>
        <td><input class="ooid" value="${oo.id}" readonly="true" /></td>
        <td><input class="ooprojectId" value="${oo.projectId}" /></td>
        <td><input class="oouserId" value="${oo.userId}" /></td>
        <td><input class="oocontent" value="${oo.content}" /></td>
        <td><input class="oorelationUserId" value="${oo.relationUserId}" /></td>
        <td><input class="oocreateId" value="${oo.createId}" /></td>
        <td><button class="alb">修改</button></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>