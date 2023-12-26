<%--
  Created by IntelliJ IDEA.
  User: xtaod
  Date: 2023/12/23
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<c:set var="webroot" value="${pageContext.request.contextPath}"/>
<c:set var="title" value="录入成绩"/>
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
        <c:if test="${'gradeMess' eq sessionScope.mess.name}">
            <div class="alert alert-warning" role="alert">
                    ${sessionScope.mess.content}
            </div>
        </c:if>

        <form action="${webroot}/jadmin/gradeinput.do" method="post" enctype="multipart/form-data">
            <div>
                <label for="formFileLg" class="form-label">请您上传成绩表格</label>
                <input class="form-control form-control-lg" id="formFileLg" type="file" name="myfile">
            </div>
            <br/><br/>
            <input class="btn btn-primary w-100 py-2" type="submit" id="submit">
            <br/><br/>
        </form>

        <h1 class="h3 mb-3 fw-normal">学生成绩列表</h1>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">序号</th>
                <th scope="col">准考证号</th>
                <th scope="col">姓名</th>
                <th scope="col">科目名称</th>
                <th scope="col">成绩</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pm.data3}" var="supgrade" varStatus="row">
                <tr>
                    <td>${pm.fromIndex + row.index + 1}</td>
                    <td>${supgrade.testcardnum}</td>
                    <td>${supgrade.sname}</td>
                    <td>${supgrade.cname}</td>
                    <td>${supgrade.score}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        ${pm.pageNav}
    </main>
</main>
</body>
</html>
