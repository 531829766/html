<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 27193
  Date: 2021/10/21
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/doctorpage" method="get">
    医生姓名：<input type="text" name="doctor_name" value="${doctorparams.doctor_name}">
    医生专业：<input type="text" name="doctor_specialty" value="${doctorparams.doctor_specialty}">
    医生电话：<input type="text" name="doctor_phone" value="${doctorparams.doctor_phone}">
    <input type="submit" value="搜索">
</form>
<form action="${pageContext.request.contextPath}/doctordelete" method="post">
    <table>
        <tr>
            <th>&nbsp;</th>
            <th>医生姓名</th>
            <th>医生密码</th>
            <th>医生电话</th>
            <th>医生专业</th>
            <th>医生身份证号码</th>
        </tr>
        <c:forEach items="${doctorpageData.list}" var="dt">
            <tr>
                <td><input type="checkbox" name="ids" value="${dt.doctor_id}"/></td>
                <td>${dt.doctor_name}</td>
                <td>${dt.doctor_password}</td>
                <td>${dt.doctor_phone}</td>
                <td>${dt.doctor_specialty}</td>
                <td>${dt.doctor_identity}</td>
                <td><a href="${pageContext.request.contextPath}/doctoredit/${dt.doctor_id }">修改</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td class="td2">
                <span>第${doctorpageData.currPage}/ ${doctorpageData.totalPage}页</span>
                <span>总记录数：${doctorpageData.totalCount } 每页显示: ${doctorpageData.pageSize}</span>
                <span>
              <c:if test="${doctorpageData.currPage != 1}">
                  <a href="${pageContext.request.contextPath }/page?currentPage=1">[首页]</a>
                  <a href="${pageContext.request.contextPath }/page?currentPage=${doctorpageData.currPage-1}">[上一页]</a>
              </c:if>
              <c:if test="${doctorpageData.currPage != doctorpageData.totalPage}">
                  <a href="${pageContext.request.contextPath }/page?currentPage=${doctorpageData.currPage+1}">[下一页]</a>
                  <a href="${pageContext.request.contextPath }/page?currentPage=${doctorpageData.totalPage}">[尾页]</a>
              </c:if>
            </span>
            </td>
        </tr>
    </table>
    <input type="submit" value="批量删除">
</form>
<form action="${pageContext.request.contextPath}/doctorto_add" method="post">
    <input type="submit" value="添加" >
</form>
<form action="${pageContext.request.contextPath}/login" method="post">
    <input type="submit" value="退出" >
</form>
</body>
</html>
