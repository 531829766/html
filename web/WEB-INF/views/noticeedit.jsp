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
<form action="${pageContext.request.contextPath}/noticeedit" method="post">

    <input type="hidden" name="id" value="${noticedata.id}"><!-- 编辑数据要将记录id作为隐藏字段传过去 -->

    标题：<input type="text" name="title" value="${noticedata.title}"><br>

    内容：<input type="text" name="content" value="${noticedata.content}"><br>

    <input type="submit" value="更新">

</form>
</body>
</html>
