<%--
  Created by IntelliJ IDEA.
  User: 27193
  Date: 2021/6/14
  Time: 15:01
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
<th>商品名称</th>
<th>原价</th>
<th>折扣价</th>
<th>库存数量</th>
<th>商品类型</th>
    </tr>

    <tr>
        <td>椰子</td>
        <td>50</td>
        <td>45</td>
        <td>11</td>
        <td>水果</td>
    </tr>
    <tr>
        <td>橙子</td>
        <td>80</td>
        <td>68</td>
        <td>9</td>
        <td>水果</td>
    </tr>
    <tr>
        <td>橘子</td>
        <td>40</td>
        <td>30</td>
        <td>9</td>
        <td>水果</td>
    </tr>
</table>
</body>
</html>
