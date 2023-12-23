<%--
  Created by IntelliJ IDEA.
  User: xtaod
  Date: 2023/12/23
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<c:set var="title" value="考生现场确认"/>
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
        <div class="operation">考生现场确认↓：
            <span class="mess">
                <c:if test="${'confirmMess' eq sessionScope.mess.name}">${sessionScope.mess.content}</c:if>
            </span>
        </div>
        <form action="${webroot}/zadmin/confirm.do" method="post">
            <table>
                <tr>
                    <td class="label">输入身份证号：</td>
                    <td><input type="text" name="idCode" id="idCode" value="${param.idcard}"/></td>
                    <td><input class="button" type="submit" value="点击查询"/></td>
                </tr>
            </table>
        </form>
        <table class="dt" border="0" cellspacing="1">
            <tr>
                <th>考生姓名</th>
                <th>身份证号</th>
                <th>性别</th>
                <th>是否应届生</th>
                <th>报考专业</th>
                <th>确认情况</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${reginfos}" var="reginfo">
                <form action="${webroot}/zadmin/confirm.do?confirm=1" method="post">
                    <tr>
                        <td>${reginfo.sname}</td>
                        <td>${reginfo.idcode}</td>
                        <td>${reginfo.ssex}</td>
                        <td>${reginfo.isnew}</td>
                        <td>${reginfo.mname}</td>
                        <td>${reginfo.isconfirm}</td>
                        <td>
                            <input type="hidden" name="username" id="username" value="${reginfo.username}"/>
                            <input type="hidden" name="idcode" id="idCode" value="${reginfo.idcode}"/>
                            <input type="submit" value="确认"/>
                        </td>
                    </tr>
                </form>
            </c:forEach>
        </table>
    </div>
    <%@ include file="../includes/footer.jsp" %>
</body>
</html>
