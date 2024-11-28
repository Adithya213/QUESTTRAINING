package com.quest.CollectionEg.MapEg;

import java.util.LinkedHashMap;
import java.util.Map;
public class LinkedHashMapEg {
    public static void main(String[] args) {

        LinkedHashMap<String, Double> linkedHashMap = new LinkedHashMap<>();//string - key and double - value

        //1 Add elements using put
        linkedHashMap.put("Apple", 1.5);
        linkedHashMap.put("Banana", 0.8);
        linkedHashMap.put("Orange", 2.0);
        linkedHashMap.put("Mango", 1.2);
        System.out.println("Initial LinkedHashMap: " + linkedHashMap);
        System.out.println("Key   ---  value ");
        linkedHashMap.forEach((k, v) -> System.out.println(k + ": " + v));

        //2 Access an element using get()
        System.out.println("Price of Banana: " + linkedHashMap.get("Banana"));

        //3 Check if a key exists
        System.out.println("Contains key 'Orange': " + linkedHashMap.containsKey("Orange"));

        //4 Check if a value exists
        System.out.println("Contains value 1.2: " + linkedHashMap.containsValue(1.2));

        //5 Remove an element
        linkedHashMap.remove("Mango");
        System.out.println("After removing Mango: " + linkedHashMap);

        //6 Iterating over the LinkedHashMap using entrySet
        System.out.println("Iterating over LinkedHashMap:");
        for (Map.Entry<String, Double> entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        //7 Check size
        System.out.println("Size of LinkedHashMap: " + linkedHashMap.size());

        //8 Replace a value
        linkedHashMap.replace("Apple", 1.8);
        System.out.println("After replacing value for Apple: " + linkedHashMap);
        linkedHashMap.put("Apple", 2.0);
        System.out.println("After replacing value for Apple: " + linkedHashMap);

        //9 Clear the LinkedHashMap
        linkedHashMap.clear();
        System.out.println("After clearing: " + linkedHashMap);

        //10 Check if empty
        System.out.println("Is LinkedHashMap empty? " + linkedHashMap.isEmpty());
    }
}
