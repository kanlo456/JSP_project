<%@ page import="com.example.jsp_project.bean.Guest" %>
<%@ page import="java.util.ArrayList" %><%--
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

<div class="main_content">
    <div class="container-md m-5 p-2">
        <div class="row">
            <div class="col-12">
                <h1>Edit Booking </h1>
                <div class="d-flex justify-content-end pb-2">
                    <div>
                        <%--                        <a href="editUser.jsp" class="text-decoration-none">--%>
                        <%--                            <button type="button" class="btn btn-primary">Add User</button>--%>
                        <%--                        </a>--%>
                        <%--                        <a href="handleRoleEdit?action=list">--%>
                        <%--                            <button type="button" class="btn btn-warning">Manage Role</button>--%>
                        <%--                        </a>--%>
                    </div>
                </div>
            </div>
            <div class="table-responsive-sm ">
                <% ArrayList<Guest> guests = (ArrayList<Guest>) request.getAttribute("guests");
//                    String bookingID = request.getAttribute("bookingID").toString();
                %>
                <div><a class="btn btn-success" href="handleEditBooking?action=goEditGuest&bookingID=<%=%>">Add
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
                            <td><input name="guestBkID" readonly value="<%=guest.getBookingID()%>"
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
