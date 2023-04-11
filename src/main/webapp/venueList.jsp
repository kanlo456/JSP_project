<%--
  Created by IntelliJ IDEA.
  User: yiu
  Date: 11/4/2023
  Time: 6:59 am
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.example.jsp_project.bean.Venue"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.ArrayList"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="StaffMenu.jsp" %>
<jsp:useBean id="venues" scope="request" class="ArrayList" />
<h1>Venue</h1>
</body>
</html>
