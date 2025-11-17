package com.revature.employeemanagement;

public class ContractualEmployee extends Employee implements Payout {

    public ContractualEmployee() {
    }

    public ContractualEmployee(String name, double rate) {
        super(name, rate);
    }

    @Override
    public String toString() {
        return "ContractualEmployee{} " + super.toString();
    }

    @Override
    public void calculatePayout(double hourWorked) {
        double payOut = getRate() * hourWorked;
        setPayout(payOut);
    }
}
