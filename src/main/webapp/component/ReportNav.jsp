<%--
  Created by IntelliJ IDEA.
  User: yiu
  Date: 26/4/2023
  Time: 10:14 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="main_content">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="">

            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-md-auto gap-2">
                    <li class="nav-item rounded">
                        <a class="nav-link active" aria-current="page" href="showGraphController?action=record"><i class="bi bi-house-fill me-2"></i>Booking Record</a>
                    </li>
                    <li class="nav-item rounded">
                        <a class="nav-link active" aria-current="page" href="showGraphController?action=list"><i class="bi bi-house-fill me-2"></i>Venue</a>
                    </li>
                    <li class="nav-item rounded">
                        <a class="nav-link active" aria-current="page" href="StaffHome.jsp"><i class="bi bi-house-fill me-2"></i>User</a>
                    </li>




                </ul>
            </div>
        </div>
    </nav><br>&nbsp;

<%--    <select class="container form-select-lg mb-4 w-25 p-3" aria-label="Default select ">--%>
<%--        <option selected>Open this select menu</option>--%>
<%--        <%--%>
<%--            ArrayList<Venue> venues = (ArrayList<Venue>)request.getAttribute("venues");--%>
<%--            if(venues.size() != 0){--%>
<%--                for(int i = 0; i < venues.size(); i++){--%>
<%--                    Venue v = (Venue)venues.get(i);--%>
<%--                    out.println("<option value='\"+v.getVenueID()+\"'>"+v.getVenueID()+"</option>");--%>
<%--        %>--%>

<%--    </select>--%>
<%--    <a class="btn btn-dark btn-lg" href="#" role="button">Enter</a>--%>
</div>
</body>
</html>
