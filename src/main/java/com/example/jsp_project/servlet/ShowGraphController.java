package com.example.jsp_project.servlet;

import com.example.jsp_project.bean.ChartData;
import com.example.jsp_project.bean.Venue;
import com.example.jsp_project.db.BookingDB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.jsp_project.db.VenueDB;
import com.google.gson.Gson;


@WebServlet(name = "ShowGraphController", urlPatterns = {"/showGraphController"})
public class ShowGraphController extends HttpServlet {
    private BookingDB db;
    private VenueDB venueDB;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Venue> venues = venueDB.listVenue();
        request.setAttribute("venues", venues);
        String action = request.getParameter("action");

        if("list".equalsIgnoreCase(action)){
            List<Map<String, Object>> chartData = db.showGraph();
            // convert the data to JSON
            Gson gson = new Gson();
            String jsonData = gson.toJson(chartData);

            request.setAttribute("chartData", jsonData);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/report.jsp");
            rd.forward(request, response);
        }else if("showGraph".equalsIgnoreCase(action)){
            String dateType = request.getParameter("dateType");
            String venueID = request.getParameter("venueID");
            PrintWriter out = response.getWriter();
            out.println(dateType);
            out.println(venueID);
            if ("monthly".equalsIgnoreCase(dateType)) {

            }else{
//                List<Map<String, Object>> chartData = db.showYearBooking(venueID);

                // convert the data to JSON
//                Gson gson = new Gson();
//                String jsonData = gson.toJson(chartData);
//
//                request.setAttribute("chartData", jsonData);
//                RequestDispatcher rd = getServletContext().getRequestDispatcher("/report.jsp");
            }
        }


        else{
            PrintWriter out = response.getWriter();
            out.println("No such action!!");
            out.println(action);

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
        venueDB = new VenueDB(dbUrl, dbUser, dbPassword);
    }
}
