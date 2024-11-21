package com.quest.oops.Abstraction;

public class OfflineStudent extends Student {
    @Override
    public void attendClass() {
        System.out.println("Offline student attending Class");
    }

    @Override
    public void submitAssignment() {
        System.out.println("Offline student submit assignment");
    }
}