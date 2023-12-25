<%--
  Created by IntelliJ IDEA.
  User: xtaod
  Date: 2023/12/21
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<c:set var="webroot" value="${pageContext.request.contextPath}"/>
<c:set var="title" value="阶段设置"/>
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
    <link rel="stylesheet" href="${webroot}/styles/entry.css" crossorigin="anonymous">
</head>
<body>
<main class="d-flex flex-nowrap">
    <%@ include file="../includes/header.jsp" %>

    <main class="form-signin w-100 m-auto scrollspy" style="min-width: 800px">
        <img class="mb-4" src="${webroot}/images/logo.jpg" alt="" width="72" height="72">
        <h1 class="h3 mb-3 fw-normal">${title}</h1>
        <c:if test="${'stageSetMess' eq sessionScope.mess.name}">
            <div class="alert alert-warning" role="alert">
                    ${sessionScope.mess.content}
            </div>
        </c:if>

        <form action="${webroot}/zadmin/stageset.do?action=stageSet" method="post">
            <div class="input-group mb-3">
                <span class="input-group-text">选择阶段</span>
                <select class="form-select" name="currstage" id="currstage">
                    <c:forEach items="${applicationScope.stages}" var="stage">
                        <c:choose>
                            <c:when test="${ stage.stagename eq applicationScope.currstage.stagename }">
                                <option value="${stage.stagename}" selected="selected"> ${stage.stagenum}
                                    : ${stage.stagename} </option>
                            </c:when>
                            <c:otherwise>
                                <option value="${stage.stagename}"> ${stage.stagenum}
                                    : ${stage.stagename} </option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>
            <input class="btn btn-primary w-100 py-2" type="submit" id="submit" value="设置">
            <br/><br/>
        </form>


        <h5>已定义阶段列表</h5>
        <span>（当前处于《 ${applicationScope.currstage.stagename} 》阶段）</span>

        <table class="table">
            <thead>
            <tr>
                <th scope="col">编号</th>
                <th scope="col">阶段名称</th>
                <th scope="col">开始时间</th>
                <th scope="col">结束时间</th>
                <th scope="col">阶段说明</th>
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
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </main>
</main>
</body>
</html>
