<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>userTbDB</title>
    <script src="<c:url value="/jsdb/jquery-1.11.1.js"/> " language="JavaScript"></script>
    <script src="<c:url value="/jsdb/jquery.json-2.4.js"/> " language="JavaScript"></script>
    <script src="<c:url value="/jsdb/userTb.js"/> " language="JavaScript"></script></head>
<body>

<table>
    <tr>
        <td>id</td>
        <td>nameReal</td>
        <td>rrId</td>
        <td>sex</td>
        <td>loginName</td>
        <td>loginPs</td>
        <td>job</td>
        <td>position</td>
        <td>company</td>
        <td>companyAddress</td>
        <td>eMail</td>
        <td>qq</td>
        <td>weixin</td>
        <td>createTime</td>
        <td>updateTime</td>
    </tr>
    <c:forEach var="oo" items="${userTb}">
        <tr>
        <td><input class="ooid" value="${oo.id}" readonly="true" /></td>
        <td><input class="oonameReal" value="${oo.nameReal}" /></td>
        <td><input class="oorrId" value="${oo.rrId}" /></td>
        <td><input class="oosex" value="${oo.sex}" /></td>
        <td><input class="oologinName" value="${oo.loginName}" /></td>
        <td><input class="oologinPs" value="${oo.loginPs}" /></td>
        <td><input class="oojob" value="${oo.job}" /></td>
        <td><input class="ooposition" value="${oo.position}" /></td>
        <td><input class="oocompany" value="${oo.company}" /></td>
        <td><input class="oocompanyAddress" value="${oo.companyAddress}" /></td>
        <td><input class="ooeMail" value="${oo.eMail}" /></td>
        <td><input class="ooqq" value="${oo.qq}" /></td>
        <td><input class="ooweixin" value="${oo.weixin}" /></td>
        <td><input class="oocreateTime" value="${oo.createTime}" /></td>
        <td><input class="ooupdateTime" value="${oo.updateTime}" /></td>
        <td><button class="alb">修改</button></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>