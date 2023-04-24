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
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">
    <script
            src="https://code.jquery.com/jquery-3.6.4.js"
            integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E="
            crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="component/MemeberNav.jsp"/>
<%
    ArrayList<Cart> cartArrayList = (ArrayList<Cart>) request.getAttribute("cartList");
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
            <form>
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
                                    <p class="card-text">Select your session:</p>
                                    <label for="Start-time<%=i%>">Start Time:</label>
                                    <input id="Start-time<%=i%>" type="text" class="time" name="time" autocomplete="off"
                                    />
                                    <span><label for="End-time<%=i%>">End Time:</label>
                                    <input id="End-time<%=i%>"
                                           type="text"/>
                                </span>
                                    <br>
                                    <br>
                                    <label for="GuessNum<%=i%>">Input your guess number:</label>
                                    <input id="GuessNum<%=i%>" type="text" class="form-control"
                                           oninput="addGuessInputBox<%=i%>()"/>
                                    <script>
                                        function addGuessInputBox<%=i%>() {
                                            let guessNum = document.getElementById("GuessNum<%=i%>").value;
                                            let container = document.getElementById("container<%=i%>");
                                            container.innerHTML = "";
                                            for (let i = 0; i < guessNum; i++) {
                                                let GuessNum = document.createElement("label");
                                                let name = document.createElement("input");
                                                let email = document.createElement("input");
                                                GuessNum = document.createTextNode("Guess" + (i + 1));
                                                name.setAttribute("type", "text");
                                                name.setAttribute("class", "form-control");
                                                name.setAttribute("placeholder", "Name");
                                                email.setAttribute("type", "email");
                                                email.setAttribute("class", "form-control");
                                                email.setAttribute("placeholder", "Email");
                                                container.appendChild(GuessNum);
                                                container.appendChild(name);
                                                container.appendChild(email);
                                            }
                                        }
                                    </script>
                                    <div id="container<%=i%>"></div>
                                    <div id="price<%=i%>">Price:</div>
                                    <div class="d-flex justify-content-end">
                                        <a id="remove-cartList<%=i%>" class="btn btn-danger"
                                           href="handleRemoveCart?action=delete&id=<%=cart.getId()%>">Remove</a>
                                    </div>
                                    <script>
                                        $(document).ready(function () {
                                            $("#Start-time<%=i%>").timepicker({
                                                timeFormat: 'H:mm',
                                                interval: 60,
                                                // minTime: '10',
                                                // maxTime: '6:00pm',
                                                // defaultTime: '11',
                                                // startTime: '10:00',
                                                dynamic: false,
                                                dropdown: true,
                                                scrollbar: true,
                                                change: calTotalPrice<%=i%>
                                            });
                                            $('#End-time<%=i%>').timepicker({
                                                timeFormat: 'H:mm ',
                                                interval: 60,
                                                // minTime: '10',
                                                // maxTime: '6:00',
                                                // defaultTime: '11',
                                                startTime: '10:00',
                                                dynamic: false,
                                                dropdown: true,
                                                scrollbar: true,
                                                change: calTotalPrice<%=i%>
                                            });
                                        })
                                        function calTotalPrice<%=i%>() {
                                            console.log("changed!");
                                            const startTime = parseInt($("#Start-time<%=i%>").val());
                                            const endTime = parseInt($("#End-time<%=i%>").val());
                                            const hourPrice =
                                            <%=cart.getBookingFee()%>
                                            const totalPrice = (endTime - startTime) * hourPrice
                                            //set id price inner-html text to totalPrice
                                            $("#price<%=i%>").text("Price: $" + totalPrice);
                                        }
                                    </script>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <%}%>
                <div class="col-12">
                    <div class="card-body d-flex justify-content-between">
                        <a class="btn btn-danger disabled" role="button" aria-disabled="true">Cancel</a>
                        <a class="btn btn-primary disabled" role="button" aria-disabled="true">Next</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
<script src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>
<script rel="script" src="bootstrap-5.3.0/js/bootstrap.js"></script>
</html>
<script>

</script>