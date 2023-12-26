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
<c:set var="title" value="管理员维护"/>
<c:set var="webroot" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>${title}</title>
    <link rel="stylesheet" href="${webroot}/styles/bootstrap.min.css" crossorigin="anonymous">
    <script src="${webroot}/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="${webroot}/styles/sidebar.css" crossorigin="anonymous">
    <link rel="stylesheet" href="${webroot}/styles/index.css" crossorigin="anonymous">
    <link rel="stylesheet" href="${webroot}/styles/entry.css" crossorigin="anonymous">
</head>
<body>
<main class="d-flex flex-nowrap">
    <%@ include file="../includes/header.jsp" %>

    <main class="form-signin w-100 m-auto scrollspy" style="min-width: 800px">
        <img class="mb-4" src="${webroot}/images/logo.jpg" alt="" width="72" height="72">

        <h1 class="h3 mb-3 fw-normal">已添加的管理员列表</h1>
        <c:if test="${not empty requestScope.manageMess}">
            <div class="alert alert-warning" role="alert">
                    ${requestScope.manageMess}
            </div>
        </c:if>

        <table class="table">
            <thead>
            <tr>
                <th scope="col">序号</th>
                <th scope="col">管理员用户名</th>
                <th scope="col">管理员用户组</th>
                <th scope="col">管理员密码清零</th>
                <th scope="col">删除管理员</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${adminusers}" var="adminuser" varStatus="rows">
                <tr>
                    <td>${rows.count}</td>
                    <td>${adminuser.adminname}</td>
                    <td>${adminuser.admingroup}</td>
                    <td>
                        <a href="${webroot}/sadmin/manage.do?action=passReset&adminname=${adminuser.adminname}">密码清零</a>
                    </td>
                    <td><a href="${webroot}/sadmin/manage.do?action=deleteByAdminname&adminname=${adminuser.adminname}">删除</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <h1 class="h3 mb-3 fw-normal">添加管理员</h1>
        <c:if test="${not empty requestScope.addMess}">
            <div class="alert alert-warning" role="alert">
                    ${requestScope.addMess}
            </div>
        </c:if>

        <form action="${webroot}/sadmin/manage.do?action=add" method="post">
            <div class="input-group mb-3">
                <span class="input-group-text">用户名</span>
                <input type="text" class="form-control" name="adminname" id="adminname"
                       value="${requestScope.newadmin.adminname}" required>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">用户组</span>
                <select class="form-select" name="admingroup" id="admingroup" required>
                    <option value="招生管理员" selected="selected">招生管理员</option>
                    <option value="教务管理员">教务管理员</option>
                </select>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">初始密码</span>
                <input type="password" class="form-control" name="adminpass" id="adminpass" required>
            </div>
            <input class="btn btn-primary w-100 py-2" type="submit" id="submit">
            <br/><br/>
            <input class="btn btn-primary w-100 py-2" type="reset" value="重置">
            <br/><br/>
        </form>
    </main>
</main>
</body>
</html>
