package com.example.jsp_project.servlet;

import com.example.jsp_project.bean.ChartData;
import com.example.jsp_project.bean.Order;
import com.example.jsp_project.bean.User;
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

import com.example.jsp_project.db.UserDB;
import com.example.jsp_project.db.VenueDB;
import com.google.gson.Gson;


@WebServlet(name = "ShowGraphController", urlPatterns = {"/showGraphController"})
public class ShowGraphController extends HttpServlet {
    private BookingDB db;
    private VenueDB venueDB;
    private UserDB userDB;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Venue> venues = venueDB.listVenue();
        request.setAttribute("venues", venues);
        String action = request.getParameter("action");
        String venueID = request.getParameter("venueID");
        String userID = request.getParameter("userID");
        String dateType = request.getParameter("dateType");
        if("list".equalsIgnoreCase(action)){
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/reportList.jsp");
            rd.forward(request, response);
        }else if("listVenue".equalsIgnoreCase(action)){
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/report.jsp");
            rd.forward(request, response);
        }else if("record".equalsIgnoreCase(action)){
            ArrayList<Order> orders = db.showBookingReocrd(venueID);
            request.setAttribute("dateType", dateType);
            request.setAttribute("venueID", venueID);
            request.setAttribute("orders", orders);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/reportList.jsp");
            rd.forward(request, response);
        }else if("showGraph".equalsIgnoreCase(action)){

            if ("Monthly".equalsIgnoreCase(dateType)) {
                List<Map<String, Object>> chartData = db.showMonthBooking(venueID);
                List<Map<String, Object>> chartData1 = db.showMonthIncome(venueID);
//                 convert the data to JSON
                Gson gson = new Gson();
                String jsonData = gson.toJson(chartData);
                String jsonData1 = gson.toJson(chartData1);
                request.setAttribute("dateType", dateType);
                request.setAttribute("venueID", venueID);
                request.setAttribute("chartData", jsonData);
                request.setAttribute("chartData1", jsonData1);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/report.jsp");
                rd.forward(request, response);

            }else if(("Yearly".equalsIgnoreCase(dateType))){

                ArrayList<ChartData> chartData = db.selectYearBooking(venueID);
                List<Map<String, Object>> chartData1 = db.showYearIncome(venueID);
//                 convert the data to JSON
                Gson gson = new Gson();
                String jsonData = gson.toJson(chartData);
                String jsonData1 = gson.toJson(chartData1);
                request.setAttribute("dateType", dateType);
                request.setAttribute("venueID", venueID);
                request.setAttribute("chartData", jsonData);
                request.setAttribute("chartData1", jsonData1);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/report.jsp");
                rd.forward(request, response);
            }
        }else if("user".equalsIgnoreCase(action)){
            ArrayList<User> users = userDB.listAllUser();
            request.setAttribute("users", users);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/reportUser.jsp");
            rd.forward(request, response);
        }else if("showUser".equalsIgnoreCase(action)){
            ArrayList<User> users = userDB.listAllUser();
            request.setAttribute("users", users);
            if ("Monthly".equalsIgnoreCase(dateType)) {
                ArrayList<ChartData> chartData = db.selectMonthAttendance(userID);
//                 convert the data to JSON
                Gson gson = new Gson();
                String jsonData = gson.toJson(chartData);
                request.setAttribute("dateType", dateType);
                request.setAttribute("userID", userID);
                request.setAttribute("chartData", jsonData);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/reportUser.jsp");
                rd.forward(request, response);

            }else if(("Yearly".equalsIgnoreCase(dateType))){

                ArrayList<ChartData> chartData = db.selectYearAttendance(userID);
//                 convert the data to JSON
                Gson gson = new Gson();
                String jsonData = gson.toJson(chartData);
                request.setAttribute("dateType", dateType);
                request.setAttribute("userID", userID);
                request.setAttribute("chartData", jsonData);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/reportUser.jsp");
                rd.forward(request, response);
            }
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
        venueDB = new VenueDB(dbUrl, dbUser, dbPassword);
        userDB = new UserDB(dbUrl, dbUser, dbPassword);
    }
}
