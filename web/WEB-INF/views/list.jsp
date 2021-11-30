<%--
  Created by IntelliJ IDEA.
  User: 27193
  Date: 2020/12/10
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生列表</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/delete" method="post">

    <table width="200px" border="1px">

        <tr>

            <td>选择</td>

            <td>用户名</td>

        </tr>

        <tr>

            <td><input type="checkbox" name="ids" value="1"> </td>

            <td>李红</td>

        </tr>

        <tr>

            <td><input type="checkbox" name="ids" value="2"></td>

            <td>张强</td>

        </tr>

        <tr>

            <td><input type="checkbox" name="ids" value="3"></td>

            <td>赵力</td>

        </tr>

    </table>

    <input type="submit" value="删除">

</form>
</body>
</html>
