<%@ page import="com.example.jsp_project.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: kanlo
  Date: 11/4/2023
  Time: 6:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    User user = (User)session.getAttribute("userInfo");
    if(user == null){
        RequestDispatcher rd;
        rd = request.getServletContext().getRequestDispatcher("/login.jsp" );
        rd.forward(request,response);
    }


%>
<jsp:useBean id="userInfo" class="com.example.jsp_project.bean.User" scope="session" />
Member Home
Function
Booking
<a href="">Book Venue</a>
<a href="">Booking Record</a>
<a href=""></a>
<a href=""></a>
</body>
</html>
