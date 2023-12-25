<%--
  Created by IntelliJ IDEA.
  User: xtaod
  Date: 2023/12/25
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<c:set var="webroot" value="${pageContext.request.contextPath}"/>
<c:set var="title" value="登录历史"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>${title}</title>
    <link rel="stylesheet" href="${webroot}/styles/bootstrap.min.css" crossorigin="anonymous">
    <script src="${webroot}/js/bootstrap.bundle.min.js"></script>
    <script src="${webroot}/js/record.js"></script>
    <link rel="stylesheet" href="${webroot}/styles/sidebar.css" crossorigin="anonymous">
    <link rel="stylesheet" href="${webroot}/styles/index.css" crossorigin="anonymous">
</head>
<body>
<main class="d-flex flex-nowrap">
    <%@ include file="../includes/header.jsp" %>

    <main class="form-signin w-100 m-auto" style="max-width: 600px;">
        <img class="mb-4" src="${webroot}/images/logo.jpg" alt="" width="72" height="72">
        <h1 class="h3 mb-3 fw-normal">${title}</h1>

        <table class="table">
            <thead>
            <tr>
                <th scope="col">序号</th>
                <th scope="col">登录名</th>
                <th scope="col">用户组</th>
                <th scope="col">登录时间</th>
                <th scope="col">登录IP</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pm.data}" var="recode" varStatus="row">
                <tr>
                    <td>${pm.fromIndex + row.index + 1}</td>
                    <td>${recode.logname}</td>
                    <td>${recode.usergroup}</td>
                    <td>${recode.logtime}</td>
                    <td>${recode.logip}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        ${pm.pageNav}
    </main>
</main>
</body>
</html>
