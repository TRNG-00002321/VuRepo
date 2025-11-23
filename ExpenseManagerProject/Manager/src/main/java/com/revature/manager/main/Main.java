package com.revature.manager.main;
import java.util.*;
import com.revature.manager.dao.ApprovalDaoImpl;
import com.revature.manager.model.Expense;

public class Main {
    public static void main(String[] args) {

        ApprovalDaoImpl approvalDao = new ApprovalDaoImpl();


        approvalDao.approveExpense(1, 2,"valid expense");
        approvalDao.rejectExpense(2, 2,"invalid expense");
        List<Expense> approved = approvalDao.getAllExpenses();
        for(Expense e:approved){
            System.out.println(e.toString());
        }




    }
}
