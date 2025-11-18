package com.revature.collection;

import java.util.*;


public class EmployeeManager {
    public static void main(String[] args) {
        Employee emp1 = new Employee(003,"Vu","60000");
        Employee emp2 = new Employee(004 , "Alex", "65000");
        Employee emp3 = new Employee(001, "Peter", "63000");
        Employee emp4 = new Employee(002, "Bao", "68000");
        Employee emp5 = new Employee(005, "John", "45000");
        List<Employee> emps = new ArrayList<Employee>();
        emps.add(emp1);
        emps.add(emp2);
        emps.add(emp3);
        emps.add(emp4);
        emps.add(emp5);

        Collections.sort(emps);
        System.out.println("\nSorted by ID:");
        System.out.println(emps);

        Collections.sort(emps, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println(emps);

        Collections.sort(emps, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getSalary().compareTo(o2.getSalary());
            }
        });
        System.out.println(emps);
    }
}
