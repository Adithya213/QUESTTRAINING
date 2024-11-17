package com.quest.oops.test1;

public class RandomClass extends AbstractClass{

    @Override
    void drive() {
        System.out.println("I'm a random class.drive()");
    }

    void add(){
        System.out.println("I'm a random class.add()");
    }

    public static void main(String[] args) {
        RandomClass r = new RandomClass();
        r.drive();
        r.add();
    }
}
