<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 27193
  Date: 2020/12/10
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生列表</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/delete" method="post">
    <table width="200px" border="1px">
        <tr>
            <td>选择</td>

            <td>用户名</td>
        </tr>
<c:forEach items="${list}" var="student">
    <tr>
        <td><input type="checkbox" name="ids" value="${student.id}"> </td>
        <td>${student.username}</td>
    </tr>
</c:forEach>


    </table>

    <input type="submit" value="删除">

</form>
</body>
</html>
