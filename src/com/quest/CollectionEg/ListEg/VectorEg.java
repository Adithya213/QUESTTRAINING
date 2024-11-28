package com.quest.CollectionEg.ListEg;


import java.util.Vector;

public class VectorEg {
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<Integer>();
        v.add(1);
        v.add(2);
        v.add(3);
        v.add(4);
        System.out.println(v.size());
        System.out.println(v.get(1));
        System.out.println(v.add(5));
        System.out.println(v.contains(2));
        System.out.println(v.isEmpty());
        System.out.println(v.remove(3));
        System.out.println(v.firstElement());
        System.out.println(v.lastElement());

    }
}
