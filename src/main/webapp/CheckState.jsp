<%@ page import="com.example.jsp_project.bean.Order" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: yiu
  Date: 28/4/2023
  Time: 4:36 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="component/StaffMenu.jsp"></jsp:include>
</head>
<body>
<div class="col">
    <div class="h1 ">Booking Check In/Out
    </div></div>

<table class="table table-image">
    <thead>
    <tr class="h4">
        <th >Book ID</th>
        <th >Venue ID</th>
        <th >Member</th>
        <th >Fee</th>
        <th >Book Date</th>
        <th >Start Time</th>
        <th >End Time</th>
        <th >Hour</th>
        <th >Check State</th>
        <th ></th>
        <th>Guest List</th>


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
                    out.println("<td>"+o.getVenueID()+"</td>");
                    out.println("<td>"+o.getMemberID()+"</td>");
                    out.println("<td>"+o.getTotalFee()+"</td>");
                    out.println("<td>"+o.getBookingDate()+"</td>");
                    out.println("<td>"+o.getStartTime()+"</td>");
                    out.println("<td>"+o.getEndTime()+"</td>");
                    out.println("<td>"+o.getHour()+"</td>");
                    out.println("<form  method='post' action='checkStateController' >");
                    out.println("<input type=\"hidden\" name=\"id\" value="+o.getBookingID()+">");
                    out.println("<input type=\"hidden\" name=\"action\" value='changeState'>");
                    out.println("<td><select name=\"checkState\" id=\"state\" class=\"form-control\">");
                   if(o.getCheckState().equals("waiting")){
                        out.println("<option value='waiting' selected>waiting</option>");
                        out.println("<option value='check-in' >check-in</option>");
                        out.println("<option value='check-out' >check-out</option>");
                        out.println("</select></td>");

                   }else if(o.getCheckState().equals("check-in")){
                       out.println("<option value='processing' >processing</option>");
                        out.println("<option value='check-in' selected >check-in</option>");
                        out.println("<option value='check-out' >check-out</option>");
                        out.println("</select></td>");

                   }else if(o.getCheckState().equals("check-out")){
                       out.println("<option value='processing' >processing</option>");
                        out.println("<option value='confirm' >confirm</option>");
                        out.println("<option value='check-out' selected >check-out</option>");
                        out.println("</select></td>");
//                        out.println("<td><a href='showBookingRequestController?action=changeState&requestState=decline&id="+o.getBookingID()+"' class=\"btn btn-primary btn-block mb-4\">...</a><td>");
                   }
                   out.println("<td><button type=\"submit\" class=\"btn btn-primary btn-block mb-4\">Submit</button></td>");
                    out.println("</form>");
                    out.println("<td><a href='checkStateController?action=guestList&id="+o.getBookingID()+"' class=\"btn btn-outline-success\">...</a><td>");

                    out.println("</tr>");

                }
            }else{
                out.println("<td></td>");
                out.println("<td></td>");
                out.println("<td></td>");
                out.println("<td></td>");
                out.println("<td>No Information</td>");
                out.println("<td></td>");
                out.println("<td></td>");
                out.println("<td></td>");
                out.println("<td></td>");
                out.println("<td></td>");
            }
        %>


    </tbody>
</table>
</body>
</html>
