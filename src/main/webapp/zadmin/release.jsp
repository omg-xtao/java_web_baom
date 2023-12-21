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
<c:set var="title" value="招考信息设置"/>
<c:set var="webroot" value="${pageContext.request.contextPath}"/>
<c:set var="school" value="${applicationScope.school}"/>
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
        <div class="operation">设置学校基本信息↓：
            <span class="mess">
                <c:if test="${'schoolAddMess' eq sessionScope.mess.name}">${sessionScope.mess.content}</c:if>
            </span>
        </div>
        <div class="ft">
            <form method="post" action="${webroot}/zadmin/release.do?action=schoolAdd">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td class="tr">学校代码：</td>
                        <td><input type="text" name="shcode" id="shcode" value="${school.shcode}"></td>
                    </tr>
                    <tr>
                        <td class="tr">学校名称：</td>
                        <td><input type="text" name="shname" id="shname" value="${school.shname}"/></td>
                    </tr>
                    <tr>
                        <td class="tr">学校地址：</td>
                        <td><input type="text" name="shaddr" id="shaddr" value="${school.shaddr}"/></td>
                    </tr>
                    <tr>
                        <td class="tr">邮编：</td>
                        <td><input type="text" name="shzip" id="shzip" value="${school.shzip}"/></td>
                    </tr>
                    <tr>
                        <td class="tr">联系电话：</td>
                        <td><input type="text" name="shtel" id="shtel" value="${school.shtel}"/></td>
                    </tr>
                    <tr>
                        <td class="tr">考试名称：</td>
                        <td><input type="text" name="shtest" id="shtest" value="${school.shtest}"/></td>
                    </tr>
                    <tr>
                        <td class="tr">招生年份：</td>
                        <td><input type="text" name="shyear" id="shyear" value="${school.shyear}"/></td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            <input type="submit" value="提 交" class="button"/>
                            <input type="reset" value="重 置" class="button"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
    <%@ include file="../includes/footer.jsp" %>
</body>
</html>
