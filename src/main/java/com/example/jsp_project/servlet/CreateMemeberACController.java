package com.example.jsp_project.servlet;

import com.example.jsp_project.bean.User;
import com.example.jsp_project.db.UserDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name="CreateMemberACController",urlPatterns ={"/createAC"})
public class CreateMemeberACController extends HttpServlet {
    private UserDB db;

    public void init(){
        String dbUSer= this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        db = new UserDB(dbUrl,dbUSer,dbPassword);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        doCreateAccount(request,response);
    }
    private void doCreateAccount(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phoneNumber =request.getParameter("phoneNumber");
        String action = request.getParameter("action");
        if ("memberAC".equals(action)){
            String role = "Member";
            db.addUser(username,password,email,phoneNumber,role);
        }else {
            System.out.println("fail");
        }
    }
}
