package com.example.jsp_project.servlet;

import com.example.jsp_project.bean.Cart;
import com.example.jsp_project.bean.Guest;
import com.example.jsp_project.bean.Order;
import com.example.jsp_project.bean.User;
import com.example.jsp_project.db.BookingDB;
import com.example.jsp_project.db.OrderDB;
import com.example.jsp_project.db.VenueDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "HandleCheckOut", urlPatterns = {"/handleCheckOut"})
public class checkOut extends HttpServlet {

    private OrderDB db;

    public void init() {
        String dbUSer = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        db = new OrderDB(dbUrl, dbUSer, dbPassword);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("checkOut".equalsIgnoreCase(action)) {
            PrintWriter out = response.getWriter();
            ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
            ArrayList<Guest> guest_list = (ArrayList<Guest>) request.getSession().getAttribute("guest-list");
            User user = (User) request.getSession().getAttribute("userInfo");
            String fee = request.getParameter("sendPrice0");
            String date = request.getParameter("date0");
            String startTime = request.getParameter("Start-time0");
            String endTime = request.getParameter("End-time0");
            String hour = request.getParameter("sendHour0");
            String bkID = null;
            if (cart_list != null) {
                Order order = new Order();
                for (Cart c : cart_list) {
                    order.setVenueID(c.getVenueID());
                    order.setMemberID(user.getId());
                    order.setTotalFee(fee);
                    order.setBookingDate(date);
                    order.setStartTime(startTime);
                    order.setEndTime(endTime);
                    order.setHour(hour);
                    order.setGuests(guest_list);
                }
               bkID = db.addBooking(order);
            }
            if (guest_list != null) {
                    db.addGuest(guest_list,bkID);
            }
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/handleBookingStatus?action=list");
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
