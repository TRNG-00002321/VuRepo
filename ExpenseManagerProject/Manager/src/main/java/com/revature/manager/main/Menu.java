package com.revature.manager.main;

import com.revature.manager.service.ExpenseServiceImpl;
import com.revature.manager.service.ReportServiceImpl;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private ExpenseServiceImpl expenseServiceImpl = new ExpenseServiceImpl();
    private ReportServiceImpl reportServiceImpl = new ReportServiceImpl();
    private Scanner sc  = new Scanner(System.in);

    public void managerMenu(int managerId){
        while(true){
            try {
                System.out.println("=== Manager Menu ===");
                System.out.println("1. View All Expenses");
                System.out.println("2. View Pending Expenses");
                System.out.println("3. Approve An Expense");
                System.out.println("4. Reject An Expense");
                System.out.println("5. Generate report");
                System.out.println("6. Logout");
                System.out.print("Choose an option: ");
                int choice = sc.nextInt();
                sc.nextLine();
                switch(choice){
                    case 1:
                        expenseServiceImpl.viewAllExpenses();
                        break;
                    case 2:
                        expenseServiceImpl.viewPendingExpenses();
                        break;
                    case 3:
                        expenseServiceImpl.approveService(managerId);
                        break;
                    case 4:
                        expenseServiceImpl.rejectService(managerId);
                        break;
                    case 5:
                        reportServiceImpl.generateReportMenu();
                        break;
                    case 6:
                        System.out.println("Logging out...");
                        return;

                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 8.");
                        System.out.println();
                }
            }
            catch (InputMismatchException e){
                System.out.println("Invalid input. Please enter a valid number.");
                System.out.println();
                sc.nextLine();
            }
        }
    }
}
