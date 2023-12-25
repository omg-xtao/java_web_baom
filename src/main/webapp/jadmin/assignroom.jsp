<%--
  Created by IntelliJ IDEA.
  User: xtaod
  Date: 2023/12/23
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<c:set var="webroot" value="${pageContext.request.contextPath}"/>
<c:set var="title" value="考场与座位号分配"/>
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

    <main class="form-signin w-100 m-auto" style="max-width: 800px;">
        <img class="mb-4" src="${webroot}/images/logo.jpg" alt="" width="72" height="72">
        <h1 class="h3 mb-3 fw-normal">考场分配</h1>
        <c:if test="${'assignRoomMess' eq sessionScope.mess.name}">
            <div class="alert alert-warning" role="alert">
                    ${sessionScope.mess.content}
            </div>
        </c:if>

        <form action="${pageContext.request.contextPath}/jadmin/room.do?action=assign" method="post">
            <div class="input-group mb-3">
                <span class="input-group-text">单考场人数</span>
                <input type="text" class="form-control" name="perRoom" id="perRoom">
            </div>

            <input class="btn btn-primary w-100 py-2" type="submit" id="submit" value="分配考场">
            <br/><br/>
        </form>

        <c:if test="${room > 0}">
            <form action="${pageContext.request.contextPath}/jadmin/room.do?action=assure" method="post">

                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">考场号</th>
                        <th scope="col">考场人数</th>
                        <th scope="col">分配教室</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${room > 0}">
                        <c:forEach var="rom" begin="1" end="${room-1}">
                            <tr>
                                <td>${rom}</td>
                                <td>${perroom}</td>
                                <td><input type="text" name="rooms"/></td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td>${room}</td>
                            <td>${remain}</td>
                            <td><input type="text" name="rooms"/></td>
                        </tr>
                    </c:if>
                    </tbody>
                </table>

                <input class="btn btn-primary w-100 py-2" type="submit" id="submit" value="确认分配">
                <br/><br/>
            </form>
        </c:if>
    </main>
</main>
</body>
</html>
