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
    <c:choose>
        <c:when test="${not empty sessionScope.username}">
            <li class="nav-item">
                <a href="${webroot}/stu/notice.jsp" class="nav-link link-body-emphasis" aria-current="page">
                    >> 主页
                </a>
            </li>
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
        <%-- 系统管理员菜单 --%>
        <c:when test="${ '系统管理员' eq sessionScope.adminuser.admingroup }">
            <li class="nav-item">
                <a href="${webroot}/admin/state.jsp" class="nav-link link-body-emphasis" aria-current="page">
                    >> 系统状态
                </a>
            </li>
            <li class="nav-item">
                <a href="${webroot}/sadmin/stageadd.do" class="nav-link link-body-emphasis" aria-current="page">
                    >> 阶段定义
                </a>
            </li>
            <li class="nav-item">
                <a href="${webroot}/sadmin/manage.do" class="nav-link link-body-emphasis" aria-current="page">
                    >> 管理员维护
                </a>
            </li>
            <li class="nav-item">
                <a href="${webroot}/sadmin/db.jsp" class="nav-link link-body-emphasis" aria-current="page">
                    >> 数据库管理
                </a>
            </li>
            <li class="nav-item">
                <a href="${webroot}/admin/infomanage.do" class="nav-link link-body-emphasis" aria-current="page">
                    >> 查看报名信息
                </a>
            </li>
            <li class="nav-item">
                <a href="${webroot}/admin/grade.jsp" class="nav-link link-body-emphasis" aria-current="page">
                    >> 查看成绩信息
                </a>
            </li>
        </c:when>
        <%-- 招生管理员菜单 --%>
        <c:when test="${ '招生管理员' eq sessionScope.adminuser.admingroup }">
            <li class="nav-item">
                <a href="${webroot}/admin/state.jsp" class="nav-link link-body-emphasis" aria-current="page">
                    >> 系统状态
                </a>
            </li>
            <li class="nav-item">
                <a href="${webroot}/zadmin/stageset.jsp" class="nav-link link-body-emphasis" aria-current="page">
                    >> 阶段设置
                </a>
            </li>
            <li class="nav-item">
                <a href="${webroot}/zadmin/release.jsp" class="nav-link link-body-emphasis" aria-current="page">
                    >> 招考信息设置
                </a>
            </li>
            <li class="nav-item">
                <a href="${webroot}/admin/infomanage.do" class="nav-link link-body-emphasis" aria-current="page">
                    >> 查看报名信息
                </a>
            </li>
            <li class="nav-item">
                <a href="${webroot}/zadmin/confirm.jsp" class="nav-link link-body-emphasis" aria-current="page">
                    >> 现场确认
                </a>
            </li>
            <li class="nav-item">
                <a href="${webroot}/admin/grade.jsp" class="nav-link link-body-emphasis" aria-current="page">
                    >> 查看成绩信息
                </a>
            </li>
            <li class="nav-item">
                <a href="${webroot}/zadmin/line.jsp" class="nav-link link-body-emphasis" aria-current="page">
                    >> 设置录取分数线
                </a>
            </li>
            <li class="nav-item">
                <a href="${webroot}/zadmin/stumanage.jsp" class="nav-link link-body-emphasis" aria-current="page">
                    >> 学生密码清零
                </a>
            </li>
        </c:when>
        <%-- 教务管理员菜单 --%>
        <c:when test="${ '教务管理员' eq sessionScope.adminuser.admingroup }">
            <li class="nav-item">
                <a href="${webroot}/admin/state.jsp" class="nav-link link-body-emphasis" aria-current="page">
                    >> 系统状态
                </a>
            </li>
            <li class="nav-item">
                <a href="${webroot}/jadmin/assignnum.do" class="nav-link link-body-emphasis" aria-current="page">
                    >> 准考证号分配
                </a>
            </li>
            <li class="nav-item">
                <a href="${webroot}/jadmin/assignroom.jsp" class="nav-link link-body-emphasis" aria-current="page">
                    >> 考场分配
                </a>
            </li>
            <li class="nav-item">
                <a href="${webroot}/jadmin/gradeinput.do" class="nav-link link-body-emphasis" aria-current="page">
                    >> 录入成绩
                </a>
            </li>
            <li class="nav-item">
                <a href="${webroot}/admin/infomanage.do" class="nav-link link-body-emphasis" aria-current="page">
                    >> 查看报名信息
                </a>
            </li>
            <li class="nav-item">
                <a href="${webroot}/admin/grade.jsp" class="nav-link link-body-emphasis" aria-current="page">
                    >> 查看成绩信息
                </a>
            </li>
        </c:when>
        <c:otherwise>
            <li class="nav-item">
                <a href="${webroot}/" class="nav-link link-body-emphasis" aria-current="page">
                    >> 主页
                </a>
            </li>
        </c:otherwise>
    </c:choose>
</ul>