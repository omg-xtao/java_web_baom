<%--
  Created by IntelliJ IDEA.
  User: xtaod
  Date: 2023/12/17
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/stu/entry.do">我的报名信息</a><br/>
<a href="${pageContext.request.contextPath}/stu/photo.jsp">上传照片</a><br/>
<a href="${pageContext.request.contextPath}/stu/entry_print.jsp">报名表打印</a><br/>
<a href="${pageContext.request.contextPath}/stu/card_print.jsp">准考证打印</a><br/>
<a href="${pageContext.request.contextPath}/stu/grade.do">成绩与录取查询</a><br/>
<a href="${pageContext.request.contextPath}/record.do">我的登录历史</a><br/>
<a href="${pageContext.request.contextPath}/stu/pass.jsp">修改密码</a><br/>
<a href="${pageContext.request.contextPath}/logout.jsp">退出登录</a><br/>
</body>
</html>
