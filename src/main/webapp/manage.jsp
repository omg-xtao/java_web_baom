<%--
  Created by IntelliJ IDEA.
  User: xtaod
  Date: 2023/12/9
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<c:set var="title" value="管理员登录"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>${title}</title>
    <link rel="stylesheet" type="text/css" href="styles/basic.css"/>
</head>
<body>
<%@ include file="./includes/header.jsp" %>
<div id="content">
    <div id="left">
        <h1>提示</h1>
        <div class="ft" style="border: none;">
            <table>
                <tr>
                    <td>1、请牢记您注册时填写的用户名和密码，登录本系统时您需要提供正确的用户名和密码！</td>
                </tr>
                <tr>
                    <td>2、忘记用户名或者密码请联系招生单位！</td>
                </tr>
            </table>
        </div>
    </div>
    <div id="right">
        <h1>${title}</h1>
        <div class="operation">验证登录信息↓：
            <span class="mess" id="stuLoginMess">${requestScope.adminLoginMess}</span>
        </div>
        <div class="ft">
            <form method="post" action="${pageContext.request.contextPath}/adminLogin.do">
                <table>
                    <tr>
                        <td class="label">用户名：</td>
                        <td colspan="2"><input type="text" name="username" id="username">

                        <td class="hint">*</td>
                    </tr>
                    <tr>
                        <td class="label">密码：</td>
                        <td colspan="2"><input type="password" name="password" id="password">

                        <td class="hint">*</td>
                    </tr>
                    <tr>
                        <td class="label">验证码：</td>
                        <td><input style="width: 65px;" type="text" name="code" id="code">

                        <td><img src="${pageContext.request.contextPath}/includes/code.jsp" id="imagecode"
                                 title="点击图片可刷新验证码"
                                 onclick="this.src='${pageContext.request.contextPath}/includes/code.jsp?'+Math.random()">
                        </td>
                        <td class="hint">*</td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            <input type="submit" value="登录系统" class="button" id="submit"/>
                            <input type="reset" value="重 置" class="button" id="reset"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
    <%@ include file="./includes/footer.jsp" %>
</body>
</html>
