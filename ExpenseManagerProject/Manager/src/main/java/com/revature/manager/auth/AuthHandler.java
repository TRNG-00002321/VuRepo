package com.revature.manager.auth;
import com.revature.manager.db.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class AuthHandler {
    public String authenticateUser(String userName, String pass) {
        String sql = "select * from users where username = ? and password = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, userName);
            stmt.setString(2, pass);
            try (ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    if(rs.getString("role").equals("manager")){
                        return rs.getString("id");
                    }
                    else{
                        System.out.println("Access denied!");
                        return null;
                    }
                }
                else{
                    System.out.println("Invalid username or password!");
                    return null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
