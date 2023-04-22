package com.example.jsp_project.bean;

import java.io.Serializable;

public class Guest implements Serializable {
    private  String guestID, bookingID, name, email;
    public Guest(String guestID, String bookingID, String name, String email){
        this.guestID = guestID;
        this.bookingID = bookingID;
        this.name = name;
        this.email = email;
    }

    public Guest() {

    }

    public String getGName() {
        return name;
    }

    public void setGName(String name) {
        this.name = name;
    }

    public String getGuestID() {
        return guestID;
    }

    public void setGuestID(String guestID) {
        this.guestID = guestID;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bkingID) {
        this.bookingID = bkingID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
