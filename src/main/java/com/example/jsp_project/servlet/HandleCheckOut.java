package com.example.jsp_project.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


@WebServlet(name = "HandleCheckOut", urlPatterns = {"/handleCheckOut"})
public class HandleCheckOut extends HttpServlet {

    public void init() {
        String dbUSer = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if("checkOut".equalsIgnoreCase(action)){
           Map<String,String[]> parameters = request.getParameterMap();
            PrintWriter out = response.getWriter();
            out.println("Hello");
           for(String parameter: parameters.keySet()){
               if (parameter.toLowerCase().startsWith("start-time")){
                   String[] values = parameters.get(parameter);
//                   PrintWriter out = response.getWriter();
                    out.println(Arrays.toString(values));
               }
           }
        }

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
