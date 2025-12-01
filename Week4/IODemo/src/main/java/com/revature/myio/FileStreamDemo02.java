// Character stream

package com.revature.myio;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileStreamDemo02 {

    public static void main(String[] args) {
        try{
            charStreamMethod();
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }
    public static void charStreamMethod() throws Exception {
        FileReader fr = null;
        FileWriter fw = null;

        try {
            fr = new FileReader("example.txt");
            fw = new FileWriter ("output2.txt");
            int c;
            while ((c = fr.read()) != -1) {
                fw.write(c);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            if(fr!=null){
                fr.close();
            }
            if(fw!=null){
                fw.close();
            }

        }
    }
}
