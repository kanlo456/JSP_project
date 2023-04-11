<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: kanlo
  Date: 11/4/2023
  Time: 11:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.example.jsp_project.bean.User"%>
<html>
<head>
    <title>Account Management</title>
</head>
<body>
<jsp:include page="component/ManagerNav.jsp"></jsp:include>

<%
    ArrayList<User> users=(ArrayList<User>) request.getAttribute("users");
    out.print("<h1>Customer List<h1>");
    for (int i=0;i<users.size();i++){
        User user = users.get(i);
        out.print("<h1>"+user.getEmail()+"<h1>");
    }
%>
</body>
</html>
