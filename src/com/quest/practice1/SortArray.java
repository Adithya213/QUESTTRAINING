package com.quest.practice1;

import java.util.Arrays;

public class SortArray {

    public static int[] sortArray(int[] arr) {

        for (int i=0; i < arr.length-1 ; i++) {
            for (int j=0; j < arr.length-i-1; j++) {

                if (arr[j] > arr[j + 1]) { // if 1st > 2nd then swap the element
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;  // Return the sorted array
    }


    public static void main(String[] args) {
        int[] numbers = {5, 3, 8, 1, 2};

        sortArray(numbers);//call

        // Printing the sorted arr
        System.out.print("Sorted Array: ");
        for (int n : numbers) {
            System.out.print(n + " ");
        }
    }
}

