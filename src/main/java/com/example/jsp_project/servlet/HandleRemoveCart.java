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
import java.util.ArrayList;

@WebServlet(name = "HandleRemoveCart", urlPatterns = {"/handleRemoveCart"})
public class HandleRemoveCart extends HttpServlet {

    private VenueDB db;

    public void init() {
        String dbUSer = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        db = new VenueDB(dbUrl, dbUSer, dbPassword);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("delete".equalsIgnoreCase(action)) {
            String id = request.getParameter("id");
            ArrayList<Cart> carts_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
            if (carts_list != null) {
                for (Cart c : carts_list) {
                    if (c.getId().equals(id)) {
                        carts_list.remove(carts_list.indexOf(c));
                        break;
                    }
                }
            }
            response.sendRedirect("handleCartEdit?action=list");
        } else {
            response.sendRedirect("handleCartEdit?action=list");
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
