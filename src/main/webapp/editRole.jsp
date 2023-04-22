<%@ page import="com.example.jsp_project.bean.Role" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: kanlo
  Date: 13/4/2023
  Time: 10:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/ManagerNav.css">
    <link rel="stylesheet" href="bootstrap-5.3.0/css/bootstrap.css">
    <script rel="script" src="bootstrap-5.3.0/js/bootstrap.js"></script>
</head>
<body>
<jsp:include page="component/ManagerNav.jsp"></jsp:include>
<%--<jsp:useBean id="r" scope="request" class="com.example.jsp_project.bean.Role"/>--%>
<div class="main_content">
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Add Role</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <form method="post" action="handleRoleEdit">
                    <div class="modal-body">

                        <div class="mb-3">
                            <input type="hidden" name="action" value="addRole">
                            <label for="RID" class="col-form-label">Role ID:</label>
                            <input type="text" class="form-control" id="RID" name="RID">
                        </div>
                        <div class="mb-3">
                            <label for="role-name" class="col-form-label">Role Name:</label>
                            <input type="text" class="form-control" id="role-name" name="role">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="container-md m-5 p-2">
        <div class="row">
            <div class="col-12">
                <h1>Role Management</h1>
                <div class="d-flex justify-content-end pb-2">
                    <div>
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                data-bs-target="#exampleModal" data-bs-whatever="@mdo">Add Role
                        </button>
                        <a href="handleUserEdit?action=list">
                            <button type="button" class="btn btn-warning">Edit User</button>
                        </a>
                    </div>
                </div>
            </div>
            <div class="table-responsive-sm">
                <table class="table table-bordered">
                    <thead class="table-dark">
                    <tr>
                        <th>#</th>
                        <th>RID</th>
                        <th>Role</th>
                        <th>Delete</th>
                        <th>Edit</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        ArrayList<Role> roles = (ArrayList<Role>) request.getAttribute("role");
                        for (int i = 0; i < roles.size(); i++) {
                            Role role = roles.get(i);
                    %>
                    <%--                    <form method="post" name="action" action="handleRoleEdit">--%>
                    <tr>
                        <th scope="row"><%=i + 1%>
                        </th>
                        <td>
                            <input type="hidden" name="action" value="editRole">
                            <input type="text" class="form-control bg-secondary bg-opacity-50" name="id" readonly
                                   value="<%=role.getId()%>">
                        </td>
                        <td>
                            <input type="text" class="form-control bg-secondary bg-opacity-50" name="role" readonly
                                   value="<%=role.getRole()%>">
                        </td>

                        <td>
                            <button class="btn btn-danger"><a href="handleRoleEdit?action=delete&id=<%=role.getId()%>">Delete</a>
                            </button>
                        </td>
                        <td>
                            <button type="submit">Edit</button>
                        </td>
                    </tr>
                    </form>
                    <%}%>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>

