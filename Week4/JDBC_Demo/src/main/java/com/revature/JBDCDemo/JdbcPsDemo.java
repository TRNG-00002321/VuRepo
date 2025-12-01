package com.revature.JBDCDemo;

import java.sql.*;

public class JdbcPsDemo {
    static Connection conn = null;
    static PreparedStatement ps = null;
    static Statement stmt = null;
    static ResultSet rs = null;
    public static void main(String[] args) {
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb2","root","sqlpass");
            String query = "Insert into contact_list(name,email,phone_number) values(?,?,?)";
            ps = conn.prepareStatement(query);
            ps.setString(1, "Vu");
            ps.setString(2,"vu@revature.net");
            ps.setString(3, "123456789");
            ps.execute();
            ps.close();

            String selectQuery = "Select * from contact_list where name like ?";
            ps = conn.prepareStatement(selectQuery);
            ps.setString(1, "Vu");
            rs = ps.executeQuery();
            while(rs.next()){
                String name = rs.getInt("id") + " " + rs.getString("name").toUpperCase()
                        + " " + rs.getString("email");
            }

        }
        catch(SQLException e){
            e.printStackTrace();
        }

    }
}
