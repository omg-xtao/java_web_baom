<%--
  Created by IntelliJ IDEA.
  User: xtaod
  Date: 2023/12/17
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>修改密码</title>
</head>
<body>
<h1>修改密码</h1>
<span class="mess" id="stuPassMess">${requestScope.stuPassMess}</span><br/>
<form action="${pageContext.request.contextPath}/StuPass" method="post">
    <table>
        <tr>
            <td>原密码</td>
            <td><input type="password" name="oldPassword" id="oldPassword"></td>
        </tr>
        <tr>
            <td>新密码</td>
            <td><input type="password" name="password" id="password"></td>
        </tr>
        <tr>
            <td>确认密码</td>
            <td><input type="password" name="confirmpass" id="confirmpass"></td>
        </tr>
        <tr>
            <td class="label">验证码：</td>
            <td><input style="width: 65px;" type="text" name="code" id="code">

            <td><img src="${pageContext.request.contextPath}/includes/code.jsp" id="imagecode" title="点击图片可刷新验证码" onclick="this.src='${pageContext.request.contextPath}/includes/code.jsp?'+Math.random()"></td>
            <td class="hint">*</td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="修改"></td>
            <td colspan="2"><input id="reset" type="reset" value="重置"></td>
        </tr>
    </table>
</form>
<script src="${pageContext.request.contextPath}/js/pass.js"></script>
</body>
</html>
