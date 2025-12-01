package com.revature.manager.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:sqlite:C:/Train_QA/VuLocalRepo/ExpenseManagerProject/Employee/expenses.db";

    public static Connection getConnection() {
        try{
            return DriverManager.getConnection(URL);
        }
        catch(SQLException e){
            System.out.println("Connection Failed! " + e.getMessage());
            return null;
        }
    }

}
