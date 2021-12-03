<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 27193
  Date: 2020/12/11
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/page" method="get">
    学号：<input type="text" name="code" value="${params.code}">
    姓名：<input type="text" name="username" value="${params.username}">
    年龄：<input type="text" name="age" value="${params.age}">
    性别：
    <select name="gender">
        <option value="" ${params.gender==''?'selected':''}>所有</option>
        <option value="男" ${params.gender=='男'?'selected':''}>男</option>
        <option value="女" ${params.gender=='女'?'selected':''}>女</option>
    </select>
    <input type="submit" value="搜索">
</form>
<form action="${pageContext.request.contextPath}/delete" method="post">
<table>
    <tr>
        <th>&nbsp;</th>
<%--        <th>学号</th>--%>
        <th>姓名</th>
        <th>年龄</th>
        <th>性别</th>
        <th>民族</th>
        <th>生日</th>
<%--        <th>籍贯</th>--%>
<%--        <th>入校日期</th>--%>
<%--        <th>所在院系</th>--%>
<%--        <th>职务</th>--%>
        <th>操作</th>
    </tr>
    <c:forEach items="${pageData.list}" var="student">
        <tr>
            <td><input type="checkbox" name="ids" value="${student.id}"/></td>
            <td>${student.code}</td>
            <td>${student.username}</td>
            <td>${student.age}  </td>
            <td>${student.gender}</td>
            <td>${student.nation}</td>
            <td>${student.birthday}</td>
            <td>${student.native_place}</td>
            <td>${student.enter_time}</td>
            <td>${student.department}</td>
            <td>${student.post}</td>
            <td><a href="${pageContext.request.contextPath}/edit/${student.id }">修改</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td class="td2">
            <span>第${pageData.currPage}/ ${pageData.totalPage}页</span>
            <span>总记录数：${pageData.totalCount } 每页显示: ${pageData.pageSize}</span>
            <span>
              <c:if test="${pageData.currPage != 1}">
                  <a href="${pageContext.request.contextPath }/page?currentPage=1">[首页]</a>
                  <a href="${pageContext.request.contextPath }/page?currentPage=${pageData.currPage-1}">[上一页]</a>
              </c:if>
              <c:if test="${pageData.currPage != pageData.totalPage}">
                  <a href="${pageContext.request.contextPath }/page?currentPage=${pageData.currPage+1}">[下一页]</a>
                  <a href="${pageContext.request.contextPath }/page?currentPage=${pageData.totalPage}">[尾页]</a>
              </c:if>
            </span>
        </td>
    </tr>
</table>
    <input type="submit" value="批量删除">
</form>
</body>
</html>


