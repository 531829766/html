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
    <title>Title</title>
</head>
<body>
用户名或者密码错误
<form action="${pageContext.request.contextPath}/login" method="post">
    <input type="submit" value="返回" >
</form>
</body>
</html>
