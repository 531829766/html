<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--
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

<form action="${pageContext.request.contextPath}/shopping" method="get">

    <input type="submit" value="显示全部商品">
</form>
<form action="${pageContext.request.contextPath}/shop_notice" method="post">
    <table>
        <tr>
            <th>&nbsp;</th>
            <th>图</th>
            <th>商品名称</th>
            <th>原价</th>
            <th>折扣价</th>
            <th>库存数量</th>
            <th>商品类型</th>
        </tr>
        <c:forEach items="${shoppingData.list}" var="ct">
            <tr>
                <td><input type="checkbox" name="ids" value="${ct.id}"/></td>
                <td>${ct.picture}</td>
                <td>${ct.commodity_name}</td>
                <td>${ct.original}</td>
                <td>${ct.discount}  </td>
                <td>${ct.stock}</td>
                <td>${ct.commodity_type}</td>
            </tr>
        </c:forEach>
        <tr>
            <td class="td2">
                <span>第${shoppingData.currPage}/ ${shoppingData.totalPage}页</span>
                <span>总记录数：${shoppingData.totalCount } 每页显示: ${shoppingData.pageSize}</span>
                <span>
              <c:if test="${shoppingData.currPage != 1}">
                  <a href="${pageContext.request.contextPath }/page?currentPage=1">[首页]</a>
                  <a href="${pageContext.request.contextPath }/page?currentPage=${shoppingData.currPage-1}">[上一页]</a>
              </c:if>
              <c:if test="${shoppingData.currPage != shoppingData.totalPage}">
                  <a href="${pageContext.request.contextPath }/page?currentPage=${shoppingData.currPage+1}">[下一页]</a>
                  <a href="${pageContext.request.contextPath }/page?currentPage=${shoppingData.totalPage}">[尾页]</a>
              </c:if>
            </span>
            </td>
        </tr>
    </table>
    <input type="submit" value="购买">
</form>
<form action="${pageContext.request.contextPath}/to_login" method="post">
    <input type="submit" value="退出" >
</form>
</body>
</html>
