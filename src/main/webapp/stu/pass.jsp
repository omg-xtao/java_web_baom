<%--
  Created by IntelliJ IDEA.
  User: xtaod
  Date: 2023/12/17
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<c:set var="webroot" value="${pageContext.request.contextPath}"/>
<c:set var="title" value="修改密码"/>
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

    <main class="form-signin w-100 m-auto">
        <form action="${webroot}/StuPass" method="post">
            <img class="mb-4" src="${webroot}/images/logo.jpg" alt="" width="72" height="72">
            <h1 class="h3 mb-3 fw-normal">修改密码</h1>

            <c:if test="${not empty requestScope.stuPassMess}">
                <div class="alert alert-warning" role="alert">
                        ${requestScope.stuPassMess}
                </div>
            </c:if>

            <div class="form-floating">
                <input type="password" class="form-control" name="oldPassword" id="oldPassword" value="${oldPassword}">
                <label for="oldPassword">旧密码</label>
            </div>
            <div class="form-floating">
                <input type="password" class="form-control" name="password" id="password" value="${password}">
                <label for="password">密码</label>
            </div>
            <div class="form-floating">
                <input type="password" class="form-control" name="confirmpass" id="confirmpass" value="${confirmpass}">
                <label for="confirmpass">确认密码</label>
            </div>
            <div class="form-floating">
                <input type="text" class="form-control" name="code" id="code">
                <label for="code">验证码</label>
            </div>
            <br/>
            <img src="${pageContext.request.contextPath}/includes/code.jsp" id="imagecode"
                 title="点击图片可刷新验证码"
                 onclick="this.src='${pageContext.request.contextPath}/includes/code.jsp?'+Math.random()">
            <br/><br/>

            <input class="btn btn-primary w-100 py-2" type="submit" id="submit">
            <br/><br/>
        </form>
    </main>
</main>
</body>
</html>
