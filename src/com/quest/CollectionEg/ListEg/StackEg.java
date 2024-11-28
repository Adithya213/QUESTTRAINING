package com.quest.CollectionEg.ListEg;

import java.util.Stack;

public class StackEg {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
      //  System.out.println(stack.pop());
       // System.out.println(stack.peek());
       // System.out.println(stack.search(1));
       // System.out.println(stack.add(4));
        System.out.println(stack);
        System.out.println(stack.get(0));
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }
}
