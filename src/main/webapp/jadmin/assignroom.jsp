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
<c:set var="title" value="考场与座位号分配"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>${title}</title>
    <link rel="stylesheet" type="text/css" href="../styles/basic.css"/>
</head>
<body>
<%@ include file="../includes/header.jsp" %>
<div id="content">
    <div id="right">
        <h1>${title}</h1>
        <div class="operation">考场分配↓：
            <span class="mess">
                <c:if test="${'assignRoomMess' eq sessionScope.mess.name}">${sessionScope.mess.content}</c:if>
            </span>
        </div>
        <form action="${pageContext.request.contextPath}/jadmin/room.do?action=assign" method="post">
            <table style="margin:0 auto;">
                <tr>
                    <td>单考场人数：</td>
                    <td><input type="text" name="perRoom"/></td>
                    <td><input class="button" type="submit" name="submit" value="分配考场"/></td>
                <tr/>
            </table>
        </form>
        <form action="${pageContext.request.contextPath}/jadmin/room.do?action=assure" method="post">
            <table class="dt" border="0" cellspacing="1">
                <tr>
                    <th>考场号</th>
                    <th>考场人数</th>
                    <th>分配教室</th>
                </tr>
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
            </table>
            <div>
                <input class="button" type="submit" name="submit" value="确认分配"/>
            </div>
        </form>
    </div>
</div>
<%@ include file="../includes/footer.jsp" %>
</body>
</html>
