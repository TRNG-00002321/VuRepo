package com.revature.myio;

import java.io.*;

public class BufferedDemo {

    public static void main(String[] args) throws Exception {
        try {
            lineStreamMethod();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void lineStreamMethod() throws Exception {
        BufferedReader inputStream = null;
        BufferedWriter outputStream = null;
        try {
            inputStream = new BufferedReader(new FileReader("example.txt"));
            outputStream = new BufferedWriter(new FileWriter("output3.txt"));
            String l;
            while ((l = inputStream.readLine()) != null) {
                outputStream.write(l);
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }

    }
}
