package com.example.jsp_project.servlet;

import com.example.jsp_project.db.VenueDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "ShowVenueController", urlPatterns = {"/showVenueController"})
public class ShowVenueController extends HttpServlet {
    private VenueDB db;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        PrintWriter out = response.getWriter();
        if(action == null){
            ArrayList venue = new ArrayList();
            venue= db.getVenue();
            request.setAttribute("venues", venue);
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/venueList.jsp");
            rd.forward(request, response);

        }
    }

    public void init(){
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        db = new VenueDB(dbUrl, dbUser, dbPassword);
    }

}
