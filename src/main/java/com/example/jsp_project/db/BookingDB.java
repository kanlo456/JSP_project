package com.example.jsp_project.db;

import com.example.jsp_project.bean.ChartData;
import com.example.jsp_project.bean.Order;
import com.example.jsp_project.bean.Venue;

import java.io.IOException;
import java.sql.*;
import java.util.*;


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
    public ArrayList<Order> showBookingReocrd(String id){
        Connection connection = null;
        PreparedStatement pStatement = null;
        try {
            connection = getConnection();
            String preQueryStatement = "SELECT * FROM booking WHERE VenueID = ?;";
            pStatement = connection.prepareStatement(preQueryStatement);
            pStatement.setInt(1, Integer.parseInt(id));
            ResultSet rs = pStatement.executeQuery();
            ArrayList<Order> list = new ArrayList<Order>();
            while (rs.next()) {
                Order order = new Order();
                order.setBookingID(rs.getString(1));
                order.setVenueId(rs.getString(2));
                order.setMemberID(rs.getString(3));
                order.setBookingFee(rs.getString(4));
                order.setBookingDate(rs.getString(5));
                order.setStartTime(rs.getString(6));
                order.setEndTime(rs.getString(7));
                order.setHour(rs.getString(8));
                list.add(order);
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

    public List<Map<String, Object>> showYearBooking(String id){
        Connection connection = null;
        PreparedStatement pStatement = null;
        try {
            connection = getConnection();
            String preQueryStatement = "SELECT YEAR(BkDate) AS Year, COUNT(*) AS NumBookings FROM Booking WHERE VenueID =? GROUP BY Year;";
            pStatement = connection.prepareStatement(preQueryStatement);
            pStatement.setInt(1, Integer.parseInt(id));
            ResultSet rs = pStatement.executeQuery();

            List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
            while (rs.next()) {
                Map<String, Object> row = new HashMap<String, Object>();

                row.put("labels", rs.getString("Year"));
                row.put("data", rs.getInt("NumBookings"));
                data.add(row);



            }
            pStatement.close();
            connection.close();
            return data;
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

    public ArrayList<ChartData> selectYearBooking(String id){
        Connection connection = null;
        PreparedStatement pStatement = null;
        try {
            connection = getConnection();
            String preQueryStatement = "SELECT YEAR(BkDate) AS year, COUNT(*) AS num_bookings FROM Booking WHERE VenueID =? GROUP BY Year;";
            pStatement = connection.prepareStatement(preQueryStatement);
            pStatement.setInt(1, Integer.parseInt(id));
            ResultSet rs = pStatement.executeQuery();

            ArrayList<ChartData> list = new ArrayList<>();
            while (rs.next()) {
                ChartData data = new ChartData();
                data.setData(rs.getInt("num_bookings"));
                data.setLabels(rs.getString("year"));

                list.add(data);
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

    public List<Map<String, Object>> showMonthBooking(String id){
        Connection connection = null;
        PreparedStatement pStatement = null;
        try {
            connection = getConnection();
            String preQueryStatement = "SELECT MONTH(BkDate) AS MONTH, COUNT(*) AS NumBookings FROM Booking WHERE VenueID =? GROUP BY MONTH;";
            pStatement = connection.prepareStatement(preQueryStatement);
            pStatement.setInt(1, Integer.parseInt(id));
            ResultSet rs = pStatement.executeQuery();

            List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
            while (rs.next()) {
                Map<String, Object> row = new HashMap<String, Object>();

                row.put("labels", rs.getString("MONTH"));
                row.put("data", rs.getInt("NumBookings"));
                data.add(row);



            }
            pStatement.close();
            connection.close();
            return data;
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

    public List<Map<String, Object>> showMonthIncome(String id){
        Connection connection = null;
        PreparedStatement pStatement = null;
        try {
            connection = getConnection();
            String preQueryStatement = "SELECT MONTH(BkDate) AS MONTH, COUNT(*) AS NumBookings, SUM(Fee) AS Fee FROM Booking WHERE VenueID =? GROUP BY MONTH;";
            pStatement = connection.prepareStatement(preQueryStatement);
            pStatement.setInt(1, Integer.parseInt(id));
            ResultSet rs = pStatement.executeQuery();

            List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
            while (rs.next()) {
                Map<String, Object> row = new HashMap<String, Object>();

                row.put("labels", rs.getString("MONTH"));
                row.put("data", rs.getInt("Fee"));
                data.add(row);



            }
            pStatement.close();
            connection.close();
            return data;
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

    public List<Map<String, Object>> showYearIncome(String id){
        Connection connection = null;
        PreparedStatement pStatement = null;
        try {
            connection = getConnection();
            String preQueryStatement = "SELECT Year(BkDate) AS Year, COUNT(*) AS NumBookings, SUM(Fee) AS Fee FROM Booking WHERE VenueID =? GROUP BY Year;";
            pStatement = connection.prepareStatement(preQueryStatement);
            pStatement.setInt(1, Integer.parseInt(id));
            ResultSet rs = pStatement.executeQuery();

            List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
            while (rs.next()) {
                Map<String, Object> row = new HashMap<String, Object>();

                row.put("labels", rs.getString("Year"));
                row.put("data", rs.getInt("Fee"));
                data.add(row);



            }
            pStatement.close();
            connection.close();
            return data;
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

    public ArrayList<ChartData> selectMonthAttendance(String id){
        Connection connection = null;
        PreparedStatement pStatement = null;
        try {
            connection = getConnection();
            String preQueryStatement = "SELECT  MONTH(BkDate) AS Month, COUNT(*) AS TotalBookings, SUM(CASE WHEN checkState = 'check-out' THEN 1 ELSE 0 END) AS AttendedBookings, SUM(CASE WHEN checkState = 'cancel' THEN 1 ELSE 0 END) AS CancelledBookings FROM Booking WHERE MemberID = ? GROUP BY Month;";
            pStatement = connection.prepareStatement(preQueryStatement);
            pStatement.setInt(1, Integer.parseInt(id));
            ResultSet rs = pStatement.executeQuery();

            ArrayList<ChartData> list = new ArrayList<>();
            while (rs.next()) {
                ChartData data = new ChartData();
                data.setData((double) rs.getInt("AttendedBookings")/rs.getInt("TotalBookings"));
                data.setLabels(rs.getString("Month"));

                list.add(data);
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

    public ArrayList<ChartData> selectYearAttendance(String id){
        Connection connection = null;
        PreparedStatement pStatement = null;
        try {
            connection = getConnection();
            String preQueryStatement = "SELECT  Year(BkDate) AS Year, COUNT(*) AS TotalBookings, SUM(CASE WHEN checkState = 'check-out' THEN 1 ELSE 0 END) AS AttendedBookings, SUM(CASE WHEN checkState = 'cancel' THEN 1 ELSE 0 END) AS CancelledBookings FROM Booking WHERE MemberID = ? GROUP BY Year;";
            pStatement = connection.prepareStatement(preQueryStatement);
            pStatement.setInt(1, Integer.parseInt(id));
            ResultSet rs = pStatement.executeQuery();

            ArrayList<ChartData> list = new ArrayList<>();
            while (rs.next()) {
                ChartData data = new ChartData();
                data.setData((double) rs.getInt("AttendedBookings")/rs.getInt("TotalBookings"));
                data.setLabels(rs.getString("Year"));

                list.add(data);
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


