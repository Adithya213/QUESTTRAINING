package com.quest.oops.Inheritance;

public class Employee {
    String name;

    public Employee(String name) {
        this.name = name;
    }

    void work() {
        System.out.println(name + " is working.");
    }
}
