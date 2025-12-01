package com.revature.manager.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.revature.manager.dao.ExpenseDao;
import com.revature.manager.dao.ExpenseDaoImpl;
import com.revature.manager.model.Expense;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReportServiceImpl implements ReportService {
    private final ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    Scanner sc = new Scanner(System.in);
    ExpenseDao dao = new ExpenseDaoImpl();
    ExpenseService expenseService = new ExpenseServiceImpl();

    @Override
    public void generateReportByEmployee() {
        List<Integer> empIds = dao.getAllEmployeeId();
        System.out.print("Available Employee IDs: ");
        for (Integer empId : empIds) {
            System.out.print(empId + " ");
        }
        System.out.println();
        System.out.print("Enter an Employee ID to generate the report: ");
        int empId = sc.nextInt();
        List<Expense> expenses = new ArrayList<>();
        String fileName = "employee_" + empId + "_report.json";
        expenses = dao.getExpensesByEmployee(empId);
        writeJson(fileName, expenses);
        System.out.println("Report for Employee " + empId + " has been generated successfully.");
        System.out.println("Saved as: " + fileName);
        System.out.println();
    }

    @Override
    public void generateReportByCategory(List<Expense> expenses, String category) {
        String fileName = "category_report_" + category + ".json";
        writeJson(fileName, expenses);
    }

    @Override
    public void generateReportByDateRange() {
        System.out.print("Enter start from date: ");
        LocalDate start = LocalDate.parse(sc.nextLine());
        System.out.print("Enter end date to generate report: ");
        LocalDate end = LocalDate.parse(sc.nextLine());
        List<Expense> expenses = new ArrayList<>();
        String fileName = "date_report_" + start + "_to_" + end + ".json";
        expenses = dao.getExpensesByDateRange(start, end);
        writeJson(fileName, expenses);
        System.out.println("Date range report generated successfully");
        System.out.println();
    }

    private void writeJson(String filename, List<Expense> expenses){
        try {
            mapper.writeValue(new File(filename), expenses);
            System.out.println("Report generated: " + filename);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
