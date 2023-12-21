<%--
  Created by IntelliJ IDEA.
  User: xtaod
  Date: 2023/12/9
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<c:set var="title" value="阶段定义"/>
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
        <div class="operation">已定义阶段列表↓：
            <span class="mess">
                <c:if test="${'stageDeleteMess' eq sessionScope.mess.name}">${sessionScope.mess.content}</c:if>
            </span>
        </div>
        <table class="dt" border="0" cellspacing="1">
            <tr>
                <th>编号</th>
                <th>阶段名称</th>
                <th>开始时间</th>
                <th>结束时间</th>
                <th>阶段说明</th>
                <th>删除</th>
            </tr>
            <c:forEach items="${applicationScope.stages}" var="stage" varStatus="rows">
                <tr>
                    <td style="width:40px;">${stage.stagenum}</td>
                    <td>${stage.stagename}</td>
                    <td>${stage.starttime}</td>
                    <td>${stage.endtime}</td>
                    <td>${stage.note}</td>
                    <td style="width:40px;"><a href="${webroot}/sadmin/stageadd.do?action=stageDelete&stagenum=${stage.stagenum}">删除</a></td>
                </tr>
            </c:forEach>
        </table>
        <a name="add"></a>
        <div class="operation">定义系统使用阶段↓：
            <span class="mess">
                <c:if test="${'stageAddMess' eq sessionScope.mess.name}"> ${sessionScope.mess.content}</c:if>
            </span>
        </div>
        <form action="${webroot}/sadmin/stageadd.do?action=stageAdd" method="post">
            <table>
                <tr>
                    <td class="label">阶段编号：</td>
                    <td><input type="text" name="stagenum" id="stagenum" /></td>
                </tr>
                <tr>
                    <td class="label">阶段名称：</td>
                    <td><input type="text" name="stagename" id="stagename" /></td>
                </tr>
                <tr>
                    <td class="label">开始时间：</td>
                    <td><input type="datetime-local" name="starttime" id="starttime" /></td>
                </tr>
                <tr>
                    <td class="label">结束时间：</td>
                    <td><input type="datetime-local" name="endtime" id="endtime" /></td>
                </tr>
                <tr>
                    <td class="label">阶段说明：</td>
                    <td><input type="text" name="note" id="note" /></td>
                </tr>
                <tr>
                    <td colspan="3">
                        <input type="submit" value="提 交" class="button" id="submit" />
                        <input type="reset" value="重 置" class="button" id="reset" />
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <%@ include file="../includes/footer.jsp" %>
</body>
</html>
