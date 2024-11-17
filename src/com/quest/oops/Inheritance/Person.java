package com.quest.oops.Inheritance;

import java.sql.SQLOutput;

public class Person {
     String name;
     int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void nameDisplay(){
        String msg=String.format("Person name: %s and age is %a",name,age);
        System.out.println(this.name);
        System.out.println(msg);
    }
}
