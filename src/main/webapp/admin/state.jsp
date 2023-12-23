<%--
  Created by IntelliJ IDEA.
  User: xtaod
  Date: 2023/12/20
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="webroot" value="${pageContext.request.contextPath}"/>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    ServletContext context = session.getServletContext();
    Integer count = (Integer) context.getAttribute("count");
%>
<p>当前在线人数共 <%=count %> 人</p>
<c:choose>
    <%-- 系统管理员菜单 --%>
    <c:when test="${ '系统管理员' eq sessionScope.adminuser.admingroup }">
        <div id="menu">
            <a href="${webroot}/admin/state.do">系统状态</a>
            <a href="${webroot}/sadmin/stageadd.do">阶段定义</a>
            <a href="${webroot}/sadmin/manage.do">管理员维护</a>
            <a href="${webroot}/sadmin/db.do">数据库管理</a>
            <a href="${webroot}/admin/reginfomanage.do">查看报名信息</a>
            <a href="${webroot}/admin/grade.do">查看成绩信息</a>
            <a href="${webroot}/admin/record.do">我的登录历史</a>
            <a href="${webroot}/admin/pass.jsp">修改密码</a>
            <a href="${webroot}/logout.jsp">退出系统</a>
        </div>
    </c:when>
    <%-- 招生管理员菜单 --%>
    <c:when test="${ '招生管理员' eq sessionScope.adminuser.admingroup }">
        <div id="menu">
            <a href="${webroot}/admin/state.do">系统状态</a>
            <a href="${webroot}/zadmin/stageset.jsp">阶段设置</a>
            <a href="${webroot}/zadmin/release.jsp">招考信息设置</a>
            <a href="${webroot}/admin/reginfomanage.do">查看报名信息</a>
            <a href="${webroot}/zadmin/confirm.jsp">现场确认</a>
            <a href="${webroot}/admin/grade.do">查看成绩信息</a>
            <a href="${webroot}/zadmin/line.do">设置录取分数线</a>
            <a href="${webroot}/zadmin/stumanage.jsp">学生密码清零</a>
            <a href="${webroot}/admin/record.do">我的登录历史</a>
            <a href="${webroot}/admin/pass.jsp">修改密码</a>
            <a href="${webroot}/logout.jsp">退出系统</a>
        </div>
    </c:when>
    <%-- 教务管理员菜单 --%>
    <c:when test="${ '教务管理员' eq sessionScope.adminuser.admingroup }">
        <div id="menu">
            <a href="${webroot}/admin/state.do">系统状态</a>
            <a href="${webroot}/admin/reginfomanage.do">查看报名信息</a>
            <a href="${webroot}/jadmin/cardnum.do">准考证号分配</a>
            <a href="${webroot}/jadmin/room.do">考场分配</a>
            <a href="${webroot}/jadmin/gradeinput.do">录入成绩</a>
            <a href="${webroot}/admin/grade.do">查看成绩信息</a>
            <a href="${webroot}/admin/record.do">我的登录历史</a>
            <a href="${webroot}/admin/pass.jsp">修改密码</a>
            <a href="${webroot}/logout.jsp">退出系统</a>
        </div>
    </c:when>
    <%-- 非管理员用户 --%>
    <c:otherwise>
        <c:redirect url="${webroot}/logout.jsp"></c:redirect>
    </c:otherwise>
</c:choose>
</body>
</html>
