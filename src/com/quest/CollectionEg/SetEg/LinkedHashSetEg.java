package com.quest.CollectionEg.SetEg;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetEg {
    public static void main(String[] args) {
        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("Hello");
        lhs.add("hai");
        lhs.add("Namasthe");

        for(String s : lhs){
            System.out.println(s);
        }

//        System.out.println("Size is "+lhs.size());
//        System.out.println("check empty or not "+lhs.isEmpty());
//        System.out.println("check contains or not "+lhs.contains(2));
//        System.out.println("removing 3 "+ lhs.remove(3));
//        System.out.println(lhs);
//        lhs.clear();
//        System.out.println("after clearing "+lhs.isEmpty());

        System.out.println("\nprinting elements using iterator");
        Iterator<String> it = lhs.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
