package com.revature.manager.dao;
import java.time.LocalDate;
import java.util.*;

import com.revature.manager.model.Expense;

public interface ExpenseDao {
    List<Expense> getPendingExpenses();
    public List<Integer> getAllPendingExpenseId();
    List<Expense> getAllExpenses();
    List<Expense> getExpensesByEmployee(int empId);
    public List<Expense> getApprovedExpensesByEmployee(int empId);
    List<Integer> getAllEmployeeId();
    void approveExpense(int expenseId, int managerId, String comment);
    void rejectExpense(int expenseId, int managerId, String comment);
    List<Expense> getMonthlyExpenses(int year, int month);
}
