package com.example.jsp_project.bean;

import javax.servlet.http.Part;
import java.io.Serializable;

public class Venue implements Serializable {
    private String  name, vType,  location, description, person;
    private int id, capacity, bookingFee;
//    private byte[]  imgs;
//    private Part img;
    public Venue(int id, String name, String type, String location, String description, String person, int capacity, int bookingFee) {
        this.id = id;
        this.name = name;
        this.vType = type;
        this.location = location;
        this.description = description;
        this.person = person;
        this.capacity = capacity;
        this.bookingFee = bookingFee;
    }

    public Venue() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return vType;
    }

    public void setType(String type) {
        this.vType = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }



    public int getBookingFee() {
        return bookingFee;
    }

    public void setBookingFee(int bookingFee) {
        this.bookingFee = bookingFee;
    }

//    public byte[] getImgs() {
//        return imgs;
//    }
//
//    public void setImgs(byte[] imgs) {
//        this.imgs = imgs;
//    }
//
//    public Part getImg() {
//        return img;
//    }
//
//    public void setImg(Part img) {
//        this.img = img;
//    }


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


}
