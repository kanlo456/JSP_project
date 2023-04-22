package com.example.jsp_project.servlet;

import com.example.jsp_project.bean.Cart;
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

@WebServlet(name = "HandleCartEdit", urlPatterns = {"/handleCartEdit"})
public class HandleCart extends HttpServlet {
    private VenueDB db;

    public void init() {
        String dbUSer = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        db = new VenueDB(dbUrl, dbUSer, dbPassword);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
        if ("list".equalsIgnoreCase(action)) {
            if (cart_list != null) {
                ArrayList<Cart> cartlist = (ArrayList<Cart>) db.getCartVenue(cart_list);
                request.setAttribute("cartList", cartlist);
                RequestDispatcher rd;
                rd = getServletContext().getRequestDispatcher("/cart.jsp");
                rd.forward(request, response);
            }
//                request.setAttribute("cartList", cartlist);
//                RequestDispatcher rd;
//                rd = getServletContext().getRequestDispatcher("/cart.jsp");
//                rd.forward(request, response);
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
