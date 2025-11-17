package com.revature.bank;

public class SavingAccount extends BankAccount implements SimpleInterest {
    public SavingAccount() {
    }

    public SavingAccount(String accountID, String accountName, double balance) {
        super(accountID, accountName, balance);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public double deposit(double amount) {
        return super.getBalance() + amount;
    }

    @Override
    public double withdraw(double amount) {
        double balance = super.getBalance() - amount;
        super.setBalance(balance);
        return balance;
    }

    @Override
    public double calculateInterest(double percentage) {
        double interest = super.getBalance() * (percentage/100);
        double balance = super.getBalance() + interest;
        super.setBalance(balance);
        return balance;
    }
}
