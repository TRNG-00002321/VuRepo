package com.revature.manager.service;

import com.revature.manager.model.Expense;

import java.time.LocalDate;
import java.util.List;

public interface ReportService {
    void generateReportByEmployee();
    void generateReportByCategory(List<Expense> expenses, String category);
    void generateReportByDateRange();
}
