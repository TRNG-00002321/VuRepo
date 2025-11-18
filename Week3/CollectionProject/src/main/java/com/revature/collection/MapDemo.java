package com.revature.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo {
    public static void main(String[] args) {
        Map<String,Double> persons = new HashMap<>();
        persons.put("Vu",10000.00);
        persons.put("Alex",15000.00);
        persons.put("Peter", 20000.00);
        // persons.put("Alex",20000.00);

        System.out.println(persons.get("Alex"));

        Set<String> names = persons.keySet();
        for (String name : names) {
            System.out.println(name+", " + persons.get(name));
        }

    }
}
