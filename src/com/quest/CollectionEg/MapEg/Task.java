package com.quest.CollectionEg.MapEg;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class Task {
    public static void main(String[] args) {
        HashMap<Object, Double> hashMap = new HashMap<>();
        LinkedHashMap<Object, Double> linkedHashMap = new LinkedHashMap<>();
        TreeMap<Object, Double> treeMap = new TreeMap<>();

        hashMap.put(true, 10.5);
       // hashMap.put(true, 11.5);//dont allow duplicates
        hashMap.put(false, 20.3);
        hashMap.put(null, 5.0); // HashMap allows null keys
        hashMap.put(1.1, 15.2);
        hashMap.put(2.2, 25.4);
        hashMap.put(3.3, 35.5);

        linkedHashMap.put(true, 10.5);
        linkedHashMap.put(false, 20.3);
        linkedHashMap.put(null, 5.0); // LinkedHashMap allows null keys
        linkedHashMap.put(1.1, 15.2);
        linkedHashMap.put(2.2, 25.4);
        linkedHashMap.put(3.3, 35.5);

        treeMap.put(true, 10.5);
        treeMap.put(false, 20.3);
        treeMap.put(1.1, 15.2); // TreeMap does not allow null keys
        treeMap.put(2.2, 25.4);//and we cannot give same datatype for keys in treemap. because it need to sort.ClassCastException error
        treeMap.put(3.3, 35.5);

        // Performing some methods on HashMap
        System.out.println("HashMap: " + hashMap);
        System.out.println("HashMap contains key 'true': " + hashMap.containsKey(true));
        System.out.println("HashMap get key '2.2': " + hashMap.get(2.2));
        hashMap.remove(null);
        System.out.println("HashMap after removing 'null' key: " + hashMap);

        // Performing some methods on LinkedHashMap
        System.out.println("\nLinkedHashMap: " + linkedHashMap);
        System.out.println("LinkedHashMap keys: " + linkedHashMap.keySet());
        System.out.println("LinkedHashMap values: " + linkedHashMap.values());
        linkedHashMap.clear();
        System.out.println("LinkedHashMap after clear: " + linkedHashMap);

        // Performing some methods on TreeMap
        System.out.println("\nTreeMap: " + treeMap);
        System.out.println("TreeMap first key: " + treeMap.firstKey());
        System.out.println("TreeMap last key: " + treeMap.lastKey());
        treeMap.replace(true, 50.0);
        System.out.println("TreeMap after replacing 'true' value: " + treeMap);
    }
}

