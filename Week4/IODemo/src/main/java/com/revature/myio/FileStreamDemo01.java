package com.revature.myio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileStreamDemo01 {
    static FileInputStream fileInputStream;
    static FileOutputStream fileOutputStream;

    public static void main(String[] args) {
        try {
            fileInputStream = new FileInputStream("example.txt");
            fileOutputStream = new FileOutputStream("output1.txt");
            int c;
            // c = fileInputStream.read();
            while ((c = fileInputStream.read()) != -1) {
                //System.out.write(c);
                fileOutputStream.write(c);
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
