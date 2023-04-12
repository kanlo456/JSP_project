<%--
  Created by IntelliJ IDEA.
  User: yiu
  Date: 11/4/2023
  Time: 6:59 am
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.example.jsp_project.bean.Venue"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.ArrayList"%>
<%@ page import="com.example.jsp_project.db.VenueDB" %>
<%@ page import="java.util.Base64" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<%--<%@ include file="StaffMenu.jsp" %>--%>
<jsp:include page="component/StaffMenu.jsp"></jsp:include>

<div class="col">
    <div class="h1 ">Venue
        <a href="addVenue.jsp?action=add" class="btn btn-success" >Add</a></div></div>

<table class="table table-image">
    <thead>
    <tr class="h4">
        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">Type</th>
        <th scope="col">Capacity</th>
        <th scope="col">Location</th>
        <th scope="col">Description</th>
        <th scope="col">Person-In-Charge</th>
        <th scope="col">Booking Fee</th>
        <th scope="col">Image</th>
        <th scope="col">Edit / Delete</th>
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
                    out.println("<td>"+v.getId()+"</td>");
                    out.println("<td>"+v.getName()+"</td>");
                    out.println("<td>"+v.getType()+"</td>");
                    out.println("<td>"+v.getCapacity()+"</td>");
                    out.println("<td>"+v.getLocation()+"</td>");
                    out.println("<td>"+v.getDescription()+"</td>");
                    out.println("<td>"+v.getPerson()+"</td>");
                    out.println("<td>$"+v.getBookingFee()+"</td>");
                    out.println("<td></td>");

//                    if(v.getImgs() == null){
//                        out.println("<td>--</td>");
////                        out.println("<div class='table-data'>"+ " <img src='img/user.jpg'   width= \"100\" height=\"100\" >"+"</div>");
//                    }else{
//                        String encode = Base64.getEncoder().encodeToString(v.getImgs());
//                        out.println("<td>"+ " <img src='data:image/jpeg;base64, "+ encode + " '   width= \"100\" height=\"100\" >"+"<td>");
//                    }
                    out.println("<td><a href='handleVenueEdit?action=edit&id="+v.getId()+"' class=\"btn btn-outline-success\">Edit</a>  " +
                     "&nbsp;<a href='handleVenueEdit?action=delete&id="+v.getId()+"' class=\"btn btn-danger\">Delete</a></td>");

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
