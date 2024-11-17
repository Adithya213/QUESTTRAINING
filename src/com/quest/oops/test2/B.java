package com.quest.oops.test2;

public class B {


    void add(int a, int b) {
      int c=a+b;
        System.out.println("B class Add:"+c);
    }
    void add(){
        System.out.println("B class Add No Arguments");
    }
    static void add(int a){
        System.out.println("Inside Class B static add"+a);
    }

}
