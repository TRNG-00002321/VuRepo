package com.revature.collection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<String>();
        myList.add("Alex");
        myList.add("Vu");
        myList.add("Bao");
        myList.add(1,"Perry");

        System.out.println(myList.get(1));

        Iterator itr = myList.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        for(int i=0;i<myList.size();i++){
            System.out.println(myList.get(i));
        }
        for(String str: myList)
            System.out.println(str);

        System.out.println(myList);



    }

}
