package com.quest.practice1;

public class TypeCasting {
    public static void main(String[] args) {
        //implicit
        int n=5;
        double d=n;
        System.out.println(d);

        //expliciit
        double d1=9.78;
        int n1=(int)d1; // o/p - 9(9,78 round off to lowest integer)
        System.out.println(n1);

        int n3=200;
        byte b=(byte)n3; // o/p = -56
        System.out.println(b);

    }
}
