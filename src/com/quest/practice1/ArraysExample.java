package com.quest.practice1;

public class ArraysExample {
    public static void main(String[] args) {
        //1D array
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i; // array initialization
        }
        // to display the array using foreach loop
        for (int x : arr) {
            System.out.println(x);
        }


          //2D array
        int[][] arr2 = new int[10][10];
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                arr2[i][j] = j+1;
            }
        }
        for (int[] arrayEg: arr2) {
            System.out.println("----");
            for (int x : arrayEg) {
                System.out.println(x);
            }
        }
    }
}
