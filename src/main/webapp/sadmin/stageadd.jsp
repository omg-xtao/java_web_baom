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
<c:set var="title" value="阶段定义"/>
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

        <h1 class="h3 mb-3 fw-normal">已定义阶段列表</h1>

        <c:if test="${'stageDeleteMess' eq sessionScope.mess.name}">
            <div class="alert alert-warning" role="alert">
                    ${sessionScope.mess.content}
            </div>
        </c:if>

        <table class="table">
            <thead>
            <tr>
                <th scope="col">编号</th>
                <th scope="col">阶段名称</th>
                <th scope="col">开始时间</th>
                <th scope="col">结束时间</th>
                <th scope="col">阶段说明</th>
                <th scope="col">删除</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${applicationScope.stages}" var="stage" varStatus="rows">
                <tr>
                    <td style="width:40px;">${stage.stagenum}</td>
                    <td>${stage.stagename}</td>
                    <td>${stage.starttime}</td>
                    <td>${stage.endtime}</td>
                    <td>${stage.note}</td>
                    <td style="width:40px;"><a
                            href="${webroot}/sadmin/stageadd.do?action=stageDelete&stagenum=${stage.stagenum}">删除</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <h1 class="h3 mb-3 fw-normal">定义系统使用阶段</h1>
        <c:if test="${'stageAddMess' eq sessionScope.mess.name}">
            <div class="alert alert-warning" role="alert">
                    ${sessionScope.mess.content}
            </div>
        </c:if>

        <form action="${webroot}/sadmin/stageadd.do?action=stageAdd" method="post">
            <div class="input-group mb-3">
                <span class="input-group-text">阶段编号</span>
                <input type="text" class="form-control" name="stagenum" id="stagenum">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">阶段名称</span>
                <input type="text" class="form-control" name="stagename" id="stagename">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">开始时间</span>
                <input type="datetime-local" class="form-control" name="starttime" id="starttime">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">结束时间</span>
                <input type="datetime-local" class="form-control" name="endtime" id="endtime">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">阶段说明</span>
                <textarea class="form-control" aria-label="阶段说明" name="note" id="note"></textarea>
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
