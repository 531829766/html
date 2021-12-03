<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 27193
  Date: 2021/6/9
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/delete" method="post">
    <table width="200px" border="1px">
        <tr>
            <td>选择</td>

            <td>用户名</td>
        </tr>
        <c:forEach items="${noticelist}" var="ct">
            <tr>
                <td><input type="checkbox" name="ids" value="${ct.id}"> </td>
                <td>${ct.title}</td>
            </tr>
        </c:forEach>
    </table>

    <input type="submit" value="删除">

</form>
</body>
</html>
