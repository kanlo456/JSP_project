package com.example.jsp_project.servlet;

import com.example.jsp_project.bean.Cart;
import com.example.jsp_project.bean.Guest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;

@WebServlet(name = "HandleRemoveGuest", urlPatterns = {"/handleRemoveGuest"})
public class DeleteGuest extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        PrintWriter out = response.getWriter();

        if ("delete".equalsIgnoreCase(action)) {
            String guestEmail = request.getParameter("guestEmail");
            ArrayList<Guest> guest_list = (ArrayList<Guest>) request.getSession().getAttribute("guest-list");
            if (guest_list != null) {
                for (Guest g : guest_list) {
                    if (Objects.equals(g.getEmail(), guestEmail)) {
                        guest_list.remove(guest_list.indexOf(g));
                        out.println("Guest list removed");
                    }
                }
            }
            out.println("Guest list");
//            response.sendRedirect("addGuest.jsp");
        } else {
//            response.sendRedirect("addGuest.jsp");
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
