package com.quest.CollectionEg.QueueEg;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Stack;

public class PriorityQueueEg {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<String> pq2 = new PriorityQueue<>();
// IT IS FIFO manner
        pq.add(1);
        pq.add(2);
        pq.add(3);
        pq.add(4);
        pq.add(8);
        pq.add(5);
        pq.add(7);
        pq.add(9);

        pq2.add("ac");
        pq2.add("ad");
        pq2.add("ae");
        pq2.add("af");
        pq2.add("ag");

//        Iterator<Integer> it = pq.iterator();
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }

//        System.out.println(pq2.size());
        System.out.println(pq2.peek()); //FIFO
//       System.out.println(pq2.poll());
        System.out.println(pq2);

        Stack<String> stack = new Stack<>();
        stack.push("ac");
        stack.push("ad");
        stack.push("ae");
        stack.push("af");
        stack.push("ag");
        System.out.println(stack.peek()); //LIFO
        System.out.println(stack);
    }
}
