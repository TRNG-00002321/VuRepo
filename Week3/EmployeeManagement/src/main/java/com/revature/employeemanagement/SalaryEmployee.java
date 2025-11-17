package com.revature.employeemanagement;

public class SalaryEmployee extends Employee implements Payout {

    public SalaryEmployee() {
    }

    public SalaryEmployee(String name, double rate) {
        super(name, rate);
    }


    @Override
    public String toString() {
        return "SalaryEmployee{} " + super.toString();
    }

    @Override
    public void calculatePayout(double daysWorked) {
        double payout = getRate() * (daysWorked/20);
        setPayout(payout);
    }
}
