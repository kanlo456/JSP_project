package com.example.jsp_project.servlet;

import com.example.jsp_project.db.UserDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateAccountController extends HttpServlet {

    private UserDB db;

    public void init(){
        String dbUSer= this.getServletContext().getInitParameter("dbUSer");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        db = new UserDB(dbUrl,dbUSer,dbPassword);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        
    }

}
