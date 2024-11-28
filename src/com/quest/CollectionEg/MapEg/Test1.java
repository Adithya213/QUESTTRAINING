package com.quest.CollectionEg.MapEg;

import java.util.HashMap;
import java.util.TreeMap;

public class Test1 {
    public static void main(String[] args) {
        HashMap<Integer,String> hashMap = new HashMap();
        TreeMap<Integer,String> treeMap = new TreeMap();
        hashMap.put(3,"a");
        hashMap.put(1,"c");
        hashMap.put(2,"b");
        hashMap.put(2,"d");
        hashMap.put(2,"d");

        treeMap.put(3,"a");
        treeMap.put(1,"c");
        treeMap.put(2,"b");
        treeMap.put(2,"d");
        treeMap.put(2,"d");

        System.out.println(hashMap +"\n"+treeMap);
    }
}
