package com.revature.manager.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static java.lang.Integer.parseInt;


public class AuthHandler {
    public int authenticateUser(String userName, String pass) {
        String sql = "select * from users where username = ? and password = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, userName);
            stmt.setString(2, pass);
            try (ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    if(rs.getString("role").equals("manager")){
                        System.out.println("Successfully logged in");
                        return parseInt(rs.getString("id"));
                    }
                    else{
                        System.out.println("Access denied!");
                        return -1;
                    }
                }
                else{
                    System.out.println("Invalid username or password!");
                    return -1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

}
