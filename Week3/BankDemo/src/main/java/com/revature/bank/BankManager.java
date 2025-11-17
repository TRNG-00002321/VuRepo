package com.revature.bank;

public class BankManager {
    public static void main(String[] args) {
        SavingAccount savingAccount = new SavingAccount("S001","Vu",20000);
        CheckingAccount checkingAccount = new CheckingAccount("C001","Vu",10000);
        savingAccount.withdraw(1000);
        System.out.println(savingAccount.getBalance());
        checkingAccount.withdraw(1000);
        System.out.println(checkingAccount.getBalance());
        System.out.println(checkingAccount);
    }
}
