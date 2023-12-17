<%--
  Created by IntelliJ IDEA.
  User: xtaod
  Date: 2023/12/17
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>退出系统</title>
</head>
<body>
<%
    session.invalidate();
    request.setAttribute("stuLoginMess", "* 你已退出登录！");
    request.getRequestDispatcher("/index.jsp").forward(request, response);
%>
</body>
</html>
