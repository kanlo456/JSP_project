<%@ page import="com.example.jsp_project.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: yiu
  Date: 11/4/2023
  Time: 12:55 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="../css/StaffMenu.css">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#"></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav ms-md-auto gap-2">
        <li class="nav-item rounded">
          <a class="nav-link active" aria-current="page" href="StaffHome.jsp"><i class="bi bi-house-fill me-2"></i>Home</a>
        </li>

        <li class="nav-item dropdown rounded">
          <a class="nav-link dropdown-toggle" href="#" id="navbar1" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="bi bi-person-fill me-2"></i>Function</a>
          <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="showVenueController?action=list">Venue Detail</a></li>

            <li><a class="dropdown-item" href="showBookingRequestController?action=list">Booking Request</a></li>
            <li><a class="dropdown-item" href="checkStateController?action=list">Booking Record</a></li>
          </ul>
        </li>
        <li class="nav-item dropdown rounded">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="bi bi-person-fill me-2"></i>Account</a>
          <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
            <%--                        <li><a class="dropdown-item" href="#">Account</a></li>--%>
            <%--                        <li><a class="dropdown-item" href="#">Another action</a></li>--%>
            <li>
              <hr class="dropdown-divider">
            </li>
            <li><a class="dropdown-item" href=""><form action="login" method="post">
              <input type="hidden" name="action" value="logout">
              <button type="submit"  name="logout">Log Out</button>
            </form></a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>
</body>
</html>
