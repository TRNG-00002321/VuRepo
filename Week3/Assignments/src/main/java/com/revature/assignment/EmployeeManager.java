package com.revature.assignment;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    public static void main(String[] args) {
        Employee e1 = new Employee("Vu", 24, 50000);
        Employee e2 = new Employee("Bao", 18, 15000);
        Employee e3 = new Employee("Alex", 22, 55000);
        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);

        // display using enhanced for loop
        for (Employee e:employees){
            System.out.println(e);
        }

        // display using for each loop
        employees.forEach(e -> System.out.println(e));
        employees.stream().forEach(e -> System.out.println(e));

        // return all names in upper case
        employees.stream().map(e -> e.getName().toUpperCase()).forEach(System.out::println);

        // create a new list of employee objects having salary > 20k
        List<Employee> result = employees.stream().filter(e->e.getSalary()>20000).toList();
        System.out.println(result);
    }
}
