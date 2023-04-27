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

    public ArrayList<Order> listMemberOrder(String memberID) {
        Connection connection = null;
        PreparedStatement pStatement = null;
        try {
            connection = getConnection();
            String preQueryStatement = "SELECT * FROM booking WHERE MemberID =?";
            pStatement = connection.prepareStatement(preQueryStatement);
            pStatement.setString(1,memberID);
            ResultSet rs = pStatement.executeQuery();
            ArrayList<Order> list = new ArrayList<Order>();
            while (rs.next()) {
                Order order = new Order();
                order.setBookingID(rs.getString(1));
                order.setVenueID(rs.getString(2));
                order.setMemberID(rs.getString(3));
                order.setTotalFee(rs.getString(4));
                order.setBookingDate(rs.getString(5));
                order.setStartTime(rs.getString(6));
                order.setEndTime(rs.getString(7));
                order.setHour(rs.getString(8));
                order.setRqState(rs.getString(9));
                order.setCheckState(rs.getString(10));
//                user.setId(rs.getString(1));
//                user.setUsername(rs.getString(2));
//                user.setPassword(rs.getString(3));
//                user.setEmail(rs.getString(4));
//                user.setPhoneNumber(rs.getString(5));
//                user.setRole(rs.getString(6));
                list.add(order);
            }
            return list;
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (pStatement != null) {
                try {
                    pStatement.close();
                } catch (SQLException e) {
                }
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                    }
                }
            }
        }
        return null;
    }

    public ArrayList<Guest> bookingGuestList(String bookingID) {
        Connection connection = null;
        PreparedStatement pStatement = null;
        try {
            connection = getConnection();
            String preQueryStatement = "SELECT * FROM guest WHERE BkingID =?";
            pStatement = connection.prepareStatement(preQueryStatement);
            pStatement.setString(1,bookingID);
            ResultSet rs = pStatement.executeQuery();
            ArrayList<Guest> list = new ArrayList<Guest>();
            while (rs.next()) {
                Guest guest = new Guest();
                guest.setGuestID(rs.getString(1));
                guest.setBookingID(rs.getString(2));
                guest.setGName(rs.getString(3));
                guest.setEmail(rs.getString(4));
//                user.setId(rs.getString(1));
//                user.setUsername(rs.getString(2));
//                user.setPassword(rs.getString(3));
//                user.setEmail(rs.getString(4));
//                user.setPhoneNumber(rs.getString(5));
//                user.setRole(rs.getString(6));
                list.add(guest);
            }
            return list;
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (pStatement != null) {
                try {
                    pStatement.close();
                } catch (SQLException e) {
                }
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                    }
                }
            }
        }
        return null;
    }
    public boolean deleteGuest(String guestID){
        Connection connection =null;
        PreparedStatement pStatement=null;
        int num =0;
        try {
            connection = getConnection();
            String preQueryStatement ="DELETE FROM guest WHERE GuestID = ?";
            pStatement = connection.prepareStatement(preQueryStatement);
            pStatement.setString(1,guestID);
            pStatement.executeUpdate();
        }catch (SQLException ex){
            while (ex!=null){
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (pStatement !=null){
                try {
                    pStatement.close();
                }catch (SQLException e){
                }
                if (connection !=null){
                    try {
                        connection.close();
                    }catch (SQLException e){

                    }
                }
            }
        }
        return (num==1)?true:false;
    }
    public boolean guestEdit(String guestId, String guestName,String guestEmail){
        Connection connection =null;
        PreparedStatement pStatement=null;
        int num=0;
        try {
            connection = getConnection();
            String preQueryStatement ="UPDATE guest SET Name=?,Email=? WHERE GuestID=?";
            pStatement = connection.prepareStatement(preQueryStatement);
            pStatement.setString(1,guestName);
            pStatement.setString(2,guestEmail);
            pStatement.setString(3,guestId);
            num = pStatement.executeUpdate();
        }catch (SQLException ex){
            while (ex!=null){
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (pStatement !=null){
                try {
                    pStatement.close();
                }catch (SQLException e){
                }
                if (connection !=null){
                    try {
                        connection.close();
                    }catch (SQLException e){
                    }
                }
            }
        }
        return (num==1)?true:false;
    }

}
