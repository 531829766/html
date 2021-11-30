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
<form action="${pageContext.request.contextPath }/login" method="POST">

  用户名：<input type="text" name="username" value="${consumerdata.username}"/><br />

  密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" value="${consumerdata.password}" /><br />

  <input type="submit" value="登录" />
</form>
  <form action="${pageContext.request.contextPath }/login2" method="post">
    <input type="submit" value="管理员登录">
  </form>
  </body>
</html>
