<%--
  Created by IntelliJ IDEA.
  User: 27193
  Date: 2021/10/21
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/doctoredit" method="post">

    <input type="hidden" name="doctor_id" value="${doctordata.doctor_id}"><!-- 编辑数据要将记录id作为隐藏字段传过去 -->

    医生姓名：<input type="text" name="doctor_name" value="${doctordata.doctor_name}"><br>

    密码：<input type="text" name="doctor_password" value="${doctordata.doctor_password}"><br>

    电话号码：<input type="text" name="doctor_phone" value="${doctordata.doctor_phone}"><br>

    身份证号码：<input type="text" name="doctor_identity" value="${doctordata.doctor_identity}"><br>

    专业：<input type="text" name="doctor_specialty" value="${doctordata.doctor_specialty}"><br>

    <input type="submit" value="更新">

</form>
</body>
</html>
