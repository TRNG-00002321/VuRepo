package com.revature.PersonDemo;

public class PersonManager {
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person();
        p1.setName("Vu");
        p1.setAge(24);
        p2.setName("Vu");
        p2.setAge(24);
        System.out.println(p1);
        System.out.println("Name: " + p1.getName() + " Age: " + p1.getAge());
        if(p1.equals(p2)){
            System.out.println("P1 == P2");
        }
        else
            System.out.println("P1 != P2");
    }
}
