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
  <jsp:useBean id="v" scope="request" class="com.example.jsp_project.bean.Venue" />
  <%
      String id = v.getId();
      String name = v.getName();
      String type = v.getType();
      String loc = v.getLocation();
      String desc = v.getDescription();
      String person = v.getPerson();
      int capacity = v.getCapacity();
      int fee = v.getBookingFee();


      String action = id != null ? "edit":"add";
//    String id = id != null ? id : null;
  %>
  <form class="container" method='get' action='handleVenueEdit' >

    <h1>Venue <%=action%></h1>
    <input type="hidden" name="id" value="<%=id%>">
    <input type="hidden" name="action" value="<%=action%>">
    <div class="row mb-4">
      <div class="col">
        <div class="form-outline">
          <label class="form-label" >Venue Name</label>
          <input type="text" name="venueName" value="<%=id != null ?name : ""%>" class="form-control" />

        </div>
      </div>
      <div class="col">
        <div class="form-outline">
          <label class="form-label" >Venue Type</label>
          <input type="text" name="venueType" value="<%= id != null ? type : "" %>" class="form-control" />
        </div>
      </div>
    </div>

    <!-- Image input -->
    <div class="row mb-4">
      <div class="col">
        <div class="form-outline">
      <label class="form-label" >Select image:</label><br>
<%--          <input type="file" name="img" value="<%=%>" name="img">--%>
        </div>
      </div>
      <div class="col">
        <div class="form-outline">
          <label class="form-label" >Capacity</label>
          <input type="number" name="capacity" value="<%= id != null ?capacity:"" %>" class="form-control" />
        </div>
      </div>
    </div>

    <div class="row mb-4">
      <div class="col">
        <div class="form-outline">
          <label class="form-label" >Person In Charge</label>
          <input type="text" name="person" value="<%=id != null ?person:""%>" class="form-control" />

        </div>
      </div>
      <div class="col">
        <div class="form-outline">
          <label class="form-label"  >Venue Fee</label>
          $<input type="number" name="fee" value="<%=id != null ?fee:""%>" class="form-control" />

        </div>
      </div>
    </div>
    <!-- Location input -->
    <div class="form-outline mb-4">
      <label class="form-label" >Location</label>
      <input type="text" name="location" value="<%=id != null ?loc:"" %>" class="form-control" />
    </div>



    <!-- Message input -->
    <div class="form-outline mb-4">
      <label class="form-label" >Description</label>
      <textarea class="form-control" name="desc" value="<%=id != null ?desc:""%>" rows="4"></textarea>

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
