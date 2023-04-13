package com.example.jsp_project.db;

import com.example.jsp_project.bean.Venue;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class FeeDB {
    private String url = "";
    private String username = "";
    private String password = "";

    public FeeDB(String url, String dbUser, String Password) {
        this.url = url;
        this.username = dbUser;
        this.password = Password;
    }
    public Connection getConnection() throws SQLException, IOException {
        System.setProperty("sql", "com.mysql.cj.jdbc.driver");
        return DriverManager.getConnection(url, username, password);
    }
    public void CreateFeeTable() {
        Statement stmnt = null;
        Connection cnnct = null;
        try {
            cnnct = getConnection();
            stmnt = cnnct.createStatement();
            String sql
                    = "CREATE TABLE IF NOT EXISTS bookingFee ("
                    + "FeeID int(5) NOT NULL,"
                    + "Year year(4) NOT NULL,"
                    + "VenueID int(5) NOT NULL,"
                    + "Fee int(20) NOT NULL,"
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


}
