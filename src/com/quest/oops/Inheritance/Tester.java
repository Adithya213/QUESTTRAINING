package com.quest.oops.Inheritance;

public class Tester extends Employee {

    public Tester(String name) {
        super(name);
    }

    @Override
    void work() {
        super.work();
        System.out.println(name + " is testing an app.");
    }
}

