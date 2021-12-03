<%--
  Created by IntelliJ IDEA.
  User: 27193
  Date: 2021/6/14
  Time: 8:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/to_shopping" method="post" >
    <input type="submit" value="购买中心" >
</form>

<form action="${pageContext.request.contextPath}/shop_notice" method="post">
    <input type="submit" value="购买记录" >
</form>

<form action="${pageContext.request.contextPath}/check_notice" method="post">
    <input type="submit" value="查看公告" >
</form>

<form action="${pageContext.request.contextPath}/personal" method="post">
    <input type="submit" value="推荐商品" >
</form>
<table>
    <tr>
        <th>标题:这是个标题</th>
    </tr>
    <tr>
        <td>内容：</td>
    </tr>
</table>
<div >
    这是标题内容
</div>
</body>
</html>
