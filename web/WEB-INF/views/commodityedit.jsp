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
<form action="${pageContext.request.contextPath}/commodityedit" method="post">

    <input type="hidden" name="id" value="${commoditydata.id}"><!-- 编辑数据要将记录id作为隐藏字段传过去 -->

    图：<input type="text" name="picture" value="${commoditydata.picture}"><br>

    商品名称：<input type="text" name="commodity_name" value="${commoditydata.commodity_name}"><br>

    原价：<input type="text" name="original" value="${commoditydata.original}"><br>

    折扣价：<input type="text" name="discount" value="${commoditydata.discount}"><br>

    库存数量：<input type="text" name="stock" value="${commoditydata.stock}"><br>

    商品类型：<input type="text" name="commodity_type" value="${commoditydata.commodity_type}"><br>


    <input type="submit" value="更新">

</form>
</body>
</html>
