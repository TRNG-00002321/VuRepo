package com.revature.myio.assignment;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

public class ReadStudentJson {
    public static void main(String[] args) {
        try{
            ObjectMapper mapper = new ObjectMapper();

            List<Student> students = mapper.readValue(
                    new File("student.json"),
                    new TypeReference<List<Student>>(){}
            );
            for (Student student : students) {
                System.out.println(student);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
