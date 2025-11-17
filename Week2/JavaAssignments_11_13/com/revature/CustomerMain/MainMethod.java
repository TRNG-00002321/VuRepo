package com.revature.CustomerMain;

public class MainMethod {
    public static void main(String[] args) {
        Customer cus1 = new Customer();
        Customer cus2 = new Customer(81,"Vu",24,"vu681@revature.net","5094851024");
        cus1.printInfo();
        cus2.printInfo();
    }
}
