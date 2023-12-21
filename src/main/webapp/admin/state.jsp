<%--
  Created by IntelliJ IDEA.
  User: xtaod
  Date: 2023/12/20
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    ServletContext context= session.getServletContext();
    Integer count = (Integer) context.getAttribute("count");
%>
<p>当前在线人数共 <%=count %> 人</p>
</body>
</html>
