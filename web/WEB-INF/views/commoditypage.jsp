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
<form action="${pageContext.request.contextPath}/consumerpage" method="post" >
    <input type="submit" value="用户管理" >
</form>

<form action="${pageContext.request.contextPath}/commoditypage" method="post">
    <input type="submit" value="商品管理" >
</form>

<form action="${pageContext.request.contextPath}/noticepage" method="post">
    <input type="submit" value="公告管理" >
</form>

<form action="${pageContext.request.contextPath}/commoditypage" method="get">
    商品名称：<input type="text" name="commodity_name" value="${commodityparams.commodity_name}">
    商品价格：<input type="text" name="original" value="${commodityparams.original}">
    商品类型：<input type="text" name="commodity_type" value="${commodityparams.commodity_type}">
    <input type="submit" value="搜索">
</form>
<form action="${pageContext.request.contextPath}/commoditydelete" method="post">
    <table>
        <tr>
            <th>&nbsp;</th>
            <th>图</th>
            <th>商品名称</th>
            <th>原价</th>
            <th>折扣价</th>
            <th>库存数量</th>
            <th>商品类型</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${commoditypageData.list}" var="ct">
            <tr>
                <td><input type="checkbox" name="ids" value="${ct.id}"/></td>
                <td>${ct.picture}</td>
                <td>${ct.commodity_name}</td>
                <td>${ct.original}</td>
                <td>${ct.discount}  </td>
                <td>${ct.stock}</td>
                <td>${ct.commodity_type}</td>
                <td><a href="${pageContext.request.contextPath}/commodityedit/${ct.id }">修改</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td class="td2">
                <span>第${commoditypageData.currPage}/ ${commoditypageData.totalPage}页</span>
                <span>总记录数：${commoditypageData.totalCount } 每页显示: ${commoditypageData.pageSize}</span>
                <span>
              <c:if test="${commoditypageData.currPage != 1}">
                  <a href="${pageContext.request.contextPath }/page?currentPage=1">[首页]</a>
                  <a href="${pageContext.request.contextPath }/page?currentPage=${commoditypageData.currPage-1}">[上一页]</a>
              </c:if>
              <c:if test="${commoditypageData.currPage != commoditypageData.totalPage}">
                  <a href="${pageContext.request.contextPath }/page?currentPage=${commoditypageData.currPage+1}">[下一页]</a>
                  <a href="${pageContext.request.contextPath }/page?currentPage=${commoditypageData.totalPage}">[尾页]</a>
              </c:if>
            </span>
            </td>
        </tr>
    </table>
    <input type="submit" value="批量删除">
</form>
<form action="${pageContext.request.contextPath}/commodityto_add" method="post">
    <input type="submit" value="添加" >
</form>
<form action="${pageContext.request.contextPath}/login" method="post">
    <input type="submit" value="退出" >
</form>
</body>
</html>
