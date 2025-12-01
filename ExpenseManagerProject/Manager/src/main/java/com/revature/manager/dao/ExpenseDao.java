package com.revature.manager.dao;
import java.time.LocalDate;
import java.util.*;

import com.revature.manager.model.Expense;

public interface ExpenseDao {
    List<Expense> getPendingExpenses();
    List<Expense> getAllExpenses();
    List<Expense> getExpensesByEmployee(int empId);
    List<Expense> getExpensesByCategory(String category);
    List<Expense> getExpensesByDateRange(LocalDate start, LocalDate end);
    List<Integer> getAllEmployeeId();
    void approveExpense(int expenseId, int managerId, String comment);
    void rejectExpense(int expenseId, int managerId, String comment);
}
