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
<c:set var="title" value="管理员维护"/>
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
        <div class="operation">已添加的管理员列表↓：
            <span class="mess">${manageMess}</span>
        </div>
        <table class="dt" border="0" cellspacing="1">
            <tr>
                <th>序号</th>
                <th>管理员用户名</th>
                <th>管理员用户组</th>
                <th>管理员密码清零</th>
                <th>删除管理员</th>
            </tr>
            <c:forEach items="${adminusers}" var="adminuser" varStatus="rows">
                <tr>
                    <td>${rows.count}</td>
                    <td>${adminuser.adminname}</td>
                    <td>${adminuser.admingroup}</td>
                    <td><a href="${webroot}/sadmin/manage.do?action=passReset&adminname=${adminuser.adminname}">密码清零</a></td>
                    <td><a href="${webroot}/sadmin/manage.do?action=deleteByAdminname&adminname=${adminuser.adminname}">删除</a></td>
                </tr>
            </c:forEach>
        </table>
        <div class="ft">
            <span class="mess">${addMess}</span>
            <form method="post" action="${webroot}/sadmin/manage.do?action=add">
                <table>
                    <tr>
                        <td class="label">用户名：</td>
                        <td><input type="text" name="adminname" id="adminname" value="${requestScope.newadmin.adminname}"/></td>
                        <td class="hint"> *用户名为英文字母、下划线或数字组合，长度为6-20位</td>
                    </tr>
                    <tr>
                        <td class="label">用户组：</td>
                        <td>
                            <select name="admingroup">
                                <option value="招生管理员" selected="selected">招生管理员</option>
                                <option value="教务管理员">教务管理员</option>
                            </select>
                        </td>
                        <td class="hint">* 用户组为'招生管理员' 或 '教务管理员'</td>
                    </tr>
                    <tr>
                        <td class="label">初始密码：</td>
                        <td><input type="text" name="adminpass" id="adminpass" value=""/></td>
                        <td class="hint"> *初始密码为英文字母、下划线或数字组合，长度为6-20位</td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            <input type="submit" value="提 交" class="button" id="submit" />
                            <input type="reset" value="重 置" class="button" id="reset" />
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
    <%@ include file="../includes/footer.jsp" %>
</body>
</html>
