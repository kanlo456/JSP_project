package com.example.jsp_project.db;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
public class VenueDB {
    private String url="";
    private String username = "";
    private String password = "";
    public VenueDB(String url, String dbUser , String Password){
        this.url=url;
        this.username=dbUser;
        this.password=Password;
    }

    public Connection getConnection() throws SQLException, IOException {
//        try{
//            Class.forName("com.mysql.jdbc.driver");
//        }catch(ClassNotFoundException ex){
//            ex.printStackTrace();
//        }
//
//        return DriverManager.getConnection(url,username,password);
        System.setProperty("sql", "com.mysql.cj.jdbc.driver");
        return DriverManager.getConnection(url, username, password);

    }

    public void CreateVenueTable(){
        Statement stmnt =null;
        Connection cnnct =null;
        try {
            cnnct = getConnection();
            stmnt = cnnct.createStatement();
            String sql
                    = "CREATE TABLE IF NOT EXISTS Venue ("
                    + "VenueID int(5) NOT NULL,"
                    + "VenueName varchar(50) NOT NULL,"
                    + "Img mediumblob DEFAULT NULL,"
                    + "VenueType varchar(50) NOT NULL,"
                    + "Capacity int(5) NOT NULL,"
                    + "Location varchar(50) NOT NULL,"
                    + "VenueDesc varchar(50) NOT NULL,"
                    + "VenuePerson varchar(50) NOT NULL,"
                    + "BookingFee int(5) NOT NULL,"
                    + "PRIMARY KEY (VenueID)"
                    + ")";
            stmnt.execute(sql);
            stmnt.close();
            cnnct.close();

        }catch(SQLException e){
            while (e != null) {
                e.printStackTrace();
                e = e.getNextException();
            }
        }catch(IOException e){
            e.printStackTrace();
        }

    }

//    public  boolean AddVenueRecord(){}
}
