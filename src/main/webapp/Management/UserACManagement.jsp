<%--
  Created by IntelliJ IDEA.
  User: kanlo
  Date: 10/4/2023
  Time: 11:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% if (session.getAttribute("username") == null) {
    response.sendRedirect("login.jsp");
}%>
User AC Management Page
Welcome ${username}
</body>
</html>
