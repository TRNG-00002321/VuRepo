package com.revature.collection;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeDemo {
    public static void main(String[] args) {
        Deque<String> d = new ArrayDeque<String>();
        d.add("Vu");
        d.add("Bao");
        d.add("Alex");
        d.add("Peter");

        System.out.println(d);
        System.out.println(d.peekFirst()); // return first element no remove
        System.out.println(d.peekLast()); // return last element no remove
        System.out.println(d.pollFirst()); // return and remove first element, if empty return null
        System.out.println(d.pollLast()); // return and remove last element, if empty return null
        System.out.println(d.removeFirst()); // return and remove first element, if empty throw an exception
        System.out.println(d.removeLast()); // return and remove last element, if empty throw an exception
    }
}
