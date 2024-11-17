package com.quest.oops.Inheritance;

public class Developer extends Employee {

    public Developer(String name) {
        super(name);//explicit supercalling stt to call superclass constructor
    }

    @Override
    void work() {
        super.work();
        System.out.println(name + " is developing an app.");
    }
}
