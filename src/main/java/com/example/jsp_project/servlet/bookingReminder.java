package com.example.jsp_project.servlet;

import com.example.jsp_project.bean.Cart;
import com.example.jsp_project.bean.Order;
import com.example.jsp_project.bean.User;
import com.example.jsp_project.db.OrderDB;
import com.example.jsp_project.db.VenueDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class bookingReminder extends HttpServlet {

    private OrderDB db;

    public void init() {
        String dbUSer = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        db = new OrderDB(dbUrl, dbUSer, dbPassword);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("reminder".equalsIgnoreCase(action)){
            User user = (User) request.getSession().getAttribute("UserInfo");
            String userID = user.getId();
            ArrayList<Order> orders=db.listReminderMemberOrder(userID);
            request.setAttribute("reminderOrder",orders);
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/bookingReminder.jsp");
            rd.forward(request,response);
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
