<%@ page import="com.example.jsp_project.bean.User" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: yiu
  Date: 27/4/2023
  Time: 1:24 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Report</title>
    <link rel="stylesheet" href="css/report.css">
    <link rel="stylesheet" href="css/ManagerNav.css">
    <link rel="stylesheet" href="bootstrap-5.3.0/css/bootstrap.css">
</head>
<body>
<jsp:include page="component/ManagerNav.jsp"></jsp:include>
<jsp:include page="component/ReportNav.jsp"></jsp:include>
<div class="main_content">

    <form class="container" method='post' action='showGraphController' >
        <input type="hidden" name="action" value="showUser">
        <select class="container form-select-lg mb-4 w-25 p-3" name="venueID" id="venueID">
            <option>Open this select menu</option>
            <%
                ArrayList<User> users = (ArrayList<User>)request.getAttribute("users");
                if(users.size() != 0) {
                    for (int i = 0; i < users.size(); i++) {
                        User u = (User) users.get(i);
                        out.println("<option value='"+u.getId()+"'>" + u.getId() + "</option>");
                    }
                }
            %>

        </select>

        <select class="container form-select-lg mb-4 w-25 p-3"  name="dateType">
            <option value="Monthly">Monthly</option>
            <option value="Yearly">Yearly</option>
        </select>
        <button type="submit" class="btn btn-dark btn-lg">Enter</button>
    </form>
</div>
</body>
</html>
