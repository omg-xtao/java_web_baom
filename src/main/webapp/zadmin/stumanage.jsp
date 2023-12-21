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
<c:set var="title" value="学生密码清零"/>
<c:set var="webroot" value="${pageContext.request.contextPath}"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>${title}</title>
    <link rel="stylesheet" type="text/css" href="../styles/basic.css"/>
</head>
<body>
<%@ include file="../includes/header.jsp" %>
<div id="content">
    <div id="left">
    </div>
    <div id="right">
        <h1>${title}</h1>
        <div class="ft">
            <span class="mess">按照用户名查询学生用户</span>
            <form method="post" action="${webroot}/zadmin/manage.do?action=findStusLikeUsername">
                <table>
                    <tr>
                        <td class="label">用户名：</td>
                        <td><input type="text" name="username" id="username"/></td>
                        <td class="hint"> *用户名为英文字母、下划线或数字组合，长度为6-20位</td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            <input type="submit" value="查 找" class="button"/>
                            <input type="reset" value="重 置" class="button"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <div class="ft">
            <span class="mess">按照身份证号码查询学生用户</span>
            <form method="post" action="${webroot}/zadmin/manage.do?action=findStusLikeIdcode">
                <table>
                    <tr>
                        <td class="label">身份证号：</td>
                        <td><input type="text" name="idcode" id="idcode"/></td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            <input type="submit" value="提 交" class="button"/>
                            <input type="reset" value="重 置" class="button"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <div class="operation">查询到的用户列表↓：
            <span class="mess">${stuPassResetMess}</span>
        </div>
        <table class="dt" border="0" cellspacing="1">
            <tr>
                <th>序号</th>
                <th>用户名</th>
                <th>注册时间</th>
                <th>注册IP</th>
                <th>密码清零</th>
            </tr>
            <c:forEach items="${stus}" var="stu" varStatus="rows">
                <tr>
                    <td>${rows.count}</td>
                    <td>${stu.username}</td>
                    <td>${stu.regtime}</td>
                    <td>${stu.regip}</td>
                    <td><a href="${webroot}/zadmin/manage.do?action=stuPassReset&username=${stu.username}">清零</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <%@ include file="../includes/footer.jsp" %>
</body>
</html>
