package com.revature.manager.service;

import com.revature.manager.model.Expense;
import java.util.List;

public interface ExpenseService {
    public int loginService();
    public interface viewAllExpenses{
        List<Expense> getAllExpenses();
    }
    public interface viewPendingExpenses{
        List<Expense> getPendingExpenses();
    }
    public void approveService(int managerId);
    public void rejectService(int managerId);
    void printExpenses(List<Expense> expenses);
    public String trim(String s, int maxLength);
}
