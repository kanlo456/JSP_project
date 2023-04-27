package com.example.jsp_project.servlet;

import com.example.jsp_project.bean.Guest;
import com.example.jsp_project.bean.Order;
import com.example.jsp_project.db.GuestDB;
import com.example.jsp_project.db.OrderDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "CheckStateController", urlPatterns = {"/checkStateController"})
public class CheckStateController extends HttpServlet {
    private OrderDB orderDB;
    private GuestDB guestDB;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String bookingID = request.getParameter("id");
        if("list".equalsIgnoreCase(action)){
            ArrayList<Order> orders = orderDB.listCheckBooking();
            request.setAttribute("orders", orders);
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/CheckState.jsp");
            rd.forward(request, response);
        }else if("guestList".equalsIgnoreCase(action)){
            ArrayList<Guest> guests = guestDB.listGuest(bookingID);
            request.setAttribute("guests", guests);
            String check = "check";
            request.setAttribute("check", check);
            request.setAttribute("bookingID", bookingID);
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/GuestList.jsp");
            rd.forward(request, response);
        }else if("changeState".equalsIgnoreCase(action)){
            if(bookingID!=null) {
                String checkState = request.getParameter("checkState");
                orderDB.changeCheckState(bookingID, checkState);
                response.sendRedirect("checkStateController?action=list");
            }
        } else{
            PrintWriter out = response.getWriter();
            out.println("No such action!!");
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

    public void init(){
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        orderDB = new OrderDB(dbUrl,dbUser,dbPassword);
        guestDB = new GuestDB(dbUrl,dbUser,dbPassword);
    }
}
