package com.revature.employeemanagement;
import  java.util.Scanner;

public class EmployeeManagement {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("\n=== Employee Menu ===");
            System.out.println("1. Add Salary Employee");
            System.out.println("2. Add Contractual Employee");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter employee name: ");
                    String sName = sc.nextLine();
                    System.out.println("Enter employee monthly salary: ");
                    double sMonthlySalary = sc.nextDouble();
                    System.out.println("Enter the days worked (over 20): ");
                    double daysWorked = sc.nextDouble();
                    SalaryEmployee s = new SalaryEmployee(sName, sMonthlySalary);
                    s.calculatePayout(daysWorked);
                    s.setBenefit("Food");
                    System.out.println(s.getName() + " made $" + s.getPayout() + " this period" );
                    break;

                case 2:
                    System.out.println("Enter employee name: ");
                    String cName = sc.nextLine();
                    System.out.println("Enter employee hourly rate: ");
                    double hRate = sc.nextDouble();
                    System.out.println("Enter the hours worked: ");
                    double hWorked = sc.nextDouble();
                    ContractualEmployee c = new ContractualEmployee(cName, hRate);
                    c.calculatePayout(hWorked);
                    System.out.println(c.getName() + " made $" + c.getPayout() + " this period" );
                    break;

                case 3:
                    System.out.println("Exiting program");
                    flag = false;
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }
        sc.close();
    }
}
