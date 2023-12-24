<%--
  Created by IntelliJ IDEA.
  User: xtaod
  Date: 2023/12/9
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<c:set var="webroot" value="${pageContext.request.contextPath}"/>
<footer class="justify-content-between align-items-center py-1 my-4 border-top">
    <p class="text-body-secondary">&copy; ${applicationScope.school.shyear} ${applicationScope.school.shname}</p>
    <p class="text-body-secondary">邮编：${applicationScope.school.shzip}</p>
    <p class="text-body-secondary">地址：${applicationScope.school.shaddr}</p>
</footer>