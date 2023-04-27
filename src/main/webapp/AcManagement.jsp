<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: kanlo
  Date: 11/4/2023
  Time: 11:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.example.jsp_project.bean.User" %>
<html>
<head>
    <link rel="stylesheet" href="css/ManagerNav.css">
    <link rel="stylesheet" href="bootstrap-5.3.0/css/bootstrap.css">
    <link rel="stylesheet" href="bootstrap-5.3.0/css/bootstrap.min.css">
    <script rel="script" src="bootstrap-5.3.0/js/bootstrap.js"></script>
    <title>Account Management</title>
</head>
<body>
<jsp:include page="component/ManagerNav.jsp"></jsp:include>
<div class="main_content">
    <div class="container-md m-5 p-2">
        <div class="row">
            <div class="col-12">
                <h1>Account Management</h1>
                <div class="d-flex justify-content-end pb-2">
                    <div>
                        <a href="editUser.jsp"class="text-decoration-none">
                            <button type="button" class="btn btn-primary">Add User</button>
                        </a>
                        <a href="handleRoleEdit?action=list">
                            <button type="button" class="btn btn-warning">Manage Role</button>
                        </a>
                    </div>
                </div>
            </div>
            <div class="table-responsive-sm">
                <table class="table table-bordered">
                    <thead class="table-dark">
                    <tr>
                        <th>#</th>
                        <th>UID</th>
                        <th>User Name</th>
                        <th>Password</th>
                        <th>Email</th>
                        <th>Phone Number</th>
                        <th>Role</th>
                        <th>Delete</th>
                        <th>Edit</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        ArrayList<User> users = (ArrayList<User>) request.getAttribute("users");
                        for (int i = 0; i < users.size(); i++) {
                            User user = users.get(i);

                    %>
                    <tr>
                        <th scope="row"><%=i + 1%>
                        </th>
                        <td><%=user.getId()%>
                        </td>
                        <td><%=user.getUsername()%>
                        </td>
                        <td><%=user.getPassword()%>
                        </td>
                        <td><%=user.getEmail()%>
                        </td>
                        <td><%=user.getPhoneNumber()%>
                        </td>
                        <td><%=user.getRole()%>
                        </td>
                        <td>
                            <a class="btn text-decoration-none text-light" href="handleUserEdit?action=delete&id=<%=user.getId()%>">  <button class="btn btn-danger">Delete</button></a>
                        </td>
                        <td>
                            <a class="btn text-decoration-none text-light" href="handleUserEdit?action=getEditUser&id=<%=user.getId()%>"> <button class="btn btn-success">Edit</button></a>
                        </td>
                    </tr>
                    <%}%>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
