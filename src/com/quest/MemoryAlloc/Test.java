package com.quest.MemoryAlloc;

public class Test {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("java");

        System.out.println("Append: " + sb.append(" programming"));

        System.out.println("Reverse: " + sb.reverse());
        sb.reverse();

        System.out.println("Replace : " + sb.replace(0, 4, "core"));

        System.out.println("Delete : " + sb.delete(4, sb.length()));

        System.out.println("Insert : " + sb.insert(4, " language"));

        System.out.println("CharAt() : " + sb.charAt(2));

        System.out.println("Length: " + sb.length());

    }
}

