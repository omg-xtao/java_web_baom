<%--
  Created by IntelliJ IDEA.
  User: xtaod
  Date: 2023/12/23
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<c:set var="title" value="录入成绩"/>
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
        <form action="${pageContext.request.contextPath}/jadmin/gradeinput.do" method="post" name="upload"
              ENCTYPE="multipart/form-data">
            <table style="margin:0 auto;">
                <tr>
                    <td style="text-align:center;"><input type="file" name="file1" id="file1" size="20"
                                                          style="border:1px solid #999;"/></td>
                    <td><input class="button" type="submit" name="submit" value="点击上传" id="submit"/>
                <tr/>
            </table>
        </form>
        <div class="operation">学生成绩列表↓：
            <span class="mess">
                <c:if test="${'gradeMess' eq sessionScope.mess.name}">${sessionScope.mess.content}</c:if>
            </span>
        </div>
        <table class="dt" border="0" cellspacing="1">
            <c:forEach items="${pm.data3}" var="supgrade" varStatus="rows">
                <tr>
                    <td>${supgrade.testcardnum}</td>
                    <td>${supgrade.sname}</td>
                    <td>${supgrade.cname}</td>
                    <td>${supgrade.score}</td>
                </tr>
            </c:forEach>
        </table>
        <div class="pagenav">${pm.pageNav}</div>
    </div>
</div>
<%@ include file="../includes/footer.jsp" %>
</body>
</html>
