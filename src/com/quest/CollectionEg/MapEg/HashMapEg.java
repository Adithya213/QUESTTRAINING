package com.quest.CollectionEg.MapEg;

import java.util.HashMap;
import java.util.Map;

public class HashMapEg {
    public static void main(String[] args) {
        HashMap<Integer, String> hm = new HashMap<>();
        hm.put(6, "Banana");
        hm.put(2, "Pineapple");
        hm.put(3, "Apple");
        hm.put(4, "Orange");
        hm.put(null, "Mango");
        hm.put(1, "Watermelon");
        System.out.println(hm); // natural sorting also occurs here based on key
        for (String s : hm.values()) {
            System.out.println(s);
        }
        for (Integer i : hm.keySet()) {
            System.out.println(i);
        }
        for(Map.Entry<Integer,String> e:hm.entrySet()){//to iterate
            System.out.println(e.getKey() + " " + e.getValue());
        }




        System.out.println("getting value "+hm.get(1)+" "+hm.get("Mango")); //it will only accept key not value
        System.out.println(hm.remove(1) + " " + hm.remove("Mango"));
        System.out.println(hm);
        System.out.println(hm.put(2,"Grape"));//to modify the value
        System.out.println(hm);
        hm.clear();
        System.out.println(hm.isEmpty());
    }
}
