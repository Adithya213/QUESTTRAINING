package com.quest.CollectionEg.SetEg;

import java.util.*;

public class SetTask {
    public static void main(String[] args) {
        // Task 1
        Set<Integer> hashSet1 = new HashSet<>();//1st obj
        Set<Integer> linkedHashSet1 = new LinkedHashSet<>();
        Set<Integer> treeSet1 = new TreeSet<>();

        for (int i = 1; i <= 100; i++) { //adding data upto 100 to 1st obj
            hashSet1.add(i);
            linkedHashSet1.add(i);
            treeSet1.add(i);
        }
        System.out.println("HashSet1 Elements: " + hashSet1);
        System.out.println("LinkedHashSet1   : " + linkedHashSet1);
        System.out.println("TreeSet1 Elements: " + treeSet1);

        // Task 2
        Set<Integer> hashSet2 = new HashSet<>();  // 2nd obj
        Set<Integer> linkedHashSet2 = new LinkedHashSet<>();
        Set<Integer> treeSet2 = new TreeSet<>();

        int[] elements = {42, 7, 15, 23, 99, 56, 3, 87, 21, 68}; //adding 10 elements (not sequentially)
        for (int e : elements) {
            hashSet2.add(e);
            linkedHashSet2.add(e);
            treeSet2.add(e);
        }

        System.out.println("\nHashSet2 Elements    : " + hashSet2);// not keep insertion order
        System.out.println("LinkedHashSet2 Elements: " + linkedHashSet2);//keep insertion order
        System.out.println("TreeSet2 Elements      : " + treeSet2);//sort

        Set<String> hashSet4 = new HashSet<>();  // 2nd obj
        Set<String> linkedHashSet4 = new LinkedHashSet<>();
        Set<String> treeSet4 = new TreeSet<>();
        String[] arr ={"grape","banana","apple","watermelon","dates","lychee"};
        for (String s : arr) {
            hashSet4.add(s);
            linkedHashSet4.add(s);
            treeSet4.add(s);
        }
        System.out.println("\nHashSet4 Elements    : " + hashSet4);
        System.out.println("LinkedHashSet4 Elements: " + linkedHashSet4);
        System.out.println("TreeSet4 Elements      : " + treeSet4);

        // Task 3:
        Set<Integer> hashSet3 = new HashSet<>(); //3rd obj
        Set<Integer> linkedHashSet3 = new LinkedHashSet<>();

        Integer[] dataWithNulls = {40, null, 20, null, 30, null,40,20}; // adding elements containing null
        for (Integer data : dataWithNulls) {
            hashSet3.add(data);
            linkedHashSet3.add(data);
        }

        System.out.println("\nHashSet3    : " + hashSet3);//allow single null , but not allow duplicates ,not maintain insertion order
        System.out.println("LinkedHashSet3: " + linkedHashSet3);//allow single null ,but not allow duplicates,maintain insertion order

        // TreeSet does not allow null values- because it need to sort elements.
        Set<Integer> treeSet3 = new TreeSet<>();
        try {
            for (Integer data : dataWithNulls) {
                treeSet3.add(data);
            }
            System.out.println("TreeSet3 Elements: " + treeSet3);
        } catch (NullPointerException e) {
            System.out.println("Cannot add null values to TreeSet " + e);
        }
        SortedSet<Integer> st = new TreeSet<>();
    }
}
