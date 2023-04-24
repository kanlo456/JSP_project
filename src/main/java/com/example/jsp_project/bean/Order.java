package com.example.jsp_project.bean;

public class Order extends Cart {
    private String bookingID;

    public Order(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }
}
