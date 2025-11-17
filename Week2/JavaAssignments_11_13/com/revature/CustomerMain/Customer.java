package com.revature.CustomerMain;

public class Customer {
    final int id;
    String name;
    int age;
    String email;
    String phone;
    static int customerCount = 0;

    public Customer(){

        id = 0;
        name = "Unknown";
        age = 0;
        email = "Unknown";
        phone = "Unknown";
    }
    public Customer(int id, String name, int age, String email, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        customerCount++;
    }
    public void updateInfo(String email){
        this.email = email;
    }
    public void updateInfo(String name, int age, String email, String phone) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }
    public void printInfo(){
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
    }
}
