package com.example.jsp_project.db;

import com.example.jsp_project.bean.Role;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class RoleDB {

    private String dbUrl = "";
    private String dbUser = "";
    private String dbPassword = "";

    public RoleDB(String dbUrl, String dbUser, String dbPassword) {
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

    public ArrayList<Role> listAllRole() {
        Connection connection = null;
        PreparedStatement pStatement = null;
        try {
            connection = getConnection();
            String preQueryStatement = "SELECT * FROM management";
            pStatement = connection.prepareStatement(preQueryStatement);
            ResultSet rs = pStatement.executeQuery();
            ArrayList<Role> list = new ArrayList<Role>();
            while (rs.next()) {
                Role role = new Role();
                role.setId(rs.getString(1));
                role.setRole(rs.getString(2));
                list.add(role);
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
    public boolean deleteRole(String id){
        Connection connection =null;
        PreparedStatement pStatement=null;
        int num =0;
        try {
            connection = getConnection();
            String preQueryStatement ="DELETE FROM management WHERE MID = ?";
            pStatement = connection.prepareStatement(preQueryStatement);
            pStatement.setString(1,id);
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
    public boolean roleEdit(String id,String role){
        Connection connection =null;
        PreparedStatement pStatement=null;
        int num=0;
        try {
            connection = getConnection();
            String preQueryStatement ="UPDATE management SET MID=?,role=? WHERE MID=?";
            pStatement = connection.prepareStatement(preQueryStatement);
            pStatement.setString(1,id);
            pStatement.setString(2,role);
            pStatement.setString(3,id);
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
    public boolean addRole(String id, String role){
        Connection connection =null;
        PreparedStatement pStatement=null;
        boolean result =false;
        try {
            connection = getConnection();
            String preQueryStatement= "INSERT INTO management VALUES (?,?)";
            pStatement = connection.prepareStatement(preQueryStatement);
            pStatement.setString(1,id);
            pStatement.setString(2,role);
            int rowInserted = pStatement.executeUpdate();
            if (rowInserted>0){
                System.out.println("Updated");
            }
            pStatement.close();
            connection.close();
        }catch (SQLException ex){
            while (ex!=null){
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return false;
    }
}
