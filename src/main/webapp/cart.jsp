<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.jsp_project.bean.Cart" %>
<%@ page import="java.util.*" %>
<%@ page import="com.example.jsp_project.bean.Venue" %><%--
  Created by IntelliJ IDEA.
  User: kanlo
  Date: 22/4/2023
  Time: 4:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="bootstrap-5.3.0/css/bootstrap.css">
    <script rel="script" src="bootstrap-5.3.0/js/bootstrap.js"></script>
</head>
<body>
<jsp:include page="component/MemeberNav.jsp"/>
<%
    ArrayList<Cart> cartArrayList = (ArrayList<Cart>) request.getAttribute("cartList");
//    for (int i = 0; i < cartArrayList.size(); i++) {
//        Cart cart = cartArrayList.get(i);
////        out.println(cart.getName());
//        cart.getId();
//        cart.getName();
//    }
%>
<div class="container-md p-2">
    <div class="container">
        <div class="row">
            <%
                String src = null;
                String encode;
                for (int i = 0; i < cartArrayList.size(); i++) {
                    Cart cart = cartArrayList.get(i);
//        out.println(cart.getName());
                    if (cart.getImage() == null) {
                        src = "img/no_image.png";
                    } else if (cart.getImage().length == 0) {
                        src = "img/no_image.png";
                    } else if (cart.getImage() != null) {
                        encode = Base64.getEncoder().encodeToString(cart.getImage());
                        src = "data:image/jpeg;base64," + encode;
                    }
            %>
            <%--            <div class="card mb-3 d-flex h-25">--%>
            <%--                <img src="<%=src%>" class="card-img-top d-flex w-25" alt="...">--%>
            <%--                <div class="card-body">--%>
            <%--                    <h5 class="card-title"><%=cart.getName()%>--%>
            <%--                    </h5>--%>
            <%--                    <p class="card-text">Type:<%=cart.getType()%></p>--%>
            <%--                    <p class="card-text">Capacity: <%=cart.getCapacity()%></p>--%>
            <%--                    <p class="card-text">Location: <%=cart.getLocation()%></p>--%>
            <%--                    <p class="card-text">Description: <%=cart.getDescription()%></p>--%>
            <%--                    <p class="card-text">Person-in-charge: <%=cart.getPerson()%></p>--%>
            <%--                    <p class="card-text">BookingFee:$ <%=cart.getBookingFee()%></p>--%>
            <%--                    <p class="card-text"></p>--%>
            <%--                </div>--%>
            <%--            </div>--%>
            <div class="=col-12">
                <div class="card mb-3">
                    <div class="row g-0">
                        <div class="col-md-4">
                            <img src="<%=src%>" class="img-fluid rounded-start" alt="...">
                        </div>
                        <div class="col-md-8">
                            <div class="card-body">
                                <h5 class="card-title"><%=cart.getName()%>
                                </h5>
                                <p class="card-text">Type:<%=cart.getType()%>
                                </p>
                                <p class="card-text">Capacity: <%=cart.getCapacity()%>
                                </p>
                                <p class="card-text">Location: <%=cart.getLocation()%>
                                </p>
                                <p class="card-text">Description: <%=cart.getDescription()%>
                                </p>
                                <p class="card-text">Person-in-charge: <%=cart.getPerson()%>
                                </p>
                                <p class="card-text">BookingFee:$ <%=cart.getBookingFee()%>
                                </p>
                                <%--use jsp forloop loop select input 24 hour--%>



                                <label for="Start-time">Select your session: </label>
                                    <input class="form-control" id="Start-time" type="number" min="1" max="24" placeholder="Time">
                                    <input class="form-control" id="time" type="time" >
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <%}%>
        </div>
    </div>
</div>
</body>
</html>

<script>

</script>