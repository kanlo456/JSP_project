package com.example.jsp_project.servlet;


import com.example.jsp_project.bean.Role;
import com.example.jsp_project.db.RoleDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "HandleRoleEdit",urlPatterns = {"/handleRoleEdit"})
public class HandleRoleEdit extends HttpServlet {

    private RoleDB db;
    public void init() {
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        db = new RoleDB(dbUrl, dbUser, dbPassword);
    }

    protected  void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String action = request.getParameter("action");
        if ("list".equalsIgnoreCase(action)){
            ArrayList<Role> roles = db.listAllRole();
            request.setAttribute("role",roles);
            RequestDispatcher rd;
            rd = getServletContext().getRequestDispatcher("/editRole.jsp");
            rd.forward(request,response);
        }
        if ("delete".equalsIgnoreCase(action)){
            String id = request.getParameter("id");
            if (id!=null){
                db.deleteRole(id);
                response.sendRedirect(request.getContextPath()+"/handleRoleEdit?action=list");
            }
        }
        if ("editRole".equalsIgnoreCase(action)){
            String id = request.getParameter("id");
            String role = request.getParameter("role");
           if (id!=null){
               db.roleEdit(id,role);
               response.sendRedirect(request.getContextPath()+"/handleRoleEdit?action=list");
           }
        }
        if ("addRole".equalsIgnoreCase(action)){
            String role = request.getParameter("role");
            String id = request.getParameter("RID");
            if (role!=null){
                db.addRole(id,role);
                response.sendRedirect(request.getContextPath()+"/handleRoleEdit?action=list");
            }
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
