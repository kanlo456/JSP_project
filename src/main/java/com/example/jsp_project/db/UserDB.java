package com.example.jsp_project.db;

import com.example.jsp_project.bean.User;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class UserDB {
    private String dbUrl ="";
    private String dbUser = "";
    private String dbPassword ="";

    public UserDB(String dbUrl, String dbUser, String dbPassword) {
        this.dbUrl = dbUrl;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
    }
    public Connection getConnection() throws SQLException, IOException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
    }

    public boolean isVaildUser(String user,String pwd){
        Connection connection =null;
        PreparedStatement pStatement=null;
        boolean isVaild =false;
        try {
            connection = getConnection();
            String preQueryStatement= "SELECT * FROM user WHERE name=? AND password=?";
            pStatement = connection.prepareStatement(preQueryStatement);
            pStatement.setString(1,user);
            pStatement.setString(2,pwd);
            ResultSet rs = null;
            rs = pStatement.executeQuery();
            if (rs.next()){
                isVaild =true;
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
        return isVaild;
    }
    public String getUserRole(String user,String pwd){
        String role ="";
        Connection connection =null;
        PreparedStatement pStatement=null;
        boolean isVaild =false;
        try {
            connection = getConnection();
            String preQueryStatement= "SELECT * FROM user WHERE name=? AND password=?";
            pStatement = connection.prepareStatement(preQueryStatement);
            pStatement.setString(1,user);
            pStatement.setString(2,pwd);
            ResultSet rs = null;
            rs = pStatement.executeQuery();
            if (rs.next()){
               role= rs.getString("role");
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
        return role;
    }

    public boolean addUser(String user, String pwd, String email,String phoneNum,String role){
        Connection connection =null;
        PreparedStatement pStatement=null;
        boolean result =false;
        try {
            connection = getConnection();
            String preQueryStatement= "INSERT INTO user VALUES (NULL,?,?,?,?,?)";
            pStatement = connection.prepareStatement(preQueryStatement);
            pStatement.setString(1,user);
            pStatement.setString(2,pwd);
            pStatement.setString(3,email);
            pStatement.setString(4,phoneNum);
            pStatement.setString(5,role);
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

    public ArrayList<User> listAllUser(){
        Connection connection =null;
        PreparedStatement pStatement=null;
        try {
            connection = getConnection();
            String preQueryStatement ="SELECT * FROM user";
            pStatement = connection.prepareStatement(preQueryStatement);
            ResultSet rs = pStatement.executeQuery();
            ArrayList<User> list = new ArrayList<User>();
            while (rs.next()){
                User user = new User();
                user.setId(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setEmail(rs.getString(4));
                user.setPhoneNumber(rs.getString(5));
                user.setRole(rs.getString(6));
                list.add(user);
            }
            return list;
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
        return null;
    }

    public void createUserDb(){
        Statement stmnt =null;
        Connection cnnct =null;
        try {
            cnnct = getConnection();
            stmnt = cnnct.createStatement();
            String sql
                    = "CREATE TABLE IF NOT EXISTS user("
                    + "UID int(30) NOT NULL,"
                    + "Name varchar(30) NOT NULL,"
                    + "Password varchar(30) NOT NULL, "
                    + "email varchar(30) NOT NULL ,"
                    + "PhoneNum int(10) NOT NULL,"
                    + "role varchar(20) NOT NULL ,"
                    + "PRIMARY KEY (UID)"
                    + ")";
            stmnt.execute(sql);
            stmnt.close();
            cnnct.close();

        }catch(SQLException e){
            while (e != null) {
                e.printStackTrace();
                e = e.getNextException();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
