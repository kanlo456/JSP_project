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
    public boolean addVenue(String name, String type, int capacity, String location, String desc, String person, int fee) {
        Connection connection = null;
        PreparedStatement pStatement = null;
        boolean result = false;

        try {
            connection = getConnection();
            String preQueryStatement = "INSERT INTO Venue VALUES (NULL,?,NULL,?,?,?,?,?,?)";
            pStatement = connection.prepareStatement(preQueryStatement);
            pStatement.setString(1, name);
            pStatement.setString(2, type);
            pStatement.setInt(3, capacity);
            pStatement.setString(4, location);
            pStatement.setString(5, desc);
            pStatement.setString(6, person);
            pStatement.setInt(7, fee);
            int rowInserted = pStatement.executeUpdate();
            if (rowInserted>0){
                result = true;
                System.out.println("Updated");
            }
            pStatement.close();
            connection.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return result;
    }
    public ArrayList<Venue> listVenue(){
        Connection connection = null;
        PreparedStatement pStatement =null;

        try{
            connection = getConnection();
            String preQueryStatement = "SELECT * FROM venue";
            pStatement = connection.prepareStatement(preQueryStatement);
            ResultSet rs= pStatement.executeQuery();
            ArrayList<Venue> list = new ArrayList<Venue>();
            while(rs.next()) {
                Venue venue = new Venue();
                venue.setId(rs.getInt(1));
                venue.setName(rs.getString(2));
                venue.setType(rs.getString(4));
                venue.setCapacity(rs.getInt(5));
                venue.setLocation(rs.getString(6));
                venue.setDescription(rs.getString(7));
                venue.setPerson(rs.getString(8));
                venue.setBookingFee(rs.getInt(9));
                list.add(venue);
            }
                pStatement.close();
                connection.close();
                return list;
        }catch(SQLException e){
            while(e != null){
                e.printStackTrace();
                e = e.getNextException();
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return null;
    }

    public boolean delVenue(String id) {
        Connection connection = null;
        PreparedStatement pStatement = null;
        int num =0;
        try{
            connection = getConnection();
            String preQueryStatement = "DELETE FROM Venue WHERE VenueID=?";
            pStatement = connection.prepareStatement(preQueryStatement);
            pStatement.setInt(1, Integer.parseInt(id));
            num = pStatement.executeUpdate();
        }catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (pStatement != null) {
                try {
                    pStatement.close();
                } catch (SQLException e) {
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException sqlEx) {
                }
            }
        }
        return (num == 1) ? true : false;
    }

    public Venue queryVenueByID(String id) {
    }
//    public  boolean AddVenueRecord(){}
}
