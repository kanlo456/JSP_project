package com.example.jsp_project.db;

import com.example.jsp_project.bean.Booking;
import com.example.jsp_project.bean.Venue;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class BookingDB {
    private String url = "";
    private String username = "";
    private String password = "";
    public BookingDB(String url, String dbUser, String Password) {
        this.url = url;
        this.username = dbUser;
        this.password = Password;
    }

    public Connection getConnection() throws SQLException, IOException {

        System.setProperty("sql", "com.mysql.cj.jdbc.driver");

        return DriverManager.getConnection(url, username, password);

    }
    public ArrayList<Booking> showGraph(){
        Connection connection = null;
        PreparedStatement pStatement = null;
        try {
            connection = getConnection();
            String preQueryStatement = "SELECT VenueID, COUNT(*) AS NumBookings FROM booking GROUP BY VenueID;";
            pStatement = connection.prepareStatement(preQueryStatement);
            ResultSet rs = pStatement.executeQuery();
            ArrayList<Booking> list = new ArrayList<Booking>();
            while (rs.next()) {
                Booking booking = new Booking();
                booking.setVenueId(rs.getString(1));
                booking.setNumBookings(Integer.parseInt(rs.getString(2)));

                list.add(booking);



            }
            pStatement.close();
            connection.close();
            return list;
        } catch (SQLException e) {
            while (e != null) {
                e.printStackTrace();
                e = e.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
