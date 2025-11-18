package com.revature.collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String[] args) {
        // Set<String> names = new HashSet<>();
        // Set<String> names = new LinkedHashSet<String>();
        Set<String> names = new TreeSet<String>();
        names.add("Andrew");
        names.add("James");
        names.add("John");

        System.out.println(names);

        for(String name: names){
            System.out.println(name);
        }

        // Remove method
        names.remove("John");
        System.out.println(names);

        // checking if the set is empty
        System.out.println(names.isEmpty());

        // checking size method
        System.out.println(names.size());

        // remove all method
        names.removeAll(names);
        System.out.println(names);




    }
}
