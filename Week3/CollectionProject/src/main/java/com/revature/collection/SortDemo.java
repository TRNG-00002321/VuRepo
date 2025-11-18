package com.revature.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortDemo {
    public static void main(String[] args) {
        List<String> names = new ArrayList<String>();
        names.add("John");
        names.add("Bao");
        names.add("Alex");
        names.add("Vu");

        System.out.println(names);

        // Sort in natural order
        Collections.sort(names);
        System.out.println(names);

        // Sort in reversed order
        Collections.sort(names,Collections.reverseOrder());
        System.out.println(names);
    }
}
