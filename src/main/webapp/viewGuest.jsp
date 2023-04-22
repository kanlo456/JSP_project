<%@ page import="com.example.jsp_project.bean.Guest" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: yiu
  Date: 23/4/2023
  Time: 5:42 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="component/StaffMenu.jsp"></jsp:include>
<%ArrayList<Guest> guests = (ArrayList<Guest>)request.getAttribute("guests"); %>
<div class="col container ">
<div class="h1">Guest List</div>
    <div class="h2">Booking ID : <%=guests.get(1).getBookingID()%></div>

<table class="table ">
    <thead>
    <tr class="h4">
        <th >GuestID</th>
        <th >Name</th>
        <th >Email</th>


    </tr>
    </thead>
    <tbody>

<%
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
                out.println("<td></td>");
                out.println("<td>No Information</td>");
                out.println("<td></td>");

            }
        %>
    </tbody>
</table>
</div>
</body>
</html>
