<%--
  Created by IntelliJ IDEA.
  User: kanlo
  Date: 27/4/2023
  Time: 12:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
    String bookingID = request.getAttribute("bookingId").toString();
%>

<div>
    <div class="container-md p-2">
        <form method="get" action="handleEditBooking">
            <label for="guestName">Guest Name: <%=bookingID%></label>
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
