<%--
  Created by IntelliJ IDEA.
  User: yiu
  Date: 27/4/2023
  Time: 7:39 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.example.jsp_project.bean.Venue"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="com.example.jsp_project.bean.Order" %>
<html>
<head>
    <title>Report</title>
    <link rel="stylesheet" href="css/ManagerNav.css">
    <link rel="stylesheet" href="bootstrap-5.3.0/css/bootstrap.css">
</head>
<body>
<%
    String venueID = (String) request.getAttribute("venueID");

%>
<jsp:include page="component/ManagerNav.jsp"></jsp:include>
<jsp:include page="component/ReportNav.jsp"></jsp:include>
<div class="main_content">
    <h1>Booking Record</h1>
    <form class="container" method='post' action='showGraphController' >
        <input type="hidden" name="action" value="record">
        <select class="container form-select-lg mb-4 w-25 p-3" name="venueID" id="venueID">
            <option>Open this select menu</option>
            <%
                ArrayList<Venue> venues = (ArrayList<Venue>)request.getAttribute("venues");
                if(venues.size() != 0) {
                    for (int i = 0; i < venues.size(); i++) {
                        Venue v = (Venue) venues.get(i);
                        out.println("<option value='"+v.getVenueID()+"'>" + v.getVenueID() + "</option>");
                    }
                }
            %>

        </select>


        <button type="submit" class="btn btn-dark btn-lg">Enter</button>
    </form>
    <div class="container">
        <h1>Venue ID: <%=venueID != null ?venueID : ""%> </h1>
    </div>
    <% if(venueID !=null){%>
    <table class="table table-image">
        <thead>
        <tr class="h4">
            <th >Booking ID</th>
            <th >Member ID</th>
            <th >Fee</th>
            <th >Book Date</th>
            <th >Start Time</th>
            <th >End Time</th>
            <th >Hour</th>



        </tr>
        </thead>
        <tbody>
        <tr>
                <%
       ArrayList<Order> orders = (ArrayList<Order>)request.getAttribute("orders");
            if(orders.size() != 0){
                for(int i = 0; i < orders.size(); i++){
                    Order o = (Order)orders.get(i);
                    out.println("<tr>");
                    out.println("<td>"+o.getBookingID()+"</td>");
                    out.println("<td>"+o.getMemberID()+"</td>");
                    out.println("<td>$"+o.getBookingFee()+"</td>");
                    out.println("<td>"+o.getBookingDate()+"</td>");
                    out.println("<td>"+o.getStartTime()+"</td>");
                    out.println("<td>"+o.getEndTime()+"</td>");
                    out.println("<td>"+o.getHour()+"</td>");



                    out.println("</tr>");

                }
            }else{
                out.println("<td></td>");
                out.println("<td></td>");
                out.println("<td></td>");
                out.println("<td>No Information</td>");
                out.println("<td></td>");
                out.println("<td></td>");
                out.println("<td></td>");

            }
            }
        %>


        </tbody>
    </table>
</div>
</body>
</html>
