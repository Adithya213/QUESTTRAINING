package com.quest.CollectionEg.MapEg;

import java.util.TreeMap;

public class TreeMapEg {
    public static void main(String[] args) {
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("John", "Wick");
        treeMap.put("Mary", "Alex");
        treeMap.put("Mad", "Max");
        treeMap.put("Don", "Bosco");
//another way for printing
        treeMap.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });

        System.out.println("replaced "+ treeMap.replace("Mary","Alex","Ram"));
        System.out.println(treeMap);

        TreeMap<Integer,String> treeMap2 = new TreeMap<>();
        treeMap2.put(1, "Bmw");
        treeMap2.put(2, "Audi");
        treeMap2.put(4, "Kia");
        treeMap2.put(3, "Honda");
        treeMap2.put(5, "Ferrari");
        System.out.println(treeMap2);

        System.out.println(treeMap2.get(1));
        System.out.println(treeMap2.isEmpty());
        treeMap2.clear();

    }
}
