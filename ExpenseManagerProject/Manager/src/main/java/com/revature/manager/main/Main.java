package com.revature.manager.main;
import com.revature.manager.service.ExpenseService;
import com.revature.manager.service.ExpenseServiceImpl;
import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        ExpenseService service = new ExpenseServiceImpl();
        int managerId = service.loginService();
        if(managerId != -1) {
            System.out.println();
            Menu menu = new Menu();
            menu.managerMenu(managerId);
        }
        else {
            System.out.println("Login failed. Exiting...");
        }
    }
}
