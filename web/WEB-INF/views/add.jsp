
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 27193
  Date: 2020/12/11
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>

    <title>学生列表</title>

</head>

<body>

<form action="${pageContext.request.contextPath}/add" method="post">
    <!--

        private int id;//关键字

        private String code;//学号

        private String username;//姓名

        private int age;//年龄

        private String gender;//性别

        -->
    学号：<input type="text" name="code"><br>

    姓名：<input type="text" name="username"><br>

    年龄：<input type="text" name="age"><br>

    性别：

    <select name="gender">

        <option>男</option>

        <option>女</option>

    </select><br>

    民族：<input type="text" name="nation" value="${data.nation}"><br>

    生日：<input type="text" name="birthday" value="${data.birthday}"><br>

    籍贯：<input type="text" name="native_place" value="${data.native_place}"><br>

    入校日期：<input type="text" name="enter_time" value="${data.enter_time}"><br>

    所在院系：<input type="text" name="department" value="${data.department}"><br>

    职务：<input type="text" name="post" value="${data.post}"><br>

    <input type="submit" value="添加">

</form>

</body>

</html>