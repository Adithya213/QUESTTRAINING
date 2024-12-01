package com.quest.ExceptionClass2;

public class StackOverflowErrorTest {
    public static void main(String[] args) {
        try {
            StackOverflowErrorTest test = new StackOverflowErrorTest();
            test.recurse();
        } catch (Exception throwable) {
            throwable.printStackTrace();
        }
    }
    public void recurse() {
        recurse();
    }
}
