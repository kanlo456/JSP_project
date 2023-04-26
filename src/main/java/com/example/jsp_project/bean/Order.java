package com.example.jsp_project.bean;

import java.util.ArrayList;

public class Order extends Cart {
    private String bookingID;
    private String venueID;

    private String memberID;

    private String totalFee;

    private String bookingDate;

    private String startTime;
    private String endTime;

    public ArrayList<Guest> getGuests() {
        return guests;
    }

    public void setGuests(ArrayList<Guest> guests) {
        this.guests = guests;
    }

    private String hour;

    private ArrayList<Guest> guests;

    public Order(String bookingID, String venueID, String memberID, String totalFee, String bookingDate, String startTime, String endTime, String hour, ArrayList<Guest> guests) {
        this.bookingID = bookingID;
        this.venueID = venueID;
        this.memberID = memberID;
        this.totalFee = totalFee;
        this.bookingDate = bookingDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.hour = hour;
        this.guests = guests;
    }

    public String getVenueID() {
        return venueID;
    }

    public void setVenueID(String venueID) {
        this.venueID = venueID;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @Override
    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public Order(String bookingID) {
        this.bookingID = bookingID;
    }

    public Order() {
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }
}
