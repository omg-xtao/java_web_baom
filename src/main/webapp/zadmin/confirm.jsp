<%--
  Created by IntelliJ IDEA.
  User: xtaod
  Date: 2023/12/23
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<c:set var="webroot" value="${pageContext.request.contextPath}"/>
<c:set var="title" value="考生现场确认"/>
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
        <c:if test="${'confirmMess' eq sessionScope.mess.name}">
            <div class="alert alert-warning" role="alert">
                    ${sessionScope.mess.content}
            </div>
        </c:if>

        <form action="${webroot}/zadmin/confirm.do" method="post">
            <div class="input-group mb-3">
                <span class="input-group-text">身份证号</span>
                <input type="text" class="form-control" name="idCode" id="idCode" value="${idCode}" required>
            </div>

            <input class="btn btn-primary w-100 py-2" type="submit" id="submit" value="查询">
            <br/><br/>
        </form>

        <table class="table">
            <thead>
            <tr>
                <th scope="col">考生姓名</th>
                <th scope="col">身份证号</th>
                <th scope="col">性别</th>
                <th scope="col">是否应届生</th>
                <th scope="col">报考专业</th>
                <th scope="col">确认情况</th>
                <th scope="col">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${reginfos}" var="reginfo">
                <form action="${webroot}/zadmin/confirm.do?confirm=1" method="post">
                    <tr>
                        <td>${reginfo.sname}</td>
                        <td>${reginfo.idcode}</td>
                        <td>${reginfo.ssex}</td>
                        <td>${reginfo.isnew}</td>
                        <td>${reginfo.mname}</td>
                        <c:choose>
                            <c:when test="${reginfo.isconfirm}">
                                <td>是</td>
                            </c:when>
                            <c:otherwise>
                                <td>否</td>
                            </c:otherwise>
                        </c:choose>
                        <td>
                            <input type="hidden" name="username" id="username" value="${reginfo.username}"/>
                            <input type="hidden" name="idcode" id="idCode" value="${reginfo.idcode}"/>
                            <input class="btn btn-primary btn-sm w-100 py-2" type="submit" id="submit" value="确定">
                        </td>
                    </tr>
                </form>
            </c:forEach>
            </tbody>
        </table>
    </main>
</main>
</body>
</html>
