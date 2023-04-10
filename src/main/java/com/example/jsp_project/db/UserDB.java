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

}
