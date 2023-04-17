package com.example.jsp_project.servlet;

import com.example.jsp_project.bean.User;
import com.example.jsp_project.bean.Venue;
import com.example.jsp_project.db.FeeDB;
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
    private FeeDB feeDB;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if("list".equalsIgnoreCase(action)){
            ArrayList<Venue> venues = db.listVenue();
            request.setAttribute("venues", venues);
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/venueList.jsp");
            rd.forward(request, response);
        }
        if ("memberList".equalsIgnoreCase(action)){
            ArrayList<Venue> venues = db.listVenue();
            request.setAttribute("venues", venues);
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/MemberHome.jsp");
            rd.forward(request, response);
        }
        else{
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
        db = new VenueDB(dbUrl, dbUser, dbPassword);
    }

}
