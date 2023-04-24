package com.example.jsp_project.db;

import com.example.jsp_project.bean.Cart;
import com.example.jsp_project.bean.Venue;

import javax.servlet.http.Part;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

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
                    + "State varchar(20) NOT NULL,"
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
    public boolean addVenue(String name, InputStream img, String type, String capacity, String location, String desc, String person, String state) {
        Connection connection = null;
        PreparedStatement pStatement = null;
        InputStream inputStream = null;
        boolean result = false;
        try {
            connection = getConnection();
            String preQueryStatement = "INSERT INTO Venue VALUES (NULL,?,?,?,?,?,?,?,?)";
            pStatement = connection.prepareStatement(preQueryStatement);
            pStatement.setString(1, name);
            pStatement.setBlob(2, img);
            pStatement.setString(3, type);
            pStatement.setInt(4, Integer.parseInt(capacity));
            pStatement.setString(5, location);
            pStatement.setString(6, desc);
            pStatement.setString(7, person);
            pStatement.setString(8, state);
//            pStatement.setInt(8, Integer.parseInt(fee));
            int rowInserted = pStatement.executeUpdate();
            if (rowInserted > 0) {
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

    public ArrayList<Venue> listVenue() {
        Connection connection = null;
        PreparedStatement pStatement = null;
        try {
            connection = getConnection();
            String preQueryStatement = "SELECT * FROM venue, bookingFee WHERE venue.VenueID = bookingFee.VenueID AND YEAR(Year) = YEAR(CURDATE());";
            pStatement = connection.prepareStatement(preQueryStatement);
            ResultSet rs = pStatement.executeQuery();
            ArrayList<Venue> list = new ArrayList<Venue>();
            while (rs.next()) {
                Venue venue = new Venue();
                venue.setId(rs.getString(1));
                venue.setName(rs.getString(2));
                venue.setImage(rs.getBytes(3));
                venue.setType(rs.getString(4));
                venue.setCapacity(String.valueOf(rs.getInt(5)));
                venue.setLocation(rs.getString(6));
                venue.setDescription(rs.getString(7));
                venue.setPerson(rs.getString(8));
                venue.setState(rs.getString(9));
                venue.setBookingFee(String.valueOf(rs.getInt(13)));
                list.add(venue);



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

    public boolean delVenue(String id) {
        Connection connection = null;
        PreparedStatement pStatement = null;
        int num = 0;
        try {
            connection = getConnection();
            String preQueryStatement = "DELETE FROM Venue WHERE VenueID=?";
            pStatement = connection.prepareStatement(preQueryStatement);
            pStatement.setInt(1, Integer.parseInt(id));
            num = pStatement.executeUpdate();
        } catch (SQLException ex) {
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
        Connection connection = null;
        PreparedStatement pStatement = null;
        Venue v = null;
        try {
            connection = getConnection();
            String preQueryStatement = "SELECT venue.*, bookingFee.Fee FROM bookingFee, Venue WHERE venue.VenueID=? AND venue.VenueID = bookingFee.VenueID AND YEAR(Year) = YEAR(CURDATE());";
            pStatement = connection.prepareStatement(preQueryStatement);
            pStatement.setInt(1, Integer.parseInt(id));
            ResultSet rs = null;
            rs = pStatement.executeQuery();
            if (rs.next()) {
                v = new Venue();
                v.setId(id);
                v.setName(rs.getString(2));
                v.setImage(rs.getBytes(3));
                v.setType(rs.getString(4));
                v.setCapacity(String.valueOf(rs.getInt(5)));
                v.setLocation(rs.getString(6));
                v.setDescription(rs.getString(7));
                v.setPerson(rs.getString(8));
                v.setState(rs.getString(9));
                v.setBookingFee(rs.getString(10));
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
        return v;
    }

    public boolean editVenue(String id, String name, InputStream img, String type, String capacity, String location, String desc, String person, String state, String fee) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int num = 0;
        try {
            connection = getConnection();
            String preQueryStatement = "UPDATE Venue SET  VenueName=? ,Img=? , VenueType=?, Capacity=? , Location=?, VenueDesc=?, VenuePerson=?, State=? WHERE VenueID=?";
            preparedStatement = connection.prepareStatement(preQueryStatement);
            preparedStatement.setString(1, name);
            preparedStatement.setBlob(2, img);
            preparedStatement.setString(3, type);
            preparedStatement.setInt(4, Integer.parseInt(capacity));
            preparedStatement.setString(5, location);
            preparedStatement.setString(6, desc);
            preparedStatement.setString(7, person);
            preparedStatement.setString(8, state);
            preparedStatement.setInt(9, Integer.parseInt(id));
            num = preparedStatement.executeUpdate();
            preQueryStatement = "UPDATE bookingFee SET Fee=? WHERE VenueID=?";
            preparedStatement = connection.prepareStatement(preQueryStatement);
            preparedStatement.setInt(1, Integer.parseInt(fee));
            preparedStatement.setInt(2, Integer.parseInt(id));
            num = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
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

    public List<Cart> getCartVenue(ArrayList<Cart> cartList) {
        List<Cart> venues = new ArrayList<Cart>();
        Connection connection = null;
        PreparedStatement pStatement = null;
        try {
            connection = getConnection();
            if (cartList.size() > 0) {
                for (Cart item:cartList){
                    String preQueryStatement = "SELECT * FROM venue, bookingFee WHERE venue.VenueID = bookingFee.VenueID AND YEAR(Year) = YEAR(CURDATE()) AND venue.VenueID=?;";
                    pStatement = connection.prepareStatement(preQueryStatement);
                    pStatement.setInt(1,Integer.parseInt(item.getId()));
                    ResultSet rs =null;
                    rs = pStatement.executeQuery();
                    while (rs.next()) {
                        Cart row= new Cart();
                        row.setId(rs.getString(1));
                        row.setName(rs.getString(2));
                        row.setImage(rs.getBytes(3));
                        row.setType(rs.getString(4));
                        row.setCapacity(String.valueOf(rs.getInt(5)));
                        row.setLocation(rs.getString(6));
                        row.setDescription(rs.getString(7));
                        row.setPerson(rs.getString(8));
                        row.setState(rs.getString(9));
                        row.setBookingFee(String.valueOf(rs.getInt(13)));
                        venues.add(row);
                    }
                }
                pStatement.close();
                connection.close();
            }
        } catch (Exception e) {

        }


        return venues;
    }


}
