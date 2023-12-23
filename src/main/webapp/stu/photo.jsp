<%--
  Created by IntelliJ IDEA.
  User: xtaod
  Date: 2023/12/22
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<c:set var="title" value="上传照片"/>
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
        <div class="operation">请您上传照片↓：
            <span class="mess">
                <c:if test="${'stuPhotoMess' eq sessionScope.mess.name}">${sessionScope.mess.content}</c:if>
            </span>
        </div>
        <div>
            <form action="${webroot}/stu/photo.do" method="post" enctype="multipart/form-data">
                <input type="file" name="myfile"/>
                <input type="submit" value="上传"/>
            </form>
            <img src="${webroot}/upload/${sessionScope.username}.jpg" style="height: 200px; width: 141px">
        </div>
    </div>
    <%@ include file="../includes/footer.jsp" %>
</body>
</html>