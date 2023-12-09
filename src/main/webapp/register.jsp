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
<c:set var="title" value="新用户注册"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>${title}</title>
    <link rel="stylesheet" type="text/css" href="styles/basic.css"/>
    <script type="text/javascript" src="js/register.js"></script>
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
        <div class="operation">填写注册信息↓：
            <span class="mess" id="stuAddMess">${requestScope.stuAddMess}</span>
        </div>
        <div class="ft">
            <form method="post" action="register.do">
                <table>
                    <tr>
                        <td class="label">用户名：</td>
                        <td colspan="2"><input type="text" name="username" id="username"
                                               value="${ requestScope.username }"/></td>
                        <td class="hint"> *用户名为英文字母、下划线或数字组合，长度为6-20位</td>
                    </tr>
                    <tr>
                        <td class="label">密码：</td>
                        <td colspan="2"><input type="password" name="password" id="password"
                                               value="${ requestScope.password }"/></td>
                        <td class="hint"> *密码为英文字母、下划线或数字组合，长度为6-20位</td>
                    </tr>
                    <tr>
                        <td class="label">确认密码：</td>
                        <td colspan="2"><input type="password" name="confirmpass" id="confirmpass"
                                               value="${ requestScope.confirmpass }"/></td>
                        <td class="hint"> * 两次输入的密码要一致</td>
                    </tr>
                    <tr>
                        <td class="label">验证码：</td>
                        <td><input style="width: 65px;" type="text" name="code" id="code"
                                   value="${ requestScope.code }"/></td>
                        <td><img src="includes/code.jsp" id="imagecode" title="点击图片可更换"
                                 onclick="this.src+='?tm='+ Math.random();"/></td>
                        <td class="hint"> * 看不清？点击验证码图片可更换</td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            <input type="submit" value="注 册" class="button" id="submit"/>
                            <input type="reset" value="重 置" class="button" id="reset"/>
                        </td>
                        <td>* 已有账号，<a href="/index.jsp">点此登录</a></td>
                    </tr>
                </table>
            </form>
        </div>
        <div class="clearf"></div>
    </div>
    <%@ include file="./includes/footer.jsp" %>
</body>
</html>
