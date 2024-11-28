package com.quest.CollectionEg.ListEg.ArrayList;

import java.util.ArrayList;
import java.util.Iterator;

public class abc {
    public static void main(String[] args) {
        ArrayList<Person1> list = new ArrayList<Person1>();


        list.add(new Person1("Arun", 19));
        list.add(new Person1("Ron", 23));
        list.add(new Person1("Vikas", 34));
        String a = list.get(1).getName();
        //System.out.println(a);
        //list.remove(2);
        for (Person1 person : list) {
            //   System.out.println(person.getName() + " : " + person.getAge());
        }
        for (Person1 person : list) {
            if (person.getAge() > 20) {
                // System.out.println(person.getName() + " : " + person.getAge());
            }
        }
        Iterator<Person1> iterator = list.iterator();
        while (iterator.hasNext()) {
            Person1 person = iterator.next();
            if (person.getAge() < 20) {
                System.out.println(person.getName());
                System.out.println(person.getAge());
            }
        }


        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        for (int i : list1) {
            // System.out.println(i);
        }

    }

}
