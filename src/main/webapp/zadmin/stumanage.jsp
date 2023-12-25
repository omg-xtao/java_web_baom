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
<c:set var="title" value="学生密码清零"/>
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

    <main class="form-signin w-100 m-auto" style="max-width: 800px;">
        <img class="mb-4" src="${webroot}/images/logo.jpg" alt="" width="72" height="72">
        <h1 class="h3 mb-3 fw-normal">${title}</h1>
        <c:if test="${not empty stuPassResetMess}">
            <div class="alert alert-warning" role="alert">
                    ${stuPassResetMess}
            </div>
        </c:if>

        <form action="${webroot}/zadmin/manage.do?action=find" method="post">
            <div class="input-group mb-3">
                <span class="input-group-text">用户名</span>
                <input type="text" class="form-control" name="username" id="username" value="${username}">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">身份证号</span>
                <input type="text" class="form-control" name="idcode" id="idcode" value="${idcode}">
            </div>
            <input class="btn btn-primary w-100 py-2" type="submit" id="submit" value="查询">
            <br/><br/>
        </form>

        <c:if test="${not empty stus}">
            <h5>查询到的用户列表</h5>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">序号</th>
                    <th scope="col">用户名</th>
                    <th scope="col">注册时间</th>
                    <th scope="col">注册IP</th>
                    <th scope="col">密码清零</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${stus}" var="stu" varStatus="rows">
                    <tr>
                        <td>${rows.count}</td>
                        <td>${stu.username}</td>
                        <td>${stu.regtime}</td>
                        <td>${stu.regip}</td>
                        <td><a href="${webroot}/zadmin/manage.do?action=stuPassReset&username=${stu.username}">清零</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
    </main>
</main>
</body>
</html>
