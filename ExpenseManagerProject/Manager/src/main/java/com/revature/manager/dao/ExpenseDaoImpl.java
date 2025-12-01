package com.revature.manager.dao;

import java.time.LocalDate;
import java.util.*;

import com.revature.manager.model.Expense;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ExpenseDaoImpl implements ExpenseDao {
    @Override
    public List<Expense> getPendingExpenses() {
        List<Expense> list = new ArrayList<>();
        String query = "SELECT expenses.id AS expenses_id, expenses.user_id, expenses.amount, expenses.description, "+
                "expenses.date, approvals.status FROM expenses LEFT JOIN approvals ON approvals.expense_id = expenses.id "+
                "WHERE (approvals.status = 'pending') ORDER BY expenses.date DESC";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()){

            while(rs.next()){
                Expense e = new Expense(
                        rs.getInt("expenses_id"),
                        rs.getInt("user_id"),
                        rs.getDouble("amount"),
                        rs.getString("description"),
                        rs.getString("date"),
                        rs.getString("status"),
                        0,
                        null,
                        null
                );
                list.add(e);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Expense> getAllExpenses() {
        List<Expense> list = new ArrayList<>();
        String query = "SELECT expenses.id AS expenses_id, expenses.user_id, expenses.amount, expenses.description, "+
                "expenses.date, approvals.status, approvals.reviewer_id, approvals.comments, approvals.review_date " +
                "FROM expenses LEFT JOIN approvals ON approvals.expense_id = expenses.id "+
                "ORDER BY expenses.date DESC";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()){

            while(rs.next()){
                Expense e = new Expense(
                        rs.getInt("expenses_id"),
                        rs.getInt("user_id"),
                        rs.getDouble("amount"),
                        rs.getString("description"),
                        rs.getString("date"),
                        rs.getString("status"),
                        rs.getInt("reviewer_id"),
                        rs.getString("comments"),
                        rs.getString("review_date")
                );
                list.add(e);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Expense> getExpensesByEmployee(int empId) {
        List<Expense> list = new ArrayList<>();

        String query = "SELECT expenses.id AS expenses_id, expenses.user_id, expenses.amount, expenses.description, " +
                "expenses.date, approvals.status, approvals.reviewer_id, approvals.comments, approvals.review_date " +
                "FROM expenses LEFT JOIN approvals ON approvals.expense_id = expenses.id " +
                "WHERE expenses.user_id = ? ORDER BY expenses.date DESC";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, empId);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Expense e = new Expense(
                        rs.getInt("expenses_id"),
                        rs.getInt("user_id"),
                        rs.getDouble("amount"),
                        rs.getString("description"),
                        rs.getString("date"),
                        rs.getString("status"),
                        rs.getInt("reviewer_id"),
                        rs.getString("comments"),
                        rs.getString("review_date")
                );
                list.add(e);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Expense> getExpensesByCategory(String category) {
        return List.of();
    }

    @Override
    public List<Expense> getExpensesByDateRange(LocalDate start, LocalDate end) {
        List<Expense> list = new ArrayList<>();

        String query = "SELECT expenses.id AS expenses_id, expenses.user_id, expenses.amount, expenses.description, " +
                "expenses.date, approvals.status, approvals.reviewer_id, approvals.comments, approvals.review_date " +
                "FROM expenses LEFT JOIN approvals ON approvals.expense_id = expenses.id " +
                "WHERE expenses.date BETWEEN ? AND ? ORDER BY expenses.date DESC";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1, start.toString());
            stmt.setString(2, end.toString());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Expense e = new Expense(
                        rs.getInt("expenses_id"),
                        rs.getInt("user_id"),
                        rs.getDouble("amount"),
                        rs.getString("description"),
                        rs.getString("date"),
                        rs.getString("status"),
                        rs.getInt("reviewer_id"),
                        rs.getString("comments"),
                        rs.getString("review_date")
                );
                list.add(e);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Integer> getAllEmployeeId() {
        List<Integer> ids = new ArrayList<>();

        String query = "SELECT DISTINCT user_id FROM expenses ORDER BY user_id";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                ids.add(rs.getInt("user_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ids;
    }

    @Override
    public void approveExpense(int expenseId, int managerId, String comment) {
        String query = "UPDATE approvals SET status = 'approved', reviewer_id = ?, comments = ?, review_date = CURRENT_DATE WHERE expense_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setInt(1, managerId);
            stmt.setString(2, comment);
            stmt.setInt(3, expenseId);
            stmt.executeUpdate();
            System.out.println("Approved Expense with ID: " + expenseId);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void rejectExpense(int expenseId, int managerId, String comment) {
        String query = "UPDATE approvals SET status = 'denied', reviewer_id = ?, comments = ?, review_date = CURRENT_DATE WHERE expense_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setInt(1, managerId);
            stmt.setString(2, comment);
            stmt.setInt(3, expenseId);
            stmt.executeUpdate();
            System.out.println("Denied Expense with ID: " + expenseId);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}