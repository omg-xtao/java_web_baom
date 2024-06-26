<%--
  Created by IntelliJ IDEA.
  User: xtaod
  Date: 2023/12/23
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<c:set var="webroot" value="${pageContext.request.contextPath}"/>
<c:set var="title" value="查看成绩信息"/>
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
    <%@ include file="../includes/header.jsp" %>

    <main class="form-signin w-100 m-auto" style="max-width: 600px;">
        <img class="mb-4" src="${webroot}/images/logo.jpg" alt="" width="72" height="72">
        <h1 class="h3 mb-3 fw-normal">${title}</h1>

        <c:if test="${not empty requestScope.gradeMess}">
            <div class="alert alert-warning" role="alert">
                    ${requestScope.gradeMess}
            </div>
        </c:if>

        <form action="${webroot}/admin/grade.do" method="post">
            <div class="form-floating">
                <input type="text" class="form-control" id="testcardnum" name="testcardnum">
                <label for="testcardnum">请输入准考证号</label>
            </div>
            <div class="form-floating">
                <input type="text" class="form-control" id="sname" name="sname">
                <label for="sname">请输入考生姓名</label>
            </div>
            <button class="w-100 btn btn-lg btn-primary" type="submit">查询</button>
        </form>

        <table class="table">
            <thead>
            <tr>
                <th scope="col">准考证号</th>
                <th scope="col">考生姓名</th>
                <th scope="col">考试科目</th>
                <th scope="col">成绩</th>
                <th scope="col">备注</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${grades}" var="grade">
                <tr>
                    <td>${grade.testcardnum}</td>
                    <td>${grade.sname}</td>
                    <td>${grade.cname}</td>
                    <td>${grade.score}</td>
                    <td>${grade.note}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </main>
</main>
</body>
</html>
