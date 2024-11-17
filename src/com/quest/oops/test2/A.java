package com.quest.oops.test2;

public class A extends B {
    public static void main(String[] args) {
        A a = new A();
        a.add(5, 8);
    }

    A() {
        System.out.println("A class constructor");
    }

    void add() {
        this.add();//to access child
        System.out.println("A class Add method with no Arguments");
    }

    @Override
    void add(int a, int b) {
        super.add(a, b);//to access parent
        int c = a + b;
        System.out.println("A class Add method with arguments " + c);
    }

    static void add(int a) {
        System.out.println("A inside static add" + a);
    }



    //we can create class like this
//    class C extends B {
//
//    }
}
