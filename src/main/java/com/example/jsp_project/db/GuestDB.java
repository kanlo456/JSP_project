package com.example.jsp_project.db;

import com.example.jsp_project.bean.Guest;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class GuestDB {
    private String url = "";
    private String username = "";
    private String password = "";
    public GuestDB(String url, String dbUser, String Password) {
        this.url = url;
        this.username = dbUser;
        this.password = Password;
    }

    public Connection getConnection() throws SQLException, IOException {

        System.setProperty("sql", "com.mysql.cj.jdbc.driver");

        return DriverManager.getConnection(url, username, password);

    }
    public ArrayList<Guest> listGuest(String bookingID){
        Connection connection = null;
        PreparedStatement pStatement =null;

        try{
            connection = getConnection();
            String preQueryStatement = "SELECT * FROM guest WHERE BkingID = ?;";
            pStatement = connection.prepareStatement(preQueryStatement);
            pStatement.setInt(1, Integer.parseInt(bookingID));
            ResultSet rs= pStatement.executeQuery();
            ArrayList<Guest> list = new ArrayList<Guest>();
            while(rs.next()) {
                Guest guest = new Guest();
                guest.setGuestID(rs.getString(1));
                guest.setBookingID(rs.getString(2));
                guest.setGName(rs.getString(3));
                guest.setEmail(rs.getString(4));
                list.add(guest);
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


}
