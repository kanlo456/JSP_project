package com.example.jsp_project.db;

import java.io.IOException;
import java.sql.*;

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
