package com.example.jsp_project.servlet;


import com.example.jsp_project.bean.Guest;
import com.example.jsp_project.bean.Order;
import com.example.jsp_project.bean.User;
import com.example.jsp_project.db.OrderDB;
import org.jetbrains.annotations.NotNull;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "HandleBookingStatus",urlPatterns = {"/handleBookingStatus"})
public class showBooking extends HttpServlet {
    private OrderDB db;
    public void init() {
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        db = new OrderDB(dbUrl, dbUser, dbPassword);
    }
    protected void processRequest(@NotNull HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        User user = (User) request.getSession().getAttribute("userInfo");

        if ("list".equalsIgnoreCase(action)){
            ArrayList<Order> orders = db.listMemberOrder(user.getId());
            request.setAttribute("order",orders);
            RequestDispatcher rd;
            rd = getServletContext().getRequestDispatcher("/checkBooking.jsp");
            rd.forward(request,response);
        }
    }
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
