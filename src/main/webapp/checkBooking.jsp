<%@ page import="com.example.jsp_project.bean.Order" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: kanlo
  Date: 26/4/2023
  Time: 8:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Check Booking</title>
</head>
<body>
<jsp:include page="component/MemeberNav.jsp"></jsp:include>

<div class="main_content">
    <div class="container-md m-5 p-2">
        <div class="row">
            <div class="col-12">
                <h1>Account Management</h1>
                <div class="d-flex justify-content-end pb-2">
                    <div>
                        <a href="editUser.jsp" class="text-decoration-none">
                            <button type="button" class="btn btn-primary">Add User</button>
                        </a>
                        <a href="handleRoleEdit?action=list">
                            <button type="button" class="btn btn-warning">Manage Role</button>
                        </a>
                    </div>
                </div>
            </div>
            <div class="table-responsive-sm">
                <table class="table table-bordered">
                    <thead class="table-dark">
                    <tr>
                        <th>#</th>
                        <th>Booking ID</th>
                        <th>Venue ID</th>
                        <th>Fee</th>
                        <th>Booking Date</th>
                        <th>Start Time</th>
                        <th>End Time</th>
                        <th>Hour</th>
                        <th>Request State</th>
                        <th>Check State</th>
                        <th>Edit</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        ArrayList<Order> orders = (ArrayList<Order>) request.getAttribute("order");
                        for (int i = 0; i < orders.size(); i++) {
                            Order order = orders.get(i);

                    %>
                    <tr>
                        <th scope="row"><%=i + 1%>
                        </th>
                        <td><%=order.getBookingID()%>
                        </td>
                        <td><%=order.getVenueID()%>
                        </td>
                        <td><%=order.getTotalFee()%>
                        </td>
                        <td><%=order.getBookingDate()%>
                        </td>
                        <td><%=order.getStartTime()%>
                        </td>
                        <td><%=order.getEndTime()%>
                        </td>
                        <td><%=order.getHour()%>
                        </td>
                        <td><%=order.getRqState()%>
                        </td>
                        <td>
                            <a class="text-decoration-none text-light"
                               href="handleUserEdit?action=delete&id=<%=order.getBookingID()%>">
                                <button class="btn btn-danger">Delete</button>
                            </a>
                        </td>
                        <td>
                            <a class="text-decoration-none text-light"
                               href="handleUserEdit?action=getEditUser&id=<%=order.getBookingID()%>">
                                <button class="btn btn-success">Edit</button>
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
