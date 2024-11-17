package com.quest.oops.Abstraction;

public class RegularStudent extends Student {

    @Override
    public void attendClass() {
        System.out.println("attending online and offline classes");
    }

    @Override
    public void submitAssignment() {
        System.out.println("regular student submitting the assignment");
    }
}
