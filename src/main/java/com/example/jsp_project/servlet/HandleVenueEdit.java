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
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.System.out;

@WebServlet(name = "HandleVenueEdit", urlPatterns = {"/handleVenueEdit"})
@MultipartConfig
public class HandleVenueEdit extends HttpServlet {
    private VenueDB db;

    private  void processRequest(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
        String action = request.getParameter("action");
        String id = request.getParameter("id");
        String vName = request.getParameter("venueName");
        String vType = request.getParameter("venueType");
        Part image = request.getPart("img");
        String capacity = request.getParameter("capacity");
        String person = request.getParameter("person");
        String fee = request.getParameter("fee");
        String location = request.getParameter("location");
        String desc = request.getParameter("desc");

        if("add".equalsIgnoreCase(action)){

            db.addVenue(vName,image,vType,capacity,location,desc,person,fee);

            response.sendRedirect("showVenueController?action=list");

        }else if("delete".equalsIgnoreCase(action)){
            if(id != null){
                boolean result = db.delVenue(id);
                response.sendRedirect("showVenueController?action=list");
            }
        }else if("getEdit".equalsIgnoreCase(action)){
            if(id != null){
               Venue venue = db.queryVenueByID(id);
               request.setAttribute("v", venue);
                RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/addVenue.jsp");
                rd.forward(request, response);
            }
        }
        else if("edit".equalsIgnoreCase(action)){
            if(id!=null) {
                Venue v = new Venue(id,vName, image, vType, location, desc, person, capacity, fee);
                db.editVenue(v);
                response.sendRedirect("showVenueController?action=list");
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
        String dbUSer= this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        db = new VenueDB(dbUrl,dbUSer,dbPassword);
    }

}
