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
<form action="${pageContext.request.contextPath}/classadd" method="post">

    班级名称：<input type="text" name="class_name" value="${classdata.class_name}"><br>

    年级：<input type="text" name="grade" value="${classdata.grade}"><br>

    几班：<input type="text" name="frequency" value="${classdata.frequency}"><br>

    教室位置：<input type="text" name="class_place" value="${classdata.class_place}"><br>

    班级人数：<input type="text" name="class_size" value="${classdata.class_size}"><br>

    班主任：<input type="text" name="headmaster" value="${classdata.headmaster}"><br>


    <input type="submit" value="添加">

</form>
</body>
</html>
