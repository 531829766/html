<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 27193
  Date: 2021/1/2
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<html>
<head>
    <title>首页</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/classpage" method="get">
    班级名称：<input type="text" name="class_name" value="${classparams.class_name}">
    年级：<input type="text" name="grade" value="${classparams.grade}">
    班级：<input type="text" name="frequency" value="${classparams.frequency}">
    <input type="submit" value="搜索">
</form>
<form action="${pageContext.request.contextPath}/classdelete" method="post">
    <table>
        <tr>
            <th>&nbsp;</th>
            <th>班级名称</th>
            <th>年级</th>
            <th>班级</th>
            <th>班级位置</th>
            <th>班级人数</th>
            <th>班主任</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${classpageData.list}" var="cs">
            <tr>
                <td><input type="checkbox" name="ids" value="${cs.id}"/></td>
                <td>${cs.class_name}</td>
                <td>${cs.grade}</td>
                <td>${cs.frequency}  </td>
                <td>${cs.class_place}</td>
                <td>${cs.class_size}</td>
                <td>${cs.headmaster}</td>
                <td><a href="${pageContext.request.contextPath}/classedit/${cs.id }">修改</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td class="td2">
                <span>第${classpageData.currPage}/ ${classpageData.totalPage}页</span>
                <span>总记录数：${classpageData.totalCount } 每页显示: ${classpageData.pageSize}</span>
                <span>
              <c:if test="${classpageData.currPage != 1}">
                  <a href="${pageContext.request.contextPath }/page?currentPage=1">[首页]</a>
                  <a href="${pageContext.request.contextPath }/page?currentPage=${classpageData.currPage-1}">[上一页]</a>
              </c:if>
              <c:if test="${classpageData.currPage != classpageData.totalPage}">
                  <a href="${pageContext.request.contextPath }/page?currentPage=${classpageData.currPage+1}">[下一页]</a>
                  <a href="${pageContext.request.contextPath }/page?currentPage=${classpageData.totalPage}">[尾页]</a>
              </c:if>
            </span>
            </td>
        </tr>
    </table>
    <input type="submit" value="批量删除">
</form>
</body>
</html>
