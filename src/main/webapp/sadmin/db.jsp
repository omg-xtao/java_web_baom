<%--
  Created by IntelliJ IDEA.
  User: xtaod
  Date: 2023/12/23
  Time: 23:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<c:set var="title" value="数据库管理"/>
<c:set var="webroot" value="${pageContext.request.contextPath}"/>
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
        <img class="mb-4" src="${webroot}/images/logo.jpg" alt="" width="72" height="72">

        <h1 class="h3 mb-3 fw-normal">备份数据库</h1>
        <c:if test="${'backupMess' eq sessionScope.mess.name}">
            <div class="alert alert-warning" role="alert">
                    ${sessionScope.mess.content}
            </div>
        </c:if>

        <form action="${webroot}/sadmin/db.do?action=backup" method="post">
            <input class="btn btn-primary w-100 py-2" type="submit" id="submit" value="备份数据库">
            <br/><br/>
        </form>

        <h1 class="h3 mb-3 fw-normal">恢复数据库</h1>
        <c:if test="${'restoreMess' eq sessionScope.mess.name}">
            <div class="alert alert-warning" role="alert">
                    ${sessionScope.mess.content}
            </div>
        </c:if>

        <form action="${webroot}/sadmin/db.do?action=restore" method="post" enctype="multipart/form-data">
            <div>
                <label for="formFileLg" class="form-label">请您上传 sql 文件</label>
                <input class="form-control form-control-lg" id="formFileLg" type="file" name="myfile">
            </div>
            <br/><br/>
            <input class="btn btn-primary w-100 py-2" type="submit" id="submit" value="恢复数据库">
            <br/><br/>
        </form>
    </main>
</main>
</body>
</html>
