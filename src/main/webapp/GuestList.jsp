<%@ page import="com.example.jsp_project.bean.Guest" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: yiu
  Date: 28/4/2023
  Time: 3:23 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="component/StaffMenu.jsp"></jsp:include>
<div class="col">
    <%
        String check = (String) request.getAttribute("check");
        String bookingID = (String) request.getAttribute("bookingID"); %>
    <div class="h1 ">Guest List Booking ID: <%=bookingID%>
    </div></div>

<table class="table table-image">
    <thead>
    <tr class="h4">
        <th >Guest ID</th>
        <th >Name</th>
        <th >Email</th>



    </tr>
    </thead>
    <tbody>
    <tr>
            <%
       ArrayList<Guest> guests = (ArrayList<Guest>)request.getAttribute("guests");
            if(guests.size() != 0){
                for(int i = 0; i < guests.size(); i++){
                    Guest g = (Guest)guests.get(i);
                    out.println("<tr>");
                    out.println("<td>"+g.getGuestID()+"</td>");
                    out.println("<td>"+g.getGName()+"</td>");
                    out.println("<td>"+g.getEmail()+"</td>");


                    out.println("</tr>");

                }
            }else{
                out.println("<td></td>");
                out.println("<td>No Information</td>");
                out.println("<td></td>");


            }
        %>


    </tbody>
</table>
<div class="container">
    <% if(check =="check"){ %>
    <a href="checkStateController?action=list" class="btn btn-danger btn-lg" >Cancel</a>
<% }else {%>
<a href="showBookingRequestController?action=list" class="btn btn-danger btn-lg" >Cancel</a>
    <%} %>
</div>
</body>
</html>
