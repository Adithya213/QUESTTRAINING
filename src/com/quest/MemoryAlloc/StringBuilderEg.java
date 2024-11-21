package com.quest.MemoryAlloc;

public class StringBuilderEg {
    public static void main(String[] args) {
        StringBuilder s1 = new StringBuilder("hello");
        StringBuilder s2 = new StringBuilder("hello");
       // check(s1,s2);
        //System.out.println(s2.append(" world $"));
        //System.out.println(s2.reverse());
        //System.out.println(s2.replace(0,3,"z"));
       // System.out.println(s2.delete(1,3));
        //System.out.println(s2.insert(5,"world"));
        System.out.println(s1.charAt(2));

        String s3 = "hello";
        String s4="world";
        String s5= s3+s4;
       // System.out.println(s5);
    }

    public static void check(StringBuilder s1, StringBuilder s2) {
        if(s1==s2){
        System.out.println(true);
        }else {
            System.out.println(false);
        }
        if(s1.equals(s2)) {
            System.out.println(true);
        }else {
            System.out.println(false);
        }
    }
}
