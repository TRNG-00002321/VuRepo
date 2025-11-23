package com.revature.assignment;

public class Main {
    public static void main(String[] args) {
        Address address = new Address("5235", "Gold Pond Dr", 76170);
        Person p1 = new Person("Vu", "6239523345", address);
        Person p2 = new Person("Alex", "2426345234", null);
        System.out.println(p1);
        System.out.println(p2);
        checkAddress(p1);
        checkAddress(p2);

    }
    public static void checkAddress(Person person){
        if (person.getAddress().isPresent()) {
            System.out.println("Address exists!");
        }
        else {
            System.out.println("Address not exists!");
        }
    }
}
