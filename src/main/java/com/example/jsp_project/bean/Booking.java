package com.example.jsp_project.bean;

import java.io.Serializable;

public class Booking implements Serializable {
    private  String VenueId;
    private  int numBookings;

    public Booking(String venueId, int numBookings) {
        VenueId = venueId;
        this.numBookings = numBookings;
    }

    public Booking() {

    }

    public String getVenueId() {
        return VenueId;
    }

    public void setVenueId(String venueId) {
        VenueId = venueId;
    }

    public int getNumBookings() {
        return numBookings;
    }

    public void setNumBookings(int numBookings) {
        this.numBookings = numBookings;
    }
}
