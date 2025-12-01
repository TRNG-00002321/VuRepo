package com.revature.myio.serialize;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteEmpObj {
    public static void main(String[] args) {

        Employee emp = new Employee(01, "Vu", "Fort Worth", "Engineer");  // your Employee object

        try (FileOutputStream fileOutputStream = new FileOutputStream("employee.dat");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

            objectOutputStream.writeObject(emp);
            System.out.println("Employee object written successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
