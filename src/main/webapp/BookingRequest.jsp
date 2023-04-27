<%--
  Created by IntelliJ IDEA.
  User: yiu
  Date: 28/4/2023
  Time: 2:44 am
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
    <div class="h1 ">Venue
        <a href="addVenue.jsp?action=add" class="btn btn-success" >Add</a></div></div>

<table class="table table-image">
    <thead>
    <tr class="h4">
        <th >ID</th>
        <th >Name</th>
        <th >Type</th>
        <th >Capacity</th>
        <th >Location</th>
        <th >Description</th>
        <th >Person-In-Charge</th>
        <th >Booking Fee</th>
        <th >State</th>
        <th  width="100px">Image</th>


    </tr>
    </thead>
    <tbody>
    <tr>
            <%
       ArrayList<Venue> venues = (ArrayList<Venue>)request.getAttribute("venues");
            if(venues.size() != 0){
                for(int i = 0; i < venues.size(); i++){
                    Venue v = (Venue)venues.get(i);
                    out.println("<tr>");
                    out.println("<td>"+v.getVenueID()+"</td>");
                    out.println("<td>"+v.getName()+"</td>");
                    out.println("<td>"+v.getType()+"</td>");
                    out.println("<td>"+v.getCapacity()+"</td>");
                    out.println("<td>"+v.getLocation()+"</td>");
                    out.println("<td>"+v.getDescription()+"</td>");
                    out.println("<td>"+v.getPerson()+"</td>");
                    out.println("<td>$"+v.getBookingFee()+"</td>");
                    out.println("<td>"+v.getState()+"</td>");
                    if(v.getImage() == null){
                         out.println("<td>"+ " <img src='img/no_image.png'   width= \"100\" height=\"100\" >"+"<td>");
                    }else{

                        String encode = Base64.getEncoder().encodeToString(v.getImage());
                        out.println("<td>"+ " <img src='data:image/jpeg;base64, "+ encode + " '   width= \"100\" height=\"100\" name=\"img\" >"+"<td>");
                    }
                    out.println("<td><a href='handleVenueEdit?action=getEdit&id="+v.getVenueID()+"' class=\"btn btn-outline-success\">Edit</a> " +
                     "<a href='handleVenueEdit?action=delete&id="+v.getVenueID()+"' class=\"btn btn-danger\">Delete</a></td>");

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
            }
        %>


    </tbody>
</table>
</body>
</html>
