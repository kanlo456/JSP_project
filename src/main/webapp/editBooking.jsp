<%@ page import="com.example.jsp_project.bean.Guest" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.jsp_project.bean.Venue" %>
<%@ page import="java.util.Base64" %><%--
  Created by IntelliJ IDEA.
  User: kanlo
  Date: 26/4/2023
  Time: 10:16 PM
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

<jsp:include page="component/MemeberNav.jsp"/>
<jsp:useBean id="v" scope="request" class="com.example.jsp_project.bean.Venue"></jsp:useBean>

<div class="main_content">
    <div class="container-md m-5 p-2">
        <div class="row">
            <div class="col-12">
                <h1>Edit Booking </h1>
            </div>
                <div class="row">
                    <%
                        String id = v.getVenueID();
                        String name = v.getName();
                        byte[] image = v.getImage();
                        String type = v.getType();
                        String loc = v.getLocation();
                        String desc = v.getDescription();
                        String person = v.getPerson();
                        String capacity = v.getCapacity();
                        String fee = v.getBookingFee();
                        String state = v.getState();
                        String src = null;
                        String encode;
                        if (v.getImage() == null) {
                            src = "img/no_image.png";
                        } else if (v.getImage().length == 0) {
                            src = "img/no_image.png";
                        } else if (v.getImage() != null) {
                            encode = Base64.getEncoder().encodeToString(v.getImage());
                            src = "data:image/jpeg;base64," + encode;
                        }
                    %>
                    <div class="col-12 p-2">
                        <div class="card" style="width: 18rem; height: 40rem">
                            <img class="card-img-top h-50" alt="" src=<%=src%>>
                            <div class="card-body">
                                <h5 class="card-title"><%=name%>
                                </h5>
                                <p class="card-text">Type:<%=type%>
                                </p>
                                <p class="card-text">Capacity:<%=capacity%>
                                </p>
                                <p class="card-text">Location:<%=loc%>
                                </p>
                                <p class="card-text">Description:<%=desc%>
                                </p>
                                <p class="card-text">Person-in-charge:<%=person%>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="table-responsive-sm ">
                <% ArrayList<Guest> guests = (ArrayList<Guest>) request.getAttribute("guests");
                    String bookingID = (String) request.getAttribute("bookingID");
                %>
                <div><a class="btn btn-success" href="handleEditBooking?action=goEditGuest&bookingID=<%=bookingID%>">Add
                    Guest</a></div>
                <table class="table table-bordered">
                    <thead class="table-dark">
                    <tr>
                        <th>#</th>
                        <th>Booking ID</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Delete</th>
                        <th>Edit</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        for (int i = 0; i < guests.size(); i++) {
                            Guest guest = guests.get(i);
                    %>
                    <form action="handleEditBooking" method="post">
                        <input type="hidden" value="editGuest" name="action">
                        <input type="hidden" value="<%=guest.getGuestID()%>" name="guestID">
                        <tr>
                            <th scope="row"><%=i + 1%>
                            </th>
                            <td><input name="guestBkID" value="<%=bookingID%>"
                                       class="form-control bg-secondary text-white"/>
                            </td>
                            <td><input name="guestName" value="<%=guest.getGName()%>" class="form-control"/>
                            </td>
                            <td><input name="guestEmail" class="form-control" value="<%=guest.getEmail()%>"/>
                            </td>
                            <%--                        <td><%=order.getBookingDate()%>--%>
                            <%--                        </td>--%>
                            <td>
                                <%--                                <a class="text-decoration-none text-light"--%>
                                <%--                                   href="handleEditBooking?action=editGuest&bookingId=<%=guest.getBookingID()%>&guestID=<%=guest.getGuestID()%>">--%>
                                <button class="btn btn-success" type="submit">Edit</button>
                                <%--                                </a>--%>
                            </td>
                    </form>
                    <td>
                        <a class="text-decoration-none text-light"
                           href="handleEditBooking?action=delete&bookingId=<%=guest.getBookingID()%>&guestId=<%=guest.getGuestID()%>">
                            <button class="btn btn-danger">Delete</button>
                        </a>
                    </td>
                    </tr>
                    <%}%>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

</body>
</html>
