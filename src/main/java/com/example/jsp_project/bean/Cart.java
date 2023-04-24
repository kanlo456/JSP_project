package com.example.jsp_project.bean;

import java.util.ArrayList;

public class Cart extends Venue{
    private  int quantity;

    private Guest guest;

    private int StarTime;

    private int EndTime;

    public int getStarTime() {
        return StarTime;
    }

    public void setStarTime(int starTime) {
        StarTime = starTime;
    }

    public int getEndTime() {
        return EndTime;
    }

    public void setEndTime(int endTime) {
        EndTime = endTime;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Cart() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    

}
