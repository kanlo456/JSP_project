<%@ page import="com.example.jsp_project.bean.User" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.LocalDate" %><%--
  Created by IntelliJ IDEA.
  User: kanlo
  Date: 11/4/2023
  Time: 6:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<%
    User user = (User)session.getAttribute("userInfo");
    if(user == null){
        RequestDispatcher rd;
        rd = request.getServletContext().getRequestDispatcher("/login.jsp" );
        rd.forward(request,response);
    }


%>
<jsp:useBean id="userInfo" class="com.example.jsp_project.bean.User" scope="session" />
<% assert user != null; %>
<%--<%@ include file="StaffMenu.jsp" %>--%>
<jsp:include page="component/StaffMenu.jsp"></jsp:include>
<%--<nav class="navbar navbar-expand-lg navbar-dark bg-dark">--%>
<%--    <div class="container-fluid">--%>
<%--        <a class="navbar-brand" href="#"></a>--%>
<%--        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">--%>
<%--            <span class="navbar-toggler-icon"></span>--%>
<%--        </button>--%>
<%--        <div class="collapse navbar-collapse" id="navbarNav">--%>
<%--            <ul class="navbar-nav ms-md-auto gap-2">--%>
<%--                <li class="nav-item rounded">--%>
<%--                    <a class="nav-link active" aria-current="page" href="#"><i class="bi bi-house-fill me-2"></i>Home</a>--%>
<%--                </li>--%>

<%--                <li class="nav-item dropdown rounded">--%>
<%--                    <a class="nav-link dropdown-toggle" href="#" id="navbar1" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="bi bi-person-fill me-2"></i>Function</a>--%>
<%--                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">--%>
<%--                        <li><a class="dropdown-item" href="#">Venue Detail</a></li>--%>

<%--                        <li><a class="dropdown-item" href="#">Booking Request</a></li>--%>
<%--                    </ul>--%>
<%--                </li>--%>
<%--                <li class="nav-item dropdown rounded">--%>
<%--                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="bi bi-person-fill me-2"></i>Account</a>--%>
<%--                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">--%>
<%--&lt;%&ndash;                        <li><a class="dropdown-item" href="#">Account</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <li><a class="dropdown-item" href="#">Another action</a></li>&ndash;%&gt;--%>
<%--                        <li>--%>
<%--                            <hr class="dropdown-divider">--%>
<%--                        </li>--%>
<%--                        <li><a class="dropdown-item" href="login.jsp">Logout</a></li>--%>
<%--                    </ul>--%>
<%--                </li>--%>
<%--            </ul>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</nav>--%>

<div class="container">
    <div class="card mt-5 border-5 pt-2 active pb-0 px-3">
        <div class="card-body ">
            <div class="row">
                <div class="col-12 ">
                    <h4 class="card-title "><b>Staff - <%= user.getUsername()%></b></h4>

                </div>
                <div class="col">
                    <h6 class="card-subtitle mb-2 text-muted">
                        <p class="card-text text-muted small ">
                            Staff ID :
                            <span class="vl mr-2 ml-0">|</span>
                                <% DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");%>

                            <span class="font-weight-bold"><%= LocalDate.now().format(formatter)%></span>


                    </h6>
                </div>
            </div>

        </div>

        <div class="card-footer bg-white  ">
            <div class="row">
                <div class="col-12 ">
            <h4 >Function</h4>
                    <br>
                </div>
                <div class=" col-md-auto ">
                    <a href="showVenueController?action=list" class="btn btn-outlined btn-black text-muted bg-transparent"
                       data-wow-delay="0.7s">
                        <img src="img/location_icon.png" width="19" height="19">
                        Venue Information
                    </a>

                    <i class="mdi mdi-settings-outline"></i>



                    <a href="#" class="btn
                         btn-outlined btn-black text-muted"><img src="img/booking_icon.png"
                                                                 width="20" height="20" id="plus">
                        Booking Request(Confirm/ Decline) </a>



                    <span class="vl ml-3"></span>
                    <i class="mdi mdi-settings-outline"></i>



                    <a href="#" class="btn
                         btn-outlined btn-black text-muted"><img src="img/record_icon.png"
                                                                 width="20" height="20" >
                        Booking Record(Check-in / Check-out) </a>



                    <span class="vl ml-3"></span>
                </div>



            </div>
        </div>
    </div>
</div>

</body>
</html>
