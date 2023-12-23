<%--
  Created by IntelliJ IDEA.
  User: xtaod
  Date: 2023/12/23
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<c:set var="title" value="查看成绩信息"/>
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
    <div id="right">
        <h1>${title}</h1>
        <div class="operation">通过准考证号查询学生成绩↓：
            <span class="mess">
                <c:if test="${'gradeMess' eq sessionScope.mess.name}">${sessionScope.mess.content}</c:if>
            </span>
        </div>
        <div class="search">
            <form action="${webroot}/admin/grade.do" method="post">
                <input type="text" name="testcardnum" id="testcardnum" placeholder="请输入准考证号"/>
                <input type="submit" value="查询"/>
            </form>
        </div>
        <div class="operation">通过考生姓名查询学生成绩↓：</div>
        <div class="search">
            <form action="${webroot}/admin/grade.do" method="post">
                <input type="text" name="sname" id="sname" placeholder="请输入考生姓名"/>
                <input type="submit" value="查询"/>
            </form>
        </div>
        <div class="operation">考生成绩如下↓：</div>
        <table class="dt" border="0" cellspacing="1">
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
    <div class="clearf"></div>
</div>
<%@ include file="../includes/footer.jsp" %>
</body>
</html>
