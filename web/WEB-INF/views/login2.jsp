<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--
  Created by IntelliJ IDEA.
  User: 27193
  Date: 2020/12/11
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

<%--  <form action="${pageContext.request.contextPath}/login" method="post">--%>
<form action="${pageContext.request.contextPath }/user_login" method="POST">

    管理员名：<input type="text" name="a_username" value="${admindata.a_username}"/><br />

    密&nbsp;&nbsp;&nbsp;码：<input type="password" name="a_password" value="${admindata.a_password}" /><br />

    <input type="submit" value="登录" />
</form>
<form action="${pageContext.request.contextPath }/login" method="post">
    <input type="submit" value="用户登录">
</form>
</body>
</html>
