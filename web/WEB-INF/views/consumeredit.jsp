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
<form action="${pageContext.request.contextPath}/consumeredit" method="post">

    <input type="hidden" name="id" value="${consumerdata.id}"><!-- 编辑数据要将记录id作为隐藏字段传过去 -->
    用户名：<input type="text" name="username" value="${consumerdata.username}"><br>

    密码：<input type="text" name="password" value="${consumerdata.password}"><br>

    余额：<input type="text" name="balance" value="${consumerdata.balance}"><br>


    <input type="submit" value="更新">

</form>
</body>
</html>
