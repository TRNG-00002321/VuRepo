package com.revature.myio.assignment;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class WriteStudentJson {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter ow = mapper.writerWithDefaultPrettyPrinter();
        try{
            Student s1 = new Student("Bao",20);
            Student s2 = new Student("Alex",22);
            Student s3 = new Student("John", 25);
            List<Student> list = new ArrayList<>();
            list.add(s1);
            list.add(s2);
            list.add(s3);

            ow.writeValue(new File("student.json"), list);
            System.out.println("Successfully wrote student.json");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
