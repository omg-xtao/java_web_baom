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
<c:set var="webroot" value="${pageContext.request.contextPath}"/>
<c:set var="title" value="成绩与录取查询"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>${title}</title>
    <link rel="stylesheet" href="${webroot}/styles/bootstrap.min.css" crossorigin="anonymous">
    <script src="${webroot}/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="${webroot}/styles/sidebar.css" crossorigin="anonymous">
    <link rel="stylesheet" href="${webroot}/styles/index.css" crossorigin="anonymous">
</head>
<body>
<main class="d-flex flex-nowrap">
    <%@ include file="../includes/header.jsp" %>

    <main class="form-signin w-100 m-auto" style="max-width: 600px;">
        <img class="mb-4" src="${webroot}/images/logo.jpg" alt="" width="72" height="72">
        <h1 class="h3 mb-3 fw-normal">${title}</h1>

        <c:choose>
            <c:when test="${isAdmit}">
                <div class="alert alert-success" role="alert">
                    恭喜你，你已被 ${mname} 专业录取
                </div>
            </c:when>
            <c:otherwise>
                <div class="alert alert-dark" role="alert">
                    很遗憾，你没有被 ${mname} 专业录取
                </div>
            </c:otherwise>
        </c:choose>

        <h1 class="h3 mb-3 fw-normal">详细成绩如下</h1>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">准考证号</th>
                <th scope="col">考生姓名</th>
                <th scope="col">考试科目</th>
                <th scope="col">成绩</th>
                <th scope="col">备注</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${grades}" var="grade">
                <tr>
                    <td>${grade.testcardnum}</td>
                    <td>${grade.sname}</td>
                    <td>${grade.cname}</td>
                    <td>${grade.score}</td>
                    <td>${grade.note}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </main>
</main>
</body>
</html>
