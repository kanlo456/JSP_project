<%--
  Created by IntelliJ IDEA.
  User: kanlo
  Date: 11/4/2023
  Time: 6:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/ManagerNav.css">
    <link rel="stylesheet" href="bootstrap-5.3.0/css/bootstrap.css">
</head>
<body>
    <main class="d-flex flex-nowrap">
        <jsp:include page="component/ManagerNav.jsp"></jsp:include>
        <jsp:include page="component/MainContent.jsp"></jsp:include>
        <li><a href="report.jsp"><i class="fas fa-address-card"></i>Report</a></li>
    </main>
</body>
</html>

<script src="js/ManagerNav.js"></script>