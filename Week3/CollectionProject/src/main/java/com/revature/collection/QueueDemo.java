package com.revature.collection;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<String> q = new PriorityQueue<String>();
        q.add("Vu");
        q.add("Alex");

        System.out.println(q);
//        System.out.println(q.poll()); // return and remove, if empty return null
        System.out.println(q.peek()); // return no remove
        System.out.println(q.remove()); // return and remove, if empty throw an exception
    }
}
