package com.revature.collection;

import java.util.ArrayList;
import java.util.List;

public class PersonCollection {
    public static void main(String[] args) {
        Person person1 = new Person("001","Vu", 24);
        Person person2 = new Person("002","Alex", 22);
        Person person3 = new Person("003","Bao", 18);
        List<Person> myList = new ArrayList<Person>();
        myList.add(person1);
        myList.add(person2);
        myList.add(person3);

        for(int i=0;i<myList.size();i++){
            System.out.println(myList.get(i));
        }
        for(Person p: myList){
            System.out.println(p);
        }
    }
}
