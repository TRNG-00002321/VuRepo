package com.revature.employeemanagement;

public abstract class Employee {
    private String name;
    private double rate;
    private double payout;
    private String benefit = "None";

    public Employee() {
    }

    public Employee(String name, double rate) {
        this.name = name;
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", rate=" + rate +
                ", payout=" + payout +
                ", benefit='" + benefit + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getPayout() {
        return payout;
    }

    public void setPayout(double payout) {
        this.payout = payout;
    }

    public void setBenefit(String benefit) {
        this.benefit = benefit;
    }

    public String getBenefit() {
        return benefit;
    }
}
