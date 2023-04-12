<%--
  Created by IntelliJ IDEA.
  User: kanlo
  Date: 13/4/2023
  Time: 2:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EditUser</title>
    <link rel="stylesheet" href="css/ManagerNav.css">
    <link rel="stylesheet" href="bootstrap-5.3.0/css/bootstrap.css">
</head>
<body>
<jsp:include page="component/ManagerNav.jsp"></jsp:include>

<jsp:useBean id="u" scope="request" class="com.example.jsp_project.bean.User"/>

<%
    String id = u.getId() != null ? u.getId() : "";
    String username = u.getUsername() != null ? u.getUsername() : "";
    String password = u.getPassword() != null ? u.getPassword() : "";
    String email = u.getEmail() != null ? u.getEmail() : "";
    String phoneNumber = u.getPhoneNumber() != null ? u.getPhoneNumber() : "";
    String role = u.getRole() != null ? u.getRole() : "";
%>

<div class="main_content">
    <div class="container m-5 p-2">
        <h1>Edit User Form</h1>
        <div class="container bg-dark-subtle">
            <form method="get" action="handleUserEdit">
                <input type="hidden" name="action" value="userEdit">
                <div class="row g-3">
                    <div class="col-md-6"><label for="UID" class="form-label">UID:</label>
                        <input type="text" class="form-control" id="UID" disabled value="<%=id%>">
                    </div>
                    <div class="col-md-6"><label for="username" class="form-label">User Name:</label>
                        <input type="text" class="form-control" id="username" value="<%=username%>">
                    </div>
                    <div class="col-md-6"><label for="password" class="form-label">Password:</label>
                        <input type="password" class="form-control" id="password" value="<%=password%>">
                        <input type="checkbox" onclick="isShowPassword()" id="showPassword">
                        <label for="showPassword" class="form-label">Show Password</label>
                    </div>
                    <div class="col-md-6"><label for="email" class="form-label">Email:</label>
                        <input type="text" class="form-control" id="email" value="<%=email%>">
                    </div>
                    <div class="col-md-6"><label for="phoneNumber" class="form-label">Phone Number:</label>
                        <input type="text" class="form-control" id="phoneNumber" value="<%=phoneNumber%>">
                    </div>
                    <div class="col-md-6"><label for="role" class="form-label">Role:</label>
                        <input type="text" class="form-control" id="role" value="<%=role%>">
                    </div>
                    <div class="col ">
                        <div class="d-flex justify-content-end">
                            <button>Submit</button>
                            <button>Cancel</button>
                        </div>
                    </div>

                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
<script>
    function isShowPassword() {
        const x = document.getElementById("password")
        if (x.type === "password") {
            x.type = "text";
        } else {
            x.type = "password"
        }
    }
</script>
