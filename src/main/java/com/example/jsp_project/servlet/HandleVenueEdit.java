package com.example.jsp_project.servlet;

import com.example.jsp_project.bean.Venue;
import com.example.jsp_project.db.VenueDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.System.out;

@WebServlet(name = "HandleVenueEdit", urlPatterns = {"/handleVenueEdit"})
@MultipartConfig
public class HandleVenueEdit extends HttpServlet {
    private VenueDB db;

    private  void processRequest(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
        String action = request.getParameter("action");
        if("add".equalsIgnoreCase(action)){
            String vName = request.getParameter("venueName");
            String vType = request.getParameter("venueType");
            String image = request.getParameter("img");

            int capacity = Integer.parseInt(request.getParameter("capacity"));
            String person = request.getParameter("person");
            int fee = Integer.parseInt(request.getParameter("fee"));
            String location = request.getParameter("location");
            String desc = request.getParameter("desc");
            boolean result =db.addVenue(vName,vType,capacity,location,desc,person,fee);

            response.sendRedirect("showVenueController?action=list");

        }else if("delete".equalsIgnoreCase(action)){
            String id = request.getParameter("id");

            if(id != null){

                boolean result = db.delVenue(id);
                response.sendRedirect("showVenueController?action=list");


            }
        }else if("edit".equalsIgnoreCase(action)){
            String id = request.getParameter("id");
            if(id != null){
               Venue venue = db.queryVenueByID(id);
               request.setAttribute("c", venue);
                RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/addVenue.jsp");
                rd.forward(request, response);
            }
        }else{
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
        String dbUSer= this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        db = new VenueDB(dbUrl,dbUSer,dbPassword);
    }

}
