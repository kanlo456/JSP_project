<%@ page import="java.util.Base64" %><%--
  Created by IntelliJ IDEA.
  User: yiu
  Date: 9/4/2023
  Time: 11:41 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>

  </head>
  <body>
  <jsp:include page="component/StaffMenu.jsp"></jsp:include>
  <jsp:useBean id="v" scope="page" class="com.example.jsp_project.bean.Venue" />
  <%
      String id = String.valueOf(v.getId());
      String name = v.getName();
      String type = v.getType();
      String loc = v.getLocation();
      String desc = v.getDescription();
      String person = v.getPerson();
      int capacity = v.getCapacity();
      int fee = v.getBookingFee();

      String action = id != null ? "edit":"add";
//    String id = id != null ? id : null;
    if(id != null && action.equals("edit")){

    }else {
  %>
  <form class="container" method='get' action='handleVenueEdit' >

    <h1>Add Venue</h1>
    <input type="hidden" name="action" value="add">
    <div class="row mb-4">
      <div class="col">
        <div class="form-outline">
          <label class="form-label" for="venueName">Venue Name</label>
          <input type="text" name="venueName" class="form-control" />

        </div>
      </div>
      <div class="col">
        <div class="form-outline">
          <label class="form-label" for="venueType">Venue Type</label>
          <input type="text" name="venueType" class="form-control" />
<%--          <select class="form-select" aria-label="Default select example">--%>
<%--            <option selected disabled>--</option>--%>
<%--            <option value="Convention centers" >Convention centers</option>--%>
<%--            <option value="Conference centers">Conference centers</option>--%>
<%--            <option value="Restaurants">Restaurants</option>--%>
<%--            <option value="Community centers">Community centers</option>--%>
<%--            <option value="Stadiums">Stadiums</option>--%>
<%--          </select>--%>

        </div>
      </div>
    </div>

    <!-- Image input -->
    <div class="row mb-4">
      <div class="col">
        <div class="form-outline">
      <label class="form-label" for="img">Select image:</label><br>
          <input type="file" id="img" name="img">
        </div>
      </div>
      <div class="col">
        <div class="form-outline">
          <label class="form-label" for="capacity">Capacity</label>
          <input type="number" name="capacity" class="form-control" />
        </div>
      </div>
    </div>

    <div class="row mb-4">
      <div class="col">
        <div class="form-outline">
          <label class="form-label" for="person">Person In Charge</label>
          <input type="text" name="person" class="form-control" />

        </div>
      </div>
      <div class="col">
        <div class="form-outline">
          <label class="form-label" for="fee" >Venue Fee</label>
          $<input type="number" name="fee" class="form-control" />

        </div>
      </div>
    </div>
    <!-- Location input -->
    <div class="form-outline mb-4">
      <label class="form-label" for="location">Location</label>
      <input type="text" name="location" class="form-control" />
    </div>



    <!-- Message input -->
    <div class="form-outline mb-4">
      <label class="form-label" for="desc">Description</label>
      <textarea class="form-control" name="desc" rows="4"></textarea>

    </div>

    <!-- Submit button -->
    <div class="d-grid gap-2">
    <button type="submit" class="btn btn-primary btn-block mb-4">Submit</button>
    </div>
  </form>
<%--  <%--%>
<%--    }--%>
<%--  %>--%>
  </body>
</html>
