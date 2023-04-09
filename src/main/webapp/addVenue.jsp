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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
  </head>
  <body>
  <jsp:useBean id="venue" scope="page" class="com.example.jsp_project.bean.Venue" />
  <%
    String type = venue.getId() != null ? "edit":"create";
    String id = venue.getId() != null ? venue.getId() : null;
    if(id != null && type.equals("edit")){
      out.println("  <form class=\"container\" method='post' action='CreateVenueController' enctype='multipart/form-data'>");
      out.println("<h1>Edit Venue</h1>");
      out.println("<input type='hidden' name='id' value='"+venue.getId()+"'>");
      out.println("<input type='hidden' name='action' value='edit'>");

      out.println("<div class=\"row mb-4\">");
      out.println("<div class=\"col\">");
      out.println("<div class=\"form-outline\">");
      out.println("<label class=\"form-label\" for=\"venueName\">Venue Name</label>");
      out.println("<input type=\"text\" id=\"venueName\" class=\"form-control\" value='"+venue.getName()+"' />");
      out.println("</div></div>");

      out.println("<div class=\"col\">");
      out.println("<div class=\"form-outline\">");
      out.println("<label class=\"form-label\" >Venue Type</label>");
      out.println("<input type=\"text\" id=\"venueType\" class=\"form-control\" value='"+venue.getType()+"'/>");
      out.println("</div></div></div>");

      out.println("<div class=\"row mb-4\">");
      out.println("<div class=\"col\">");
      out.println("<div class=\"form-outline\">");

      if(venue.getImgs() == null ){
        out.println("<label class=\"form-label\" for=\"img\">Select image:</label><br>");
        out.println("<input type=\"file\" id=\"img\" name=\"img\">");

      }else {
        String encode = Base64.getEncoder().encodeToString(venue.getImgs());
        out.println("<label class=\"form-label\" for=\"img\">Select image:</label>");
        out.println(" <span class=\"details\"> <img src='data:image/jpeg;base64, "+ encode + " '   width= \"100\" height=\"100\" >");
      }
      out.println("</div></div>");

      out.println("<div class=\"col\"> <div class=\"form-outline\">");
      out.println("<label class=\"form-label\" for=\"Capacity\">Capacity</label>");
      out.println("<input type=\"number\" id=\"Capacity\" class=\"form-control\" value='"+venue.getCapacity()+"' />");
      out.println("</div></div></div>");

      out.println("<div class=\"form-outline mb-4\">");
      out.println("<label class=\"form-label\" for=\"Location\">Location</label>");
      out.println("<input type=\"text\" id=\"Location\" class=\"form-control\" value='"+venue.getLocation()+"'/>");
      out.println("</div>");

      out.println("<div class=\"form-outline mb-4\">");
      out.println("<label class=\"form-label\" for=\"form6Example7\">Description</label>");
      out.println("<textarea class=\"form-control\" id=\"form6Example7\" rows=\"4\" value='"+venue.getDescription()+"'></textarea>");

      out.println("<div class=\"d-grid gap-2\">");
      out.println(" <button type=\"submit\" class=\"btn btn-primary btn-block mb-4\">Submit</button>");
      out.println("</div>");
      out.println("</form>");
    }else {
  %>
  <form class="container" method='post' action='CreateVenueController' enctype='multipart/form-data'>

    <h1>Add Venue</h1>
    <div class="row mb-4">
      <div class="col">
        <div class="form-outline">
          <label class="form-label" for="venueName">Venue Name</label>
          <input type="text" id="venueName" class="form-control" />

        </div>
      </div>
      <div class="col">
        <div class="form-outline">
          <label class="form-label" >Venue Type</label>
          <select class="form-select" aria-label="Default select example">
            <option selected disabled>--</option>
            <option value="Convention centers" >Convention centers</option>
            <option value="Conference centers">Conference centers</option>
            <option value="Restaurants">Restaurants</option>
            <option value="Community centers">Community centers</option>
            <option value="Stadiums">Stadiums</option>
          </select>

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
          <label class="form-label" for="Capacity">Capacity</label>
          <input type="number" id="Capacity" class="form-control" />
        </div>
      </div>
    </div>

    <div class="row mb-4">
      <div class="col">
        <div class="form-outline">
          <label class="form-label" for="person">Person In Charge</label>
          <input type="text" id="person" class="form-control" />

        </div>
      </div>
      <div class="col">
        <div class="form-outline">
          <label class="form-label" for="Fee" >Venue Fee</label>
          $<input type="number" id="Fee" class="form-control" />

        </div>
      </div>
    </div>
    <!-- Location input -->
    <div class="form-outline mb-4">
      <label class="form-label" for="Location">Location</label>
      <input type="text" id="Location" class="form-control" />
    </div>



    <!-- Message input -->
    <div class="form-outline mb-4">
      <label class="form-label" for="form6Example7">Description</label>
      <textarea class="form-control" id="form6Example7" rows="4"></textarea>

    </div>

    <!-- Submit button -->
    <div class="d-grid gap-2">
    <button type="submit" class="btn btn-primary btn-block mb-4">Submit</button>
    </div>
  </form>
  <%
    }
  %>
  </body>
</html>
