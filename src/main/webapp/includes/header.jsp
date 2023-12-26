<%--
  Created by IntelliJ IDEA.
  User: xtaod
  Date: 2023/12/9
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<c:set var="webroot" value="${pageContext.request.contextPath}"/>
<div class="d-flex flex-column flex-shrink-0 p-3 bg-body-tertiary" style="width: 280px;">
    <a href="${webroot}/"
       class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
        <img src="${webroot}/images/logo.jpg" alt="" width="32" height="32" class="rounded-circle me-2">
        <span class="fs-4">${applicationScope.school.shtest}报名系统</span>
    </a>
    <hr>
    <%@ include file="./menu.jsp" %>
    <%@ include file="./dropdown.jsp" %>
    <%@ include file="./footer.jsp" %>
</div>
<div class="b-example-divider b-example-vr"></div>