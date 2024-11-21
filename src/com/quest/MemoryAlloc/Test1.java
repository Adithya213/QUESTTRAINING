package com.quest.MemoryAlloc;

public class Test1 {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = new String("Hello");

        StringBuffer a1 = new StringBuffer("Hello");
        StringBuffer a2 = new StringBuffer("World");
        StringBuilder b1 = new StringBuilder("Hello");
        StringBuilder b2 = new StringBuilder("World");

        System.out.println("Checking equality for String (literals and references)");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1.equals(s3));
        System.out.println(s1 == a1.toString());
        System.out.println(s1.equals(a1));

        System.out.println("\nChecking equality for StringBuffer and StringBuilder");
        System.out.println(a1 == a2);
        System.out.println(b1 == b2);
        System.out.println(a1.toString() == b1.toString());
        System.out.println(a1.equals(a2));
        System.out.println(b1.equals(b2));
        System.out.println(a1.equals(b2));


        System.out.println("\nStringBuffer methods:");
        a1.append(" World");
        System.out.println("append  "+a1);

        a1.insert(6, "Java ");
        System.out.println("insert " + a1);

        a1.replace(6, 11, "Python");
        System.out.println("replace: " + a1);

        a1.delete(6, 12);
        System.out.println("delete: " + a1);

        a1.reverse();
        System.out.println("reverse: " + a1);

        System.out.println(a1.charAt(0));



        System.out.println("\nStringBuilder methods:");
        b1.append(" World");
        System.out.println("append: " + b1);

        b1.insert(6, "Java ");
        System.out.println("insert: " + b1);

        b1.replace(6, 11, "Python");
        System.out.println("replace: " + b1);

        b1.reverse();
        System.out.println("reverse: " + b1);

    }
}
