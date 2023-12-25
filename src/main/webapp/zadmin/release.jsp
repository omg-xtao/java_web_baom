<%--
  Created by IntelliJ IDEA.
  User: xtaod
  Date: 2023/12/21
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<c:set var="webroot" value="${pageContext.request.contextPath}"/>
<c:set var="title" value="招考信息设置"/>
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
        <h1 class="h3 mb-3 fw-normal">学校基本信息</h1>
        <c:if test="${'schoolAddMess' eq sessionScope.mess.name}">
            <div class="alert alert-warning" role="alert">
                    ${sessionScope.mess.content}
            </div>
        </c:if>
        <form method="post" action="${webroot}/zadmin/release.do?action=schoolAdd">
            <div class="input-group mb-3">
                <span class="input-group-text">学校代码</span>
                <input type="text" class="form-control" name="shcode" id="shcode" value="${school.shcode}">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">学校名称</span>
                <input type="text" class="form-control" name="shname" id="shname" value="${school.shname}">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">学校地址</span>
                <input type="text" class="form-control" name="shaddr" id="shaddr" value="${school.shaddr}">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">邮编</span>
                <input type="text" class="form-control" name="shzip" id="shzip" value="${school.shzip}">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">联系电话</span>
                <input type="text" class="form-control" name="shtel" id="shtel" value="${school.shtel}">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">考试名称</span>
                <input type="text" class="form-control" name="shtest" id="shtest" value="${school.shtest}">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">招生年份</span>
                <input type="text" class="form-control" name="shyear" id="shyear" value="${school.shyear}">
            </div>

            <input class="btn btn-primary w-100 py-2" type="submit" id="submit" value="提交">
            <br/><br/>
            <input class="btn btn-primary w-100 py-2" type="reset" id="reset">
            <br/><br/>
        </form>

        <h1 class="h3 mb-3 fw-normal">已添加的专业</h1>
        <c:if test="${'majorDeleteMess' eq sessionScope.mess.name}">
            <div class="alert alert-warning" role="alert">
                    ${sessionScope.mess.content}
            </div>
        </c:if>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">序号</th>
                <th scope="col">专业代码</th>
                <th scope="col">专业名称</th>
                <th scope="col">计划录取人数</th>
                <th scope="col">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${applicationScope.majors}" var="major" varStatus="rows">
                <tr>
                    <td>${rows.index + 1}</td>
                    <td>${major.mcode}</td>
                    <td>${major.mname}</td>
                    <td>${major.plannum}</td>
                    <td><a href="${webroot}/zadmin/release.do?action=majorDelete&mcode=${major.mcode}">删除</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <h1 class="h3 mb-3 fw-normal">添加专业</h1>
        <c:if test="${'majorAddMess' eq sessionScope.mess.name}">
            <div class="alert alert-warning" role="alert">
                    ${sessionScope.mess.content}
            </div>
        </c:if>
        <form action="${webroot}/zadmin/release.do?action=majorAdd" method="post">
            <div class="input-group mb-3">
                <span class="input-group-text">专业代码</span>
                <input type="text" class="form-control" name="mcode" id="mcode">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">专业名称</span>
                <input type="text" class="form-control" name="mname" id="mname">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">计划录取人数</span>
                <input type="text" class="form-control" name="plannum" id="plannum">
            </div>

            <input class="btn btn-primary w-100 py-2" type="submit" id="submit" value="提交">
            <br/><br/>
            <input class="btn btn-primary w-100 py-2" type="reset" id="reset">
            <br/><br/>
        </form>

        <h1 class="h3 mb-3 fw-normal">已添加的课程</h1>
        <c:if test="${'courseDeleteMess' eq sessionScope.mess.name}">
            <div class="alert alert-warning" role="alert">
                    ${sessionScope.mess.content}
            </div>
        </c:if>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">序号</th>
                <th scope="col">课程编号</th>
                <th scope="col">课程名称</th>
                <th scope="col">隶属专业</th>
                <th scope="col">考试开始时间</th>
                <th scope="col">考试结束时间</th>
                <th scope="col">删除课程</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${applicationScope.courses}" var="course" varStatus="rows">
                <tr>
                    <td>${rows.index + 1}</td>
                    <td>${course.ccode}</td>
                    <td>${course.cname}</td>
                    <td>${course.cmname}</td>
                    <td>${course.cstarttime}</td>
                    <td>${course.cendtime}</td>
                    <td><a href="${webroot}/zadmin/release.do?action=courseDelete&ccode=${course.ccode}">删除</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <h1 class="h3 mb-3 fw-normal">添加课程</h1>
        <c:if test="${'courseAddMess' eq sessionScope.mess.name}">
            <div class="alert alert-warning" role="alert">
                    ${sessionScope.mess.content}
            </div>
        </c:if>
        <form action="${webroot}/zadmin/release.do?action=courseAdd" method="post">
            <div class="input-group mb-3">
                <span class="input-group-text">课程编号</span>
                <input type="text" class="form-control" name="ccode" id="ccode">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">课程名称</span>
                <input type="text" class="form-control" name="cname" id="cname">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">隶属专业</span>
                <select class="form-select" name="cmname" id="cmname">
                    <c:forEach items="${applicationScope.majors}" var="major">
                        <option value="${major.mname}">${major.mname}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">考试开始时间</span>
                <input type="datetime-local" class="form-control" name="cstarttime" id="cstarttime">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">考试结束时间</span>
                <input type="datetime-local" class="form-control" name="cendtime" id="cendtime">
            </div>

            <input class="btn btn-primary w-100 py-2" type="submit" id="submit" value="提交">
            <br/><br/>
            <input class="btn btn-primary w-100 py-2" type="reset" id="reset">
            <br/><br/>
        </form>
    </main>
</main>
</body>
</html>
