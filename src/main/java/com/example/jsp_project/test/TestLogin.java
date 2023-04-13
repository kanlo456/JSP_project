package com.example.jsp_project.test;

import com.example.jsp_project.bean.Role;
import com.example.jsp_project.db.RoleDB;
import com.example.jsp_project.db.UserDB;

import java.util.ArrayList;

public class TestLogin {
    public static void main(String[] arg) {
        String url = "jdbc:mysql://localhost:3306/ITP4511_Project";
        String username = "root";
        String password = "";
        ArrayList users = new ArrayList<>();
        UserDB user = new UserDB(url, username, password);
        RoleDB role = new RoleDB(url,username,password);
//        user.createUserDb();
//        System.out.println(user.isVaildUser("Peter", "12345678"));
//        System.out.println(user.getUserRole("Peter", "12345678"));
//        user.addUser("ME", "1234567", "erqwae", "213232333", "Member");
//        users = user.listAllUser();
//        System.out.println(users.size());
//        System.out.println(user.queryUserByID("1").getUsername());
//        System.out.println(user.userEdit("1","Ken","12345678","1231232","123213123","Member"));
        System.out.println(role.listAllRole());
        System.out.println(role.addRole("4","me"));
    }
}
