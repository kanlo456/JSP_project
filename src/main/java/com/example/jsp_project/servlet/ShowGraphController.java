package com.example.jsp_project.servlet;

import com.example.jsp_project.bean.Booking;
import com.example.jsp_project.bean.ChartData;
import com.example.jsp_project.bean.Venue;
import com.example.jsp_project.db.BookingDB;
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
import com.google.gson.Gson;


@WebServlet(name = "ShowGraphController", urlPatterns = {"/showGraphController"})
public class ShowGraphController extends HttpServlet {
    private BookingDB db;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if("list".equalsIgnoreCase(action)){
            ArrayList<ChartData> chartData = db.showGraph();
            // convert the data to JSON
            Gson gson = new Gson();
            String jsonData = gson.toJson(chartData);
            request.setAttribute("chartData", jsonData);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/report.jsp");
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
        db = new BookingDB(dbUrl, dbUser, dbPassword);
    }
}