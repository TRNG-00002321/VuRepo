package com.revature.manager.service;

import com.revature.manager.dao.ExpenseDao;
import com.revature.manager.dao.ExpenseDaoImpl;
import com.revature.manager.model.Expense;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ReportServiceImpl implements ReportService {
    private static final Logger logger = LoggerFactory.getLogger(ReportServiceImpl.class);
    Scanner sc = new Scanner(System.in);
    ExpenseDao dao = new ExpenseDaoImpl();

    @Override
    public void generateReportMenu() {
        logger.info("Opening Report Menu.");
        while (true) {
            try {
                System.out.println();
                System.out.println("=== Report Menu ===");
                System.out.println("1. Generate Monthly Spending Report");
                System.out.println("2. Generate Report By Employee");
                System.out.print("Choose an option: ");
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        monthlyReport();
                        return;
                    case 2:
                        generateReportByEmployee();
                        return;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                        System.out.println();
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                System.out.println();
                sc.nextLine();
            }
        }
    }

    @Override
    public void monthlyReport() {
        logger.info("Starting Monthly Report generation.");
        int year;
        int month;
        while (true) {
            System.out.print("Enter the year (e.g., 2025): ");
            try {
                year = sc.nextInt();
                if (year >= 2000 && year <= LocalDate.now().getYear()) {
                    break;
                } else {
                    System.out.println("Invalid year. Please enter a valid year.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number!");
                sc.nextLine();
            }
        }

        while (true) {
            System.out.print("Enter the month (1–12): ");
            try {
                month = sc.nextInt();
                if (month >= 1 && month <= 12) {
                    break;
                } else {
                    System.out.println("Invalid month. Please enter 1–12.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number!");
                sc.nextLine();
            }
        }

        logger.info("Fetching monthly expenses for {}/{}", month, year);
        List<Expense> expenses = dao.getMonthlyExpenses(year, month);

        if (expenses.isEmpty()) {
            System.out.println("No expenses found for " + month + "/" + year);
            System.out.println();
            return;
        }

        double total = 0;
        double highest = Double.MIN_VALUE;
        double lowest = Double.MAX_VALUE;
        for (Expense e : expenses) {
            double amt = e.getAmount();
            total += amt;
            if (amt > highest) highest = amt;
            if (amt < lowest) lowest = amt;
        }
        double avg = total / expenses.size();

        System.out.println("\n------------- Summary --------------");
        System.out.printf("%-20s %-15s%n", "Total Expenses:", "$" + String.format("%.2f", total));
        System.out.printf("%-20s %-15d%n", "Number of Items:", expenses.size());
        System.out.printf("%-20s %-15s%n", "Average Expense:", "$" + String.format("%.2f", avg));
        System.out.printf("%-20s %-15s%n", "Highest Expense:", "$" + String.format("%.2f", highest));
        System.out.printf("%-20s %-15s%n", "Lowest Expense:", "$" + String.format("%.2f", lowest));
        System.out.println("-----------------------------------\n");
    }


    @Override
    public void generateReportByEmployee() {
        logger.info("Starting report generation by employee.");
        List<Integer> empIds = dao.getAllEmployeeId();
        System.out.print("Available Employee IDs: ");
        for (Integer empId : empIds) {
            System.out.print(empId + " ");
        }
        System.out.println();

        System.out.print("Enter an Employee ID to generate the report: ");
        int empId;
        try {
            empId = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a numeric Employee ID.");
            sc.nextLine();
            return;
        }

        if (!empIds.contains(empId)) {
            System.out.println("Employee " + empId + " does not exist.");
            return;
        }

        List<Expense> expenses = dao.getExpensesByEmployee(empId);
        List<Expense> approvedExpenses = dao.getApprovedExpensesByEmployee(empId);

        if (approvedExpenses.isEmpty()) {
            System.out.println("No expenses found for this employee.");
            return;
        }

        double totalAmount = approvedExpenses.stream()
                .mapToDouble(Expense::getAmount)
                .sum();

        int totalCount = approvedExpenses.size();
        double averageAmount = totalAmount / totalCount;

        double highest = approvedExpenses.stream()
                .mapToDouble(Expense::getAmount)
                .max()
                .orElse(0);

        double lowest = approvedExpenses.stream()
                .mapToDouble(Expense::getAmount)
                .min()
                .orElse(0);

        long approved = expenses.stream()
                .filter(e -> "approved".equalsIgnoreCase(e.getStatus()))
                .count();

        long rejected = expenses.stream()
                .filter(e -> "rejected".equalsIgnoreCase(e.getStatus()))
                .count();

        long pending = expenses.stream()
                .filter(e -> "pending".equalsIgnoreCase(e.getStatus()))
                .count();

        System.out.println("\n====================================");
        System.out.println("     Employee Expense Summary");
        System.out.println("====================================");

        System.out.printf("%-22s %-15s%n", "Employee ID:", empId);
        System.out.printf("%-22s %-15s%n", "Total Expenses:", "$" + String.format("%.2f", totalAmount));
        System.out.printf("%-22s %-15d%n", "Number of Items:", totalCount);
        System.out.printf("%-22s %-15s%n", "Average Expense:", "$" + String.format("%.2f", averageAmount));
        System.out.printf("%-22s %-15s%n", "Highest Expense:", "$" + String.format("%.2f", highest));
        System.out.printf("%-22s %-15s%n", "Lowest Expense:", "$" + String.format("%.2f", lowest));

        System.out.println("\n---------- Approval Status ----------");
        System.out.printf("%-22s %-10d%n", "Approved:", approved);
        System.out.printf("%-22s %-10d%n", "Rejected:", rejected);
        System.out.printf("%-22s %-10d%n", "Pending:", pending);
        System.out.println("-------------------------------------");
        System.out.println();
    }
}
