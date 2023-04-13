package com.example.jsp_project.bean;

import javax.servlet.http.Part;
import java.io.Serializable;

public class Venue implements Serializable {
    private String id, name, vType,  location, description, person,capacity,bookingFee;
    private byte[]  image;
    private Part img;

    public Venue(String id, String name, byte[] image,String type, String location, String description, String person, String capacity, String bookingFee) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.vType = type;
        this.location = location;
        this.description = description;
        this.person = person;
        this.capacity = capacity;
        this.bookingFee = bookingFee;
    }
    public Venue(String id, String name, Part img,String type, String location, String description, String person, String capacity, String bookingFee) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.vType = type;
        this.location = location;
        this.description = description;
        this.person = person;
        this.capacity = capacity;
        this.bookingFee = bookingFee;
    }

    public Venue() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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



    public String getBookingFee() {
        return bookingFee;
    }

    public void setBookingFee(String bookingFee) {
        this.bookingFee = bookingFee;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getCapacity() {
        return capacity;
    }

    public Part getImg() {
        return img;
    }

    public void setImg(Part img) {
        this.img = img;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }


}
