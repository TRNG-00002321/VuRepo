package com.revature.myio.serialize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadEmpObj {

    public static void main(String[] args) {
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream;

        try {
            fileInputStream= new FileInputStream("employee.dat");
            objectInputStream= new ObjectInputStream(fileInputStream);
            Employee emp = (Employee) objectInputStream.readObject();
            System.out.println(emp);
        }
        catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
        catch(ClassNotFoundException e){
            throw new RuntimeException(e);
        }


    }
}
