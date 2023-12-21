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
<c:set var="title" value="阶段设置"/>
<c:set var="webroot" value="${pageContext.request.contextPath}"/>
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
    <div id="left">
    </div>
    <div id="right">
        <h1>${title}</h1>
        <div class="operation">设置当前阶段↓：
            <span class="mess">
                <c:if test="${'stageSetMess' eq sessionScope.mess.name}">${sessionScope.mess.content}</c:if>
            </span>
        </div>
        <form action="${webroot}/zadmin/stageset.do?action=stageSet" method="post">
            <table>
                <tr>
                    <td class="label">选择阶段：
                        <select name="currstage" id="currstage">
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
                    </td>
                    <td><input class="button" type="submit" value="确认设置"/></td>
                </tr>
            </table>
        </form>
        <div class="operation">已定义阶段列表（当前处于《 ${applicationScope.currstage.stagename} 》阶段）↓：</div>
        <table class="dt" border="0" cellspacing="1">
            <tr>
                <th>编号</th>
                <th>阶段名称</th>
                <th>开始时间</th>
                <th>结束时间</th>
                <th>阶段说明</th>
            </tr>
            <c:forEach items="${applicationScope.stages}" var="stage" varStatus="rows">
                <tr>
                    <td style="width:40px;">${stage.stagenum}</td>
                    <td>${stage.stagename}</td>
                    <td>${stage.starttime}</td>
                    <td>${stage.endtime}</td>
                    <td>${stage.note}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <%@ include file="../includes/footer.jsp" %>
</body>
</html>
