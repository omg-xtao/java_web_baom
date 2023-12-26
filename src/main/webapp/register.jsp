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
<c:set var="webroot" value="${pageContext.request.contextPath}"/>
<c:set var="title" value="新用户注册"/>
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
    <%@ include file="./includes/header.jsp" %>

    <main class="form-signin w-100 m-auto">
        <div class="toast-container position-fixed bottom-0 end-0 p-3">
            <div id="liveToast" class="toast" role="alert" aria-live="assertive" aria-atomic="true">
                <div class="toast-header">
                    <img src="${webroot}/images/logo.jpg" class="rounded me-2" width="32" height="32">
                    <strong class="me-auto">提示</strong>
                    <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
                </div>
                <div class="toast-body">
                    1、请牢记您注册时填写的用户名和密码，登录本系统时您需要提供正确的用户名和密码！</br>
                    2、忘记用户名或者密码请联系招生单位！
                </div>
            </div>
        </div>
        <form action="${webroot}/register.do" method="post">
            <img class="mb-4" src="${webroot}/images/logo.jpg" alt="" width="72" height="72">
            <h1 class="h3 mb-3 fw-normal">注册账号</h1>

            <c:if test="${not empty requestScope.stuAddMess}">
                <div class="alert alert-warning" role="alert">
                        ${requestScope.stuAddMess}
                </div>
            </c:if>

            <div class="form-floating">
                <input type="text" class="form-control" name="username" id="username" value="${username}" required>
                <label for="username">用户名</label>
            </div>
            <div class="form-floating">
                <input type="password" class="form-control" name="password" id="password" value="${password}" required>
                <label for="password">密码</label>
            </div>
            <div class="form-floating">
                <input type="password" class="form-control" name="confirmpass" id="confirmpass" value="${confirmpass}"
                       required>
                <label for="confirmpass">确认密码</label>
            </div>
            <div class="input-group mb-3">
                <input type="text" class="form-control" placeholder="验证码" name="code" id="code" required>
                <span class="input-group-text">
                                <img src="${pageContext.request.contextPath}/includes/code.jsp" id="imagecode"
                                     title="点击图片可刷新验证码"
                                     onclick="this.src='${pageContext.request.contextPath}/includes/code.jsp?'+Math.random()">
                </span>
            </div>

            <input class="btn btn-primary w-100 py-2" type="submit" id="submit">
            <br/><br/>
        </form>
        <a href="${webroot}/index.jsp">
            <button class="btn btn-primary w-100 py-2">去登陆</button>
        </a>
    </main>
</main>
<script>
    const toastLiveExample = document.getElementById('liveToast')

    const toastBootstrap = bootstrap.Toast.getOrCreateInstance(toastLiveExample)
    toastBootstrap.show()
</script>
</body>
</html>
