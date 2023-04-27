<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.jsp_project.bean.Guest" %><%--
  Created by IntelliJ IDEA.
  User: kanlo
  Date: 26/4/2023
  Time: 5:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Guest</title>
    <link rel="stylesheet" href="bootstrap-5.3.0/css/bootstrap.css">
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">
    <script
            src="https://code.jquery.com/jquery-3.6.4.js"
            integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E="
            crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="component/MemeberNav.jsp"></jsp:include>

<%
    ArrayList<Guest> guestArrayList = (ArrayList<Guest>) session.getAttribute("guest-list");
//    String message = (String) request.getAttribute("alertMsg");
%>
<div>
    <div class="container-md p-2">
        <h1>Added Guest</h1>
        <%
            if (guestArrayList != null) {
                for (Guest g : guestArrayList) {
        %>
        <form method="get" action="handleCheckoutGuestEdit">
            <label for="cartGuestName">Guest Name: </label>
            <input value="editGuest" name="action" type="hidden">
            <input value="<%=g.getEmail()%>" name="replaceGuestEmail" type="hidden">
            <input id="cartGuestName" name="guestName" type="text" class="form-control" value="<%=g.getGName()%>">
            <input hidden="hidden" name="action" value="addGuest">
            <label for="cartGuestEmail">Guest Email: </label>
            <input id="cartGuestEmail" name="guestEmail" type="email" value="<%=g.getEmail()%>" class="form-control">
            <div class="d-flex justify-content-end">
                <button type="submit" class="btn btn-success ">Edit</button>
                <a class="btn btn-danger" href="handleCheckoutGuestEdit?action=delete&guestEmail=<%=g.getEmail()%>">Delete</a>
            </div>
        </form>
        <% }
        }
        %>
        <h1>Add Guest</h1>
        <form method="get" action="add-guest">
            <label for="guestName">Guest Name: </label>
            <input id="guestName" name="guestName" type="text" class="form-control">
            <input hidden="hidden" name="action" value="addGuest">
            <label for="guestEmail">Guest Email: </label>
            <input id="guestEmail" name="guestEmail" type="email" class="form-control">
            <div class="d-flex justify-content-end">
                <button type="submit" class="btn btn-success ">Add Guest</button>
            </div>
        </form>
    </div>
</div>

</body>
</html>