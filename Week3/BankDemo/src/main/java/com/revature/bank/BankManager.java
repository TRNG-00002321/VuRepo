package com.revature.bank;
import java.util.Scanner;

public class BankManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while(flag){
            System.out.println("\n===== BANK MANAGER MENU =====");
            System.out.println("1. Add a checking account");
            System.out.println("2. Add a saving account");
            System.out.println("3. Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    System.out.println("Enter Your Bank ID:");
                    String checkingID = sc.nextLine();
                    System.out.println("Enter Your Name:");
                    String checkingName = sc.nextLine();
                    System.out.println("Enter Your Balance:");
                    double checkingBalance = sc.nextDouble();
                    CheckingAccount c = new CheckingAccount(checkingID,checkingName,checkingBalance);
                    try{
                        System.out.println("Enter amount to withdraw: ");
                        double withdrawAmount = sc.nextDouble();
                        sc.nextLine();
                        if(withdrawAmount < 0){
                            throw new IllegalArgumentException("Cannot withdraw negative amount");
                        }
                        if (withdrawAmount > c.getBalance()){
                            System.out.println("Insufficient funds");
                            break;
                        }
                        if(c.getBalance() < 5000){
                            System.out.println("Withdrawal denied. Balance must be at least 5000.");
                            break;
                        }
                        c.withdraw(withdrawAmount);
                        System.out.println("Withdrawal successful.");
                    }
                    catch(IllegalArgumentException e){
                        System.out.println("ERROR: " + e.getMessage());
                    }
                    catch(Exception e){
                        System.out.println("Invalid input. Please enter a valid number.");
                        break;
                    }
                    sc.nextLine();

                case 2:
                    System.out.println("Enter Your Bank ID:");
                    String bankID = sc.nextLine();
                    System.out.println("Enter Your Name:");
                    String name = sc.nextLine();
                    System.out.println("Enter Your Balance:");
                    double balance = sc.nextDouble();
                    SavingAccount s = new SavingAccount(bankID,name,balance);


                case 3:
                    System.out.println("Exiting program!");
                    flag = false;
                    break;
            }
        }
        sc.close();
    }
}

