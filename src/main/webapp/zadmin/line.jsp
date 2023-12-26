<%--
  Created by IntelliJ IDEA.
  User: xtaod
  Date: 2023/12/23
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<c:set var="webroot" value="${pageContext.request.contextPath}"/>
<c:set var="title" value="确定录取分数线"/>
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
        <c:if test="${'lineMess' eq sessionScope.mess.name}">
            <div class="alert alert-warning" role="alert">
                    ${sessionScope.mess.content}
            </div>
        </c:if>

        <form action="${webroot}/zadmin/line.do" method="get">
            <div class="input-group mb-3">
                <span class="input-group-text">专业</span>
                <select class="form-select" name="mcode" id="mcode" required>
                    <c:forEach items="${majors}" var="major">
                        <c:choose>
                            <c:when test="${major.mcode eq mcode}">
                                <option value="${major.mcode}" selected>${major.mname}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${major.mcode}">${major.mname}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>

            <input class="btn btn-primary w-100 py-2" type="submit" id="submit" value="确定">
            <br/><br/>
        </form>

        <c:if test="${not empty mcode}">
            <h5>设置分数线</h5>
            <form action="${webroot}/zadmin/line.do?mcode=${mcode}" method="post">
                <div class="input-group mb-3">
                    <span class="input-group-text">分数线</span>
                    <input type="text" class="form-control" name="passcode" id="passcode" value="${passcode}" required>
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text">当前分数线预计可录取人数</span>
                    <input type="text" class="form-control" disabled name="num" id="num" value="${passnum}"/>
                </div>

                <input class="btn btn-primary w-100 py-2" type="submit" id="submit" value="确定">
                <br/><br/>
            </form>
        </c:if>
    </main>
</main>
</body>
</html>
