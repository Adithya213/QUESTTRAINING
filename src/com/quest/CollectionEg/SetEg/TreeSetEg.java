package com.quest.CollectionEg.SetEg;

import java.util.TreeSet;

public class TreeSetEg {
    public static void main(String[] args) {
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(1);
        ts.add(3);
        ts.add(2);
        ts.add(5);
        System.out.println(ts);
        for (Integer i : ts) {
            System.out.println(i);
        }
        System.out.println("First "+ts.first());
        System.out.println("Last "+ts.last());
        System.out.println("Decending order "+ts.descendingSet());
        System.out.println("Floor "+ts.floor(3));
        System.out.println("accessing First"+ts.first());
        System.out.println("accessing Last"+ts.last());
    }
}
