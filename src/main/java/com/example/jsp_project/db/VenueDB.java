package com.example.jsp_project.db;

import com.example.jsp_project.bean.User;
import com.example.jsp_project.bean.Venue;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class VenueDB {
    private String url = "";
    private String username = "";
    private String password = "";

    public VenueDB(String url, String dbUser, String Password) {
        this.url = url;
        this.username = dbUser;
        this.password = Password;
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

    public void CreateVenueTable() {
        Statement stmnt = null;
        Connection cnnct = null;
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

        } catch (SQLException e) {
            while (e != null) {
                e.printStackTrace();
                e = e.getNextException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //    Add Venue
    public boolean AddVenue(InputStream img, String name, String type, int capacity, String location, String desc, String person, int fee) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;

        try {
            cnnct = getConnection();
            String preQueryStatement = "INSERT INTO Venue VALUES (?,?,?,?,?,?,?,?,?)";
            pStmnt = cnnct.prepareStatement(preQueryStatement);


        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isSuccess ;
    }
    public ArrayList getVenue(){
        ArrayList venues = new ArrayList();
        Connection cnnct = null;
        PreparedStatement pStmnt =null;

        try{
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM venue";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            ResultSet rs= null;
            rs = pStmnt.executeQuery();
            while(rs.next()) {
                Venue venue = new Venue();
                venue.setId(rs.getInt(1));
                list.add(user);
            }
                pStmnt.close();
                cnnct.close();
        }catch(SQLException ex){
            while(ex != null){
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return venues;
    }
//    public  boolean AddVenueRecord(){}
}
