package com.quest.CollectionEg.ListEg;

import com.quest.CollectionEg.ListEg.ArrayList.Person1;

import java.util.LinkedList;

public class LinkedListEg {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Ron");
        list.add("Benoy");
        list.add("jane");
        list.add("james");//

        list.addFirst("Manu");
        list.addLast("Gopi");
        list.add(4,"Alice");
        System.out.println("This is 1st element " +list.getFirst());
        System.out.println("This is last element " +list.getLast());
        System.out.println("getting element at index 1 "+list.get(1));
        System.out.println("removing element at index 1 "+list.removeFirst());
        System.out.println("removing element at index 1 "+list.removeLast());
        System.out.println("removing element at index 1 "+list.remove(2));
        System.out.println("removing element at index 1 "+list.remove());//default index is 0
        list.clear();
          System.out.println("size is "+ list.size());

        for (String l : list){
          //  System.out.println(l);
        }

        LinkedList<String> list2 = new LinkedList<>();
        System.out.println(list2.isEmpty());//to check data is present or not in list2
        System.out.println(list.isEmpty());//to check data is present or not in list

        System.out.println(list.contains("ss") + " :"+ list.contains("Alice"));//to check if element is present in list

        Person1 person1 = new Person1();//to remove particular
        list.remove(person1);
    }
}
