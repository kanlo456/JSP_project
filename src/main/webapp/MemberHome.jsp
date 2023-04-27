<%@ page import="com.example.jsp_project.bean.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.jsp_project.bean.Venue" %>
<%@ page import="java.util.Base64" %><%--
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
    <link rel="stylesheet" href="bootstrap-5.3.0/css/bootstrap.css">
    <script rel="script" src="bootstrap-5.3.0/js/bootstrap.js"></script>
</head>
<body>
<%
    User user = (User) session.getAttribute("userInfo");
    if (user == null) {
        RequestDispatcher rd;
        rd = request.getServletContext().getRequestDispatcher("/login.jsp");
        rd.forward(request, response);
    }
    int reminderNum = (int) request.getAttribute("bookingReminderNum");

%>

<jsp:include page="component/MemeberNav.jsp">
    <jsp:param name="reminderNum" value="<%=reminderNum%>"/>
</jsp:include>

<div class="container p-2">
    <div class="row row-cols-3">
        <%
            ArrayList<Venue> venues = (ArrayList<Venue>) request.getAttribute("venues");
            String src = null;
            String encode;
            for (int i = 0; i < venues.size(); i++) {
                Venue v = (Venue) venues.get(i);
                if (v.getImage() == null) {
                    src = "img/no_image.png";
                } else if (v.getImage().length == 0) {
                    src = "img/no_image.png";
                } else if (v.getImage() != null) {
                    encode = Base64.getEncoder().encodeToString(v.getImage());
                    src = "data:image/jpeg;base64," + encode;
                }
        %>
        <div class="col-4 p-2">
            <div class="card" style="width: 18rem; height: 40rem">
                <img class="card-img-top h-50" alt="" src=<%=src%>>
                <div class="card-body">
                    <h5 class="card-title"><%=v.getName()%>
                    </h5>
                    <p class="card-text">Type:<%=v.getType()%></p>
                    <p class="card-text">Capacity:<%=v.getCapacity()%></p>
                    <p class="card-text">Location:<%=v.getLocation()%></p>
                    <p class="card-text">Description:<%=v.getDescription()%></p>
                    <p class="card-text">Person-in-charge:<%=v.getPerson()%></p>
                    <p class="card-text">BookingFee:<%=v.getBookingFee()%></p>
                    <a href="add-to-cart?id=<%=v.getVenueID()%>" class="btn btn-primary">Add to cart</a>
                </div>
            </div>
        </div>
        <%}%>
    </div>
</div>
</body>
</html>
