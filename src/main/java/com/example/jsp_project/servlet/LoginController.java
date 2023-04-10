package com.example.jsp_project.servlet;

import com.example.jsp_project.db.UserDB;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "./LoginController",urlPatterns = {"/main"})
public class LoginController extends HttpServlet {
    private UserDB db;
    public void init(){
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        db = new UserDB(dbUrl,dbUser,dbPassword);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String uname = request.getParameter("uname");
        String pass = request.getParameter("pass");
        if (uname.equals("test") && pass.equals("123")){
            HttpSession session = request.getSession();
            session.setAttribute("username",uname);
            response.sendRedirect("Management/UserACManagement.jsp");
        }
        else {
            response.sendRedirect("login.jsp");
        }
    }
}