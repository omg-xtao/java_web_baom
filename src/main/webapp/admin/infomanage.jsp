<%--
  Created by IntelliJ IDEA.
  User: xtaod
  Date: 2023/12/22
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<c:set var="webroot" value="${pageContext.request.contextPath}"/>
<c:set var="title" value="查看报名信息"/>
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
        <h1 class="h3 mb-3 fw-normal">专业信息</h1>

        <table class="table">
            <thead>
            <tr>
                <th scope="col">专业名称</th>
                <th scope="col">计划招生人数</th>
                <th scope="col">实际报考人数</th>
                <th scope="col">录取人数</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${applicationScope.majors}" var="major">
                <tr>
                    <td>${major.mname}</td>
                    <td>${major.plannum}</td>
                    <td>${major.applynum}</td>
                    <td>${major.admitnum}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <h1 class="h3 mb-3 fw-normal">查看报名信息</h1>
        <form action="${webroot}/admin/reginfomanage.do" method="post">
            <div class="input-group mb-3">
                <span class="input-group-text">报考专业</span>
                <select class="form-select" name="mname" id="mname">
                    <option value="all" selected="selected">全部</option>
                    <c:forEach items="${applicationScope.majors}" var="major">
                        <option value="${major.mname}">${major.mname}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">是否已确认</span>
                <select class="form-select" name="isconfirm" id="isconfirm">
                    <option value="all" selected='selected'>全部</option>
                    <option value="true">已确认</option>
                    <option value="false">未确认</option>
                </select>
            </div>
            <input class="btn btn-primary w-100 py-2" type="submit" id="submit" value="查询">
            <br/><br/>
        </form>

        <table class="table">
            <thead>
            <tr>
                <th scope="col">身份证号</th>
                <th scope="col">考生姓名</th>
                <th scope="col">考生性别</th>
                <th scope="col">报考专业</th>
                <th scope="col">是否确认</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pm.data2}" var="reginfo" varStatus="rows">
                <tr>
                    <td>${reginfo.idcode}</td>
                    <td>${reginfo.sname}</td>
                    <td>${reginfo.ssex}</td>
                    <td>${reginfo.mname}</td>
                    <c:choose>
                        <c:when test="${reginfo.isconfirm}">
                            <td>是</td>
                        </c:when>
                        <c:otherwise>
                            <td>否</td>
                        </c:otherwise>
                    </c:choose>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        ${pm.pageNav}
    </main>
</main>
</body>
</html>
