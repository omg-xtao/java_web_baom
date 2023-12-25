<%--
  Created by IntelliJ IDEA.
  User: xtaod
  Date: 2023/12/24
  Time: 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<c:set var="webroot" value="${pageContext.request.contextPath}"/>
<ul class="nav nav-pills flex-column mb-auto">
    <li class="nav-item">
        <a href="${webroot}/" class="nav-link link-body-emphasis" aria-current="page">
            >> 主页
        </a>
    </li>
    <c:choose>
        <c:when test="${not empty sessionScope.username}">
            <li class="nav-item">
                <a href="${webroot}/stu/entry.do" class="nav-link link-body-emphasis" aria-current="page">
                    >> 我的报名信息
                </a>
            </li>
            <li class="nav-item">
                <a href="${webroot}/stu/photo.jsp" class="nav-link link-body-emphasis" aria-current="page">
                    >> 上传照片
                </a>
            </li>
            <li class="nav-item">
                <a href="${webroot}/stu/entry_print.jsp" class="nav-link link-body-emphasis" aria-current="page">
                    >> 报名表打印
                </a>
            </li>
            <li class="nav-item">
                <a href="${webroot}/stu/card_print.jsp" class="nav-link link-body-emphasis" aria-current="page">
                    >> 准考证打印
                </a>
            </li>
            <li class="nav-item">
                <a href="${webroot}/stu/grade.do" class="nav-link link-body-emphasis" aria-current="page">
                    >> 成绩与录取查询
                </a>
            </li>
        </c:when>
    </c:choose>
</ul>