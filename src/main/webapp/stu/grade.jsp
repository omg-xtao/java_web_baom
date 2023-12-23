<%--
  Created by IntelliJ IDEA.
  User: xtaod
  Date: 2023/12/23
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<c:set var="title" value="成绩与录取查询"/>
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
    </div>
    <c:choose>
        <c:when test="${isAdmit}">
            <h2>恭喜你，你已被 ${mname} 专业录取</h2>
        </c:when>
        <c:otherwise>
            <h2>很遗憾，你没有被 ${mname} 专业录取</h2>
        </c:otherwise>
    </c:choose>
    <div id="right">
        <h1>详细成绩如下：</h1>
    </div>
    <table>
        <tr>
            <th>准考证号</th>
            <th>考生姓名</th>
            <th>考试科目</th>
            <th>成绩</th>
            <th>备注</th>
        </tr>
        <c:forEach items="${grades}" var="grade">
            <tr>
                <td>${grade.testcardnum}</td>
                <td>${grade.sname}</td>
                <td>${grade.cname}</td>
                <td>${grade.score}</td>
                <td>${grade.note}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
