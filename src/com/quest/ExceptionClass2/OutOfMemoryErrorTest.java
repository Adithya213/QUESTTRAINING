package com.quest.ExceptionClass2;

public class OutOfMemoryErrorTest {
    public static void main(String[] args) {
        try {
            int[] arr = new int[Integer.MAX_VALUE];
            for (int i = 0; i < arr.length; i++) {
                arr[i]=i;
            }
        }catch (Throwable throwable){
            throwable.printStackTrace();
        }
    }
}
