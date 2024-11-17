package com.quest.oops.Inheritance;

public class MainClass {
    public static void main(String[] args) {
        Developer developer = new Developer("Adithya");
        Tester tester = new Tester("Ron");

        developer.work();
        tester.work();
    }

}
