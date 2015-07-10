<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>projectTbDB</title>
    <script src="<c:url value="/jsdb/jquery-1.11.1.js"/> " language="JavaScript"></script>
    <script src="<c:url value="/jsdb/jquery.json-2.4.js"/> " language="JavaScript"></script>
    <script src="<c:url value="/jsdb/projectTb.js"/> " language="JavaScript"></script></head>
<body>

<table>
    <tr>
        <td>id</td>
        <td>title</td>
        <td>acceptCost</td>
        <td>mainBody</td>
        <td>ammount</td>
        <td>timeLimit</td>
        <td>measure</td>
        <td>define</td>
        <td>summary</td>
        <td>createTime</td>
        <td>updateTime</td>
    </tr>
    <c:forEach var="oo" items="${projectTb}">
        <tr>
        <td><input class="ooid" value="${oo.id}" readonly="true" /></td>
        <td><input class="ootitle" value="${oo.title}" /></td>
        <td><input class="ooacceptCost" value="${oo.acceptCost}" /></td>
        <td><input class="oomainBody" value="${oo.mainBody}" /></td>
        <td><input class="ooammount" value="${oo.ammount}" /></td>
        <td><input class="ootimeLimit" value="${oo.timeLimit}" /></td>
        <td><input class="oomeasure" value="${oo.measure}" /></td>
        <td><input class="oodefine" value="${oo.define}" /></td>
        <td><input class="oosummary" value="${oo.summary}" /></td>
        <td><input class="oocreateTime" value="${oo.createTime}" /></td>
        <td><input class="ooupdateTime" value="${oo.updateTime}" /></td>
        <td><button class="alb">修改</button></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>