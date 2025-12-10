package com.revature.manager.service;

import com.revature.manager.model.Expense;

import java.time.LocalDate;
import java.util.List;

public interface ReportService {
    void generateReportMenu ();
    void monthlyReport();
    void generateReportByEmployee();
}
