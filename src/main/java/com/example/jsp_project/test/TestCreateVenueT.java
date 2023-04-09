package com.example.jsp_project.test;

import com.example.jsp_project.db.VenueDB;

public class TestCreateVenueT {
    public static void main(String[] arg) {
        String url = "jdbc:mysql://localhost:3306/IT4511_Project";
        String username = "root";
        String password = "";
        VenueDB venuedb = new VenueDB(url, username, password);
        venuedb.CreateVenueTable();
    }
}
