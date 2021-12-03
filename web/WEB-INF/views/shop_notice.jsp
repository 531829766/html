<%--
  Created by IntelliJ IDEA.
  User: 27193
  Date: 2021/6/14
  Time: 8:42
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
        <th>订单编号</th>
        <th>订单内容</th>
        <th>订单金额</th>
        <th>购买时间</th>
        <th>支付情况</th>
    </tr>
        <tr>
            <td>001</td>
            <td>椰子</td>
            <td>45</td>
            <td>2021.6.14</td>
            <td>已支付</td>
        </tr>

    <tr>
        <td>002</td>
        <td>茄子</td>
        <td>6</td>
        <td>2021.6.14</td>
        <td>已支付</td>
    </tr>
    <tr>
        <td>003</td>
        <td>橘子</td>
        <td>30</td>
        <td>2021.6.15</td>
        <td>已支付</td>
    </tr>
    <tr>
    <td>004</td>
    <td>椰子</td>
    <td>45</td>
    <td>2021.6.16</td>
    <td>已支付</td>
</tr>

</table>

</body>
</html>
