package com.example.jsp_project.servlet;

import com.example.jsp_project.bean.Guest;

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
import java.util.Objects;

@WebServlet(name = "addGuest", urlPatterns = "/add-guest")
public class AddGuest extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if ("addGuest".equalsIgnoreCase(action)) {
            try (PrintWriter out = response.getWriter()) {
                ArrayList<Guest> guestList = new ArrayList<>();
                String guestName = request.getParameter("guestName");
                String guestEmail = request.getParameter("guestEmail");
                Guest guest = new Guest();
                guest.setGName(guestName);
                guest.setEmail(guestEmail);
                HttpSession session = request.getSession();
                ArrayList<Guest> guest_list = (ArrayList<Guest>) session.getAttribute("guest-list");
                if (guest_list == null) {
                    guestList.add(guest);
                    session.setAttribute("guest-list", guestList);
                    out.println("session created and added the guest");
                    response.sendRedirect("addGuest.jsp");
                } else {
                    guestList = guest_list;
                    boolean exist = false;
                    for (Guest g : guest_list) {
                        if (Objects.equals(g.getEmail(), guestEmail)) {
                            exist = true;
//                            request.setAttribute("alertMsg","Guest Exit");
                            out.println("<script type=\"text/javascript\">");
                            out.println("alert('Guest Exist');");
                            out.println("location='addGuest.jsp';");
                            out.println("</script>");
                        }
                    }
                    if (!exist) {
                        guestList.add(guest);
                        out.println("guest added");
                        response.sendRedirect("addGuest.jsp");
                    }
                }
            }
        }
    }
}
