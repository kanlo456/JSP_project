package com.example.jsp_project.test;

import com.example.jsp_project.db.VenueDB;

import java.util.ArrayList;

public class TestCreateVenueT {
    public static void main(String[] arg) {
        String url = "jdbc:mysql://localhost:3306/ITP4511_Project";
        String username = "root";
        String password = "";
        VenueDB venue = new VenueDB(url, username, password);
        venue.CreateVenueTable();
        ArrayList venues = new ArrayList<>();
        venues = venue.listVenue();
        System.out.println(venues.size());
    }
}
