package com.quest.CollectionEg.ListEg.ArrayList;

import java.util.ArrayList;
import java.util.Iterator;

public class MainPerson2 {
    public static void main(String[] args) {

        ArrayList<Person2> list = new ArrayList<>();

        list.add(new Person2("Vineetha", 18, "USA", "Female"));
        list.add(new Person2("Bob", 22, "China", "Male"));
        list.add(new Person2("Vikas", 19, "Africa", "Male"));
        list.add(new Person2("Daisy", 25, "India", "Female"));
        list.add(new Person2("Daisy", 25, "India", "Female"));



        System.out.println("People with age < 20:");
        for (Person2 person : list) {
            if (person.getAge() < 20) {
                System.out.println(person);
            }
        }

        System.out.println("\nPeople with age > 20:");
        Iterator<Person2> iterator = list.iterator();
        while (iterator.hasNext()) {
            Person2 person = iterator.next();
            if (person.getAge() > 20) {
                System.out.println(person);
            }
        }
    }
}

