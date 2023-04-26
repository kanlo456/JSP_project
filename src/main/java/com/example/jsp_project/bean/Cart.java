package com.example.jsp_project.bean;

import java.util.ArrayList;

public class Cart extends Venue{
    private  int quantity;

    private Guest guest;

    private String StarTime;

    private String EndTime;

    public String getStarTime() {
        return StarTime;
    }

    public String getEndTime() {
        return EndTime;
    }


    public void setEndTime(String endTime) {
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
