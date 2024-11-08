package com.quest.practice1;

public class practiceOperators {
    public static void main(String[] args) {
        int a = 10;
        int b = 5;
        // Arithmetic operators
        System.out.println(a + b);
        System.out.println(a * b);
        System.out.println(a - b);
        System.out.println(a / b);
        System.out.println(a % b);

        //Relationals Operators
        System.out.println(a == b);
        System.out.println(a != b);
        System.out.println(a < b);
        System.out.println(a <= b);
        System.out.println(a > b);
        System.out.println(a >= b);


        boolean x = true;
        boolean y = false;
        //Logical Operators
        System.out.println(x && y);
        System.out.println(x || y);
        System.out.println(x != y);

        //Assignment op
        int v = 10;
        v += 5;//z=z+5


        //Unary Operators
        int z = 15;
        System.out.println(z);
        System.out.println(z++);
//        z=16
        System.out.println(++z);
        System.out.println(z);
        System.out.println(z--);
        System.out.println(--z);

        //ternary operator
        int p = 10;
        int q = 5;

        int result = p > 15 ? ++q : 0;
        System.out.println(result);
    }
}
