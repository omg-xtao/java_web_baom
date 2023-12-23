<%--
  Created by IntelliJ IDEA.
  User: xtaod
  Date: 2023/12/23
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<c:set var="title" value="准考证号生成"/>
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
    <div id="right">
        <h1>${title}</h1>
        <div class="operation">准考证号分配列表↓：
            <span class="mess">
                <c:if test="${'assignMess' eq sessionScope.mess.name}">${sessionScope.mess.content}</c:if>
            </span>
        </div>
        <table class="dt" border="0" cellspacing="1">
            <tr>
                <th>身份证号</th>
                <th>考生姓名</th>
                <th>报考专业</th>
                <th>准考证号</th>
            </tr>
            <c:forEach items="${pm.data2}" var="reginfo" varStatus="rows">
                <tr>
                    <td>${reginfo.idcode}</td>
                    <td>${reginfo.sname}</td>
                    <td>${reginfo.mname}</td>
                    <td>${reginfo.testcardnum}</td>
                </tr>
            </c:forEach>
        </table>
        <div class="pagenav">${pm.pageNav}</div>
        <form action="${pageContext.request.contextPath}/jadmin/cardnum.do?action=assign" method="post">
            <table style="margin:0 auto;">
                <tr>
                    <td><input class="button" type="submit" name="submit" value="确认分配" id="submit"/>
                <tr/>
            </table>
        </form>
    </div>
    <div class="clearf"></div>
</div>
<%@ include file="../includes/footer.jsp" %>
</body>
</html>
