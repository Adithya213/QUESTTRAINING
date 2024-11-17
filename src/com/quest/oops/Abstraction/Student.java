package com.quest.oops.Abstraction;


//abstact class
public abstract class Student {
    // abstract method has no imp
    public abstract void attendClass();

    public abstract void submitAssignment();
    //concrete method has impl

    public void study() {
        System.out.println("Student study");
    }
}