package com.quest.MemoryAlloc;

public class Stringcomparision {
    public static void main(String[] args) {
        String s1 = "hello";//s1 and s2 are string literals
        String s2 = "hello world";
        String s3 = new String("hello");//s3 and s4 are string reference
        String s4 = new String("hello world");
        //so in heap only 1 value will store ie, hello. beacuse all are same

        String s5 =s4;//passing reference so s4 and s5 has same ref address.
       // check(s4,s5);


//        int i1=1;
//        int i2=1;
//        check2(i1,i2);



        //System.out.println("result "+s1==s2);
        // System.out.println("result"+ s1.equals(s2));
        // System.out.println("s1  "+s1.hashCode());//reference  of s1
        // System.out.println("s2 "+s2.hashCode());
        // System.out.println("s1 "+s1);
       // check(s1, s2);
      //check(s3,s4);

        //check3(s3,s4);
        check3(s1,s2);
    }

    public static void check(String s1, String s2) {
        if (s1 == s2) {//it will check reference. sometimes it will check content when pass literals-s1,s2
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        if (s1.equals(s2)) {//it will check content
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        if(s1.contains(s2)) {//use s3 and s4
            System.out.println(true);
        }else {
            System.out.println(false);
        }
    }

    public static void check2(int i1, int i2) { // for primitive type == will check content
        if (i1 == i2) {
            System.out.println(true);
        }else {
            System.out.println(false);
        }
    }

    public static void check3(String s1, String s2) {
        if(s1.equals("hello")) {
            System.out.println(true);
        }else {
            System.out.println(false);
        }
        if (s2.contains("hello")) {
            System.out.println(true);
        }
        else {
            System.out.println(false);
        }
    }
}
