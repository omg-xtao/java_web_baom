<%--
  Created by IntelliJ IDEA.
  User: xtaod
  Date: 2023/12/24
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<c:set var="webroot" value="${pageContext.request.contextPath}"/>
<c:choose>
    <c:when test="${not empty sessionScope.username}">
        <hr>
        <div class="dropdown">
            <a href="#" class="d-flex align-items-center link-body-emphasis text-decoration-none dropdown-toggle"
               data-bs-toggle="dropdown" aria-expanded="false">
                <img src="${webroot}/images/logo.jpg" alt="" width="32" height="32" class="rounded-circle me-2">
                <strong>${sessionScope.username}</strong>
            </a>
            <ul class="dropdown-menu text-small shadow">
                <li><a class="dropdown-item" href="${webroot}/record.do">我的登录历史</a></li>
                <li><a class="dropdown-item" href="${webroot}/stu/pass.jsp">修改密码</a></li>
                <li>
                    <hr class="dropdown-divider">
                </li>
                <li><a class="dropdown-item" href="${webroot}/logout.jsp">退出登录</a></li>
            </ul>
        </div>
    </c:when>
    <c:when test="${not empty sessionScope.adminuser}">
        <hr>
        <div class="dropdown">
            <a href="#" class="d-flex align-items-center link-body-emphasis text-decoration-none dropdown-toggle"
               data-bs-toggle="dropdown" aria-expanded="false">
                <img src="${webroot}/images/logo.jpg" alt="" width="32" height="32" class="rounded-circle me-2">
                <strong>${sessionScope.adminuser.adminname}</strong>
            </a>
            <ul class="dropdown-menu text-small shadow">
                <li><a class="dropdown-item" href="${webroot}/admin/record.do">我的登录历史</a></li>
                <li><a class="dropdown-item" href="${webroot}/admin/pass.jsp">修改密码</a></li>
                <li>
                    <hr class="dropdown-divider">
                </li>
                <li><a class="dropdown-item" href="${webroot}/logout.jsp">退出登录</a></li>
            </ul>
        </div>
    </c:when>
</c:choose>