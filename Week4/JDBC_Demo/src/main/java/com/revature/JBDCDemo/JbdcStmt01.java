package com.revature.JBDCDemo;

import java.sql.*;

public class JbdcStmt01 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        //Step 1. Load the driver -- Optional
        try{
            // Class.forName("com.mysql.cj.jdbc.Driver");

            //Step 2. Create the connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb2","root","sqlpass");
            // Step 3. create the statement obj
            stmt = conn.createStatement();
            String selectQuery = "Select * from contact_list";
            //Step 4. execute the query and collect the result in result set
            rs = stmt.executeQuery(selectQuery);
            //Step 5 process the result set
            while(rs.next()){
                System.out.println(rs.getInt("id") +", "+ rs.getString(2)+", "
                + rs.getString("email"));
            }

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        System.out.println("Connected to database successfully");
    }
}
