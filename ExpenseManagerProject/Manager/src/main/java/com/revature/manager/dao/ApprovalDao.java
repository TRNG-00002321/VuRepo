package com.revature.manager.dao;
import java.util.*;

import com.revature.manager.model.Expense;

public interface ApprovalDao {
    List<Expense> getPendingExpenses();
    List<Expense> getAllExpenses();
    void approveExpense(int expenseId, int managerId, String comment);
    void rejectExpense(int expenseId, int managerId, String comment);
}
