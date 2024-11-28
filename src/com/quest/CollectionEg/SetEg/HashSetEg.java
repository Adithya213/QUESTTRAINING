package com.quest.CollectionEg.SetEg;

import java.util.HashSet;

public class HashSetEg {
    public static void main(String[] args) {
        HashSet<Integer> h = new HashSet<>();
        System.out.println("This is hash set which will sort the data automatically");
        h.add(1);
        h.add(3);
        h.add(2);
        h.add(5);
        h.add(5);// set dont allow duplicates
        //h.add(null); //set will not allow null values
//        for (int i : h) {
//            System.out.println(i);
//        }
//        for (Integer i : h) {
//            System.out.println(i);
//        }
        System.out.println("Size is "+h.size());
        System.out.println("check empty or not "+h.isEmpty());
        System.out.println("check contains or not "+h.contains(2));
        System.out.println("removing 3 "+ h.remove(3));
        System.out.println(h);
        h.clear();
        System.out.println("after clearing "+h.isEmpty());





//        ArrayList<Integer> list = new ArrayList<>();
//        System.out.println("This is arraylist same order as you insert");
//        list.add(1);
//        list.add(3);
//        list.add(2);
//        list.add(5);
//        h.add(null);
//        for (int i : list) {
//            System.out.println(i);
//        }
    }
}
