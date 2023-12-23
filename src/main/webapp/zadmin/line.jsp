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
<c:set var="title" value="确定录取分数线"/>
<c:set var="webroot" value="${pageContext.request.contextPath}"/>
<c:set var="majors" value="${applicationScope.majors}"/>
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
        <div class="operation">选择设置分数线的专业↓：
            <span class="mess">
                <c:if test="${'lineMess' eq sessionScope.mess.name}">${sessionScope.mess.content}</c:if>
      </span>
        </div>
        <form action="${webroot}/zadmin/line.do" method="get">
            <table>
                <tr>
                    <td>专业：</td>
                    <td>
                        <select name="mcode" id="mcode">
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
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="确定"/>
                        <input type="reset" value="重置"/>
                    </td>
                </tr>
            </table>
        </form>
        <div class="operation">设置分数线↓：</div>
        <form action="${webroot}/zadmin/line.do?mcode=${mcode}" method="post">
            <table>
                <input type="hidden" name="mcode" id="mcode" value="${mcode}"/>
                <tr>
                    <td>分数线：</td>
                    <td>
                        <input type="text" name="passcode" id="passcode" value="${passcode}"/>
                    </td>
                </tr>
                <tr>
                    <td>当前分数线预计可录取人数：</td>
                    <td>
                        <input type="text" disabled name="num" id="num" value="${passnum}"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="确定"/>
                        <input type="reset" value="重置"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <%@ include file="../includes/footer.jsp" %>
</body>
</html>
