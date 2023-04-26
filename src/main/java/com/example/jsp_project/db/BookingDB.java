package com.example.jsp_project.db;

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
    public List<Map<String, Object>> showGraph(){
        Connection connection = null;
        PreparedStatement pStatement = null;
        try {
            connection = getConnection();
            String preQueryStatement = "SELECT VenueID, COUNT(*) AS NumBookings FROM booking GROUP BY VenueID;";
            pStatement = connection.prepareStatement(preQueryStatement);
            ResultSet rs = pStatement.executeQuery();
//            List<ChartData> dataList = new ArrayList<>();
            List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
            while (rs.next()) {
                Map<String, Object> row = new HashMap<String, Object>();
//                ChartData chartData = new ChartData();
//                chartData.setLabels(Collections.singletonList(rs.getString(1)));
//                chartData.setData(Collections.singletonList(Integer.parseInt(rs.getString(2))));
//                list.add(chartData);
                row.put("labels", rs.getString("VenueID"));
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

}
