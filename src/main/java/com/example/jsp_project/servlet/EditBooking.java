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

@WebServlet(name = "handleEditBooking", urlPatterns = {"/handleEditBooking"})
public class EditBooking extends HttpServlet {

    private OrderDB db;

    public void init() {
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        db = new OrderDB(dbUrl, dbUser, dbPassword);
    }

    protected void processRequest(@NotNull HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
//        User user = (User) request.getSession().getAttribute("userInfo");

        if ("list".equalsIgnoreCase(action)) {
//            ArrayList<Order> orders = db.listMemberOrder(user.getId());
//            request.setAttribute("order", orders);
            String bookingID = request.getParameter("bookingId");
            ArrayList<Guest> guests = db.bookingGuestList(bookingID);
            request.setAttribute("guests", guests);
//            request.setAttribute("bookID",guests.get(0).getBookingID());
            RequestDispatcher rd;
            rd = getServletContext().getRequestDispatcher("/editBooking.jsp");
            rd.forward(request, response);
        }
        if ("editGuest".equalsIgnoreCase(action)) {
            String bookingID = request.getParameter("guestBkID");
            String guestName = request.getParameter("guestName");
            String guestEmail = request.getParameter("guestEmail");
            String guestID = request.getParameter("guestID");
            if (bookingID != null) {
                db.guestEdit(guestID, guestName, guestEmail);
            }
        }
        if ("delete".equalsIgnoreCase(action)) {
            String bookingId = request.getParameter("bookingId");
            String guestId = request.getParameter("guestId");
            if (bookingId != null & guestId != null) {
                db.deleteGuest(guestId);
                response.sendRedirect("handleEditBooking?action=list&bookingId=" + bookingId);
            }
        }
        if ("addGuest".equalsIgnoreCase(action)) {

        }
        if ("goEditGuest".equalsIgnoreCase(action)) {
            String bookingId = request.getParameter("bookingID");
            if (bookingId != null) {
                request.setAttribute("bookingId", bookingId);
                RequestDispatcher rd;
                rd = getServletContext().getRequestDispatcher("/addBookedGuest.jsp");
                rd.forward(request,response);
            }
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
