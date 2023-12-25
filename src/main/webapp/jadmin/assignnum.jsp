<%--
  Created by IntelliJ IDEA.
  User: xtaod
  Date: 2023/12/23
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<c:set var="webroot" value="${pageContext.request.contextPath}"/>
<c:set var="title" value="准考证号生成"/>
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
        <h1 class="h3 mb-3 fw-normal">准考证号分配列表</h1>
        <c:if test="${'assignMess' eq sessionScope.mess.name}">
            <div class="alert alert-warning" role="alert">
                    ${sessionScope.mess.content}
            </div>
        </c:if>

        <table class="table">
            <thead>
            <tr>
                <th scope="col">序号</th>
                <th scope="col">身份证号</th>
                <th scope="col">考生姓名</th>
                <th scope="col">报考专业</th>
                <th scope="col">准考证号</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pm.data2}" var="reginfo" varStatus="row">
                <tr>
                    <td>${pm.fromIndex + row.index + 1}</td>
                    <td>${reginfo.idcode}</td>
                    <td>${reginfo.sname}</td>
                    <td>${reginfo.mname}</td>
                    <td>${reginfo.testcardnum}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        ${pm.pageNav}

        <form action="${webroot}/jadmin/cardnum.do?action=assign" method="post">
            <input class="btn btn-primary w-100 py-2" type="submit" id="submit" value="确认分配">
            <br/><br/>
        </form>
    </main>
</main>
</body>
</html>
