package com.example.jsp_project.test;

import com.example.jsp_project.db.UserDB;
import com.example.jsp_project.db.VenueDB;

public class TestLogin {
    public static void main(String[] arg) {
        String url = "jdbc:mysql://localhost:3306/ITP4511_Project";
        String username = "root";
        String password = "";
        UserDB user = new UserDB(url,username,password);
        user.createUserDb();
        System.out.println(user.isVaildUser("Peter","12345678"));
        System.out.println(user.getUserRole("Peter","12345678"));

        user.addUser("ME","1234567","erqwae","213232333","Member");
    }
}
 