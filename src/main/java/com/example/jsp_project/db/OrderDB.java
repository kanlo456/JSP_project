package com.example.jsp_project.db;

import com.example.jsp_project.bean.Guest;
import com.example.jsp_project.bean.Order;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class OrderDB {

    private String dbUrl = "";
    private String dbUser = "";
    private String dbPassword = "";

    public OrderDB(String dbUrl, String dbUser, String dbPassword) {
        this.dbUrl = dbUrl;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
    }

    public Connection getConnection() throws SQLException, IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
    }

    public String addBooking(Order order) {
        Connection connection = null;
        PreparedStatement pStatement = null;
        boolean result = false;
        String bkID = null;
        try {
            connection = getConnection();
            String preQueryStatement = "INSERT INTO booking VALUES (NULL,?,?,?,?,?,?,?,'processing','wating');";
            pStatement = connection.prepareStatement(preQueryStatement);
            pStatement.setString(1, order.getVenueID());
            pStatement.setString(2, order.getMemberID());
            pStatement.setString(3, order.getTotalFee());
            pStatement.setString(4, order.getBookingDate());
            pStatement.setString(5, order.getStartTime());
            pStatement.setString(6, order.getEndTime());
            pStatement.setString(7, order.getHour());
            int rowInserted = pStatement.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("Updated");
                preQueryStatement = "SELECT LAST_INSERT_ID();";
                pStatement = connection.prepareStatement(preQueryStatement);
                ResultSet rs = null;
                rs = pStatement.executeQuery();
                if (rs.next()) {
                    bkID = rs.getString("LAST_INSERT_ID()");
                }
            }
            pStatement.close();
            connection.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bkID;
    }

    public boolean addGuest(ArrayList<Guest> guests, String bkingID) {
        Connection connection = null;
        PreparedStatement pStatement = null;
        boolean result = false;
        try {
            connection = getConnection();
            String preQueryStatement = "INSERT INTO guest VALUES (NULL,?,?,?);";
            pStatement = connection.prepareStatement(preQueryStatement);
            for (Guest g : guests) {
                pStatement.setString(1, bkingID);
                pStatement.setString(2, g.getGName());
                pStatement.setString(3, g.getEmail());
                int rowInserted = pStatement.executeUpdate();
                if (rowInserted > 0) {
                    System.out.println("Updated");
                }
            }
            pStatement.close();
            connection.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
