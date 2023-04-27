package com.example.jsp_project.servlet;

import com.example.jsp_project.bean.Guest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;

@WebServlet(name = "handleCheckoutGuestEdit", urlPatterns = {"/handleCheckoutGuestEdit"})
public class HandleCheckoutGuestEdit extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        PrintWriter out = response.getWriter();

        if ("delete".equalsIgnoreCase(action)) {
            String guestEmail = request.getParameter("guestEmail");
            ArrayList<Guest> guest_list = (ArrayList<Guest>) request.getSession().getAttribute("guest-list");
            if (guest_list != null) {
                for (Guest g : guest_list) {
                    if (g.getEmail().equals(guestEmail)) {
                        guest_list.remove(guest_list.indexOf(g));
                        break;
                    }
                }
            }
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Guest Deleted');");
            out.println("location='addGuest.jsp';");
            out.println("</script>");
//            response.sendRedirect("addGuest.jsp");
        } else if ("editGuest".equalsIgnoreCase(action)){
            String replaceGuestEmail = request.getParameter("replaceGuestEmail");
            String guestName = request.getParameter("guestName");
            String guestEmail = request.getParameter("guestEmail");
            Guest editGuest = new Guest();
            editGuest.setGName(guestName);
            editGuest.setEmail(guestEmail);
            ArrayList<Guest> guest_list= (ArrayList<Guest>) request.getSession().getAttribute("guest-list");
            if (guest_list!=null){
                for (Guest g :guest_list){
                    if (Objects.equals(g.getEmail(),replaceGuestEmail)){
                        guest_list.remove(g);
                        guest_list.add(editGuest);
                    }
                }
            }
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Edit Successfully');");
            out.println("location='addGuest.jsp';");
            out.println("</script>");
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
