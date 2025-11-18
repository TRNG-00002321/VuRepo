package com.revature.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListAssignment {
    public static void main(String[] args) {
        List<String> arrayList1 = new ArrayList<String>();
        List<String> arrayList2 = new ArrayList<String>();
        List<String> linkedList = new LinkedList<String>();
        arrayList1.add("Alex");
        arrayList1.add("Vu");
        arrayList1.add("Bao");

        // Add all method
        arrayList2.addAll(arrayList1);

        // Iterate over a list from the end to beginning
        for(int i = arrayList1.size()-1;i>=0;i--){
            System.out.println(arrayList1.get(i));
        }

        // clear method
        arrayList1.clear();

        // contain method
        System.out.println(arrayList2.contains("Vu"));


    }
}
