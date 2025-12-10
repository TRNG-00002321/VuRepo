package com.revature.manager.service;
import com.revature.manager.dao.AuthHandler;
import com.revature.manager.dao.*;
import com.revature.manager.model.Expense;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExpenseServiceImpl implements ExpenseService {
    private static final Logger logger = LoggerFactory.getLogger(ExpenseServiceImpl.class);
    private final AuthHandler loginHandler = new AuthHandler();
    private final ExpenseDaoImpl dao = new ExpenseDaoImpl();
    Scanner sc = new Scanner(System.in);

    @Override
    public int loginService() {
        System.out.println("=== Manager Login ===");
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();
        int managerId = loginHandler.authenticateUser(username, password);
        if (managerId != -1) {
            logger.info("Login successful for username: {}", username);
        } else {
            logger.warn("Failed login attempt for username: {}", username);
        }
        return managerId;
    }

    public List<Integer> empIds(){
        logger.info("Fetching all employee IDs.");
        return dao.getAllEmployeeId();
    }

    public void viewAllExpenses(){
        logger.info("Fetching all expenses for viewing.");
        List<Expense> expenses = dao.getAllExpenses();
        System.out.println();
        printExpenses(expenses);
        System.out.println();
    }

    public List<Expense> viewPendingExpenses(){
        logger.info("Fetching all pending expenses.");
        List<Expense> expenses = dao.getPendingExpenses();
        System.out.println();
        printExpenses(expenses);
        System.out.println();
        return expenses;
    }

    @Override
    public void approveService(int managerId) {
        logger.info("Manager {} is attempting to approve an expense.", managerId);
        List<Expense> expenses = dao.getPendingExpenses();
        List<Integer> expIds =  dao.getAllPendingExpenseId();
        System.out.println();
        if(!expenses.isEmpty()){
            System.out.println("PENDING EXPENSES TO BE APPROVED");
            printExpenses(expenses);
            System.out.println();
            while(true){
                try {
                    System.out.print("Enter a valid Expense ID to approve: ");
                    int expenseId = sc.nextInt();
                    sc.nextLine();
                    if(expIds.contains(expenseId)){
                        System.out.print("Enter comment: ");
                        String approveComment = sc.nextLine();
                        dao.approveExpense(expenseId, managerId, approveComment);
                        System.out.println("Expense " + expenseId + " approved successfully.");
                        System.out.println();
                        break;
                    }
                    else {
                        System.out.println("Expense ID not found in the pending list.");
                        System.out.println();
                    }
                }
                catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    System.out.println();
                    sc.nextLine();
                }
            }
        }
        else {
            System.out.println("There is no expense to be approved");
            System.out.println();
        }
    }

    @Override
    public void rejectService(int managerId) {
        logger.info("Manager {} is attempting to reject an expense.", managerId);
        List<Expense> expenses = dao.getPendingExpenses();
        List<Integer> expIds =  dao.getAllPendingExpenseId();
        System.out.println();
        if(!expenses.isEmpty()){
            System.out.println("PENDING EXPENSES TO BE REJECTED");
            printExpenses(expenses);
            System.out.println();
            while(true){
                try {
                    System.out.print("Enter a valid Expense ID to reject: ");
                    int expenseId = sc.nextInt();
                    sc.nextLine();
                    if (expIds.contains(expenseId)){
                        System.out.print("Enter comment: ");
                        String rejectComment = sc.nextLine();
                        dao.rejectExpense(expenseId, managerId, rejectComment);
                        System.out.println("Expense " + expenseId + " rejected successfully.");
                        System.out.println();
                        break;
                    }
                    else {
                        System.out.println("Expense ID not found in the pending list.");
                        System.out.println();
                    }
                }
                catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    System.out.println();
                    sc.nextLine();
                }
            }
        }
        else{
            System.out.println("There is no expense to be rejected");
            System.out.println();
        }
    }

    public void printExpenses(List<Expense> expenses){
        if(expenses.isEmpty()){
            System.out.println("No expenses found");
            return;
        }
        System.out.printf("%-10s %-8s %-10s %-30s %-12s %-10s%n",
                "ExpID", "UserID", "Amount", "Description", "Date", "Status");
        System.out.println("--------------------------------------------------------------------------------");

        for (Expense e : expenses) {
            System.out.printf("%-10d %-8d %-10s %-30s %-12s %-10s%n",
                    e.getExpenseId(),
                    e.getUserId(),
                    "$" + e.getAmount(),
                    trim(e.getDescription(), 30),
                    e.getDate(),
                    e.getStatus()
            );
        }
    }
    public String trim(String s, int maxLength) {
        if (s == null) return "";
        if (s.length() <= maxLength) return s;
        return s.substring(0, maxLength - 3) + "...";
    }
}
