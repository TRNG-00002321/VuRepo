package com.revature.bank;

public class CheckingAccount extends BankAccount {
    public CheckingAccount() {
    }

    public CheckingAccount(String accountID, String accountName, double balance) {
        super(accountID, accountName, balance);
    }

    @Override
    public String toString() {
        return "CheckingAccount{} " + super.toString();
    }

    @Override
    public double deposit(double amount) {
        return super.getBalance() + amount;
    }

    @Override
    public double withdraw(double amount) {
        double balance = super.getBalance() - amount * 1.0001;
        super.setBalance(balance);
        return balance;
    }
}
