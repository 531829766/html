<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 27193
  Date: 2021/6/9
  Time: 9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/consumeradd" method="post">

    用户名：<input type="text" name="username" value="${consumerdata.username}"><br>

    密码：<input type="text" name="password" value="${consumerdata.password}"><br>

    余额：<input type="text" name="balance" value="${consumerdata.balance}"><br>


    <input type="submit" value="添加">

</form>
</body>
</html>
