package com.example.jsp_project.servlet;

import com.example.jsp_project.bean.User;
import com.example.jsp_project.db.UserDB;
import org.jetbrains.annotations.NotNull;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "HandleUserEdit", urlPatterns = {"/handleUserEdit"})
public class HandleUserEdit extends HttpServlet {
    private UserDB db;

    public void init() {
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        db = new UserDB(dbUrl, dbUser, dbPassword);
    }

    protected void processRequest(@NotNull HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("list".equalsIgnoreCase(action)) {
            ArrayList<User> users = db.listAllUser();
            request.setAttribute("users", users);
            RequestDispatcher rd;
            rd = getServletContext().getRequestDispatcher("/AcManagement.jsp");
            rd.forward(request, response);
        }
        if ("delete".equalsIgnoreCase(action)) {
            String id = request.getParameter("id");
            if (id != null) {
                db.deleteUser(id);
                response.sendRedirect(request.getContextPath() + "/handleUserEdit?action=list");
            }
        }
        if ("getEditUser".equalsIgnoreCase(action)) {
            String id = request.getParameter("id");
            if (id != null) {
                User user = db.queryUserByID(id);
                request.setAttribute("u", user);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/editUser.jsp");
                rd.forward(request, response);
            }
        }
        if ("userEdit".equals(action)) {
            String id = request.getParameter("userID");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String phoneNumber = request.getParameter("phoneNumber");
            String role = request.getParameter("role");
            if (id != null) {
                db.userEdit(id, username, password, email, phoneNumber, role);
                response.sendRedirect(request.getContextPath() + "/handleUserEdit?action=list");
            }
        }
        if ("addUser".equals(action)) {
            String id = request.getParameter("userID");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String phoneNumber = request.getParameter("phoneNumber");
            String role = request.getParameter("role");
            db.addUser(username,password,email,phoneNumber,role);
            response.sendRedirect(request.getContextPath() + "/handleUserEdit?action=list");
        } else {
            PrintWriter out = response.getWriter();
            out.println("No such action!!");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
