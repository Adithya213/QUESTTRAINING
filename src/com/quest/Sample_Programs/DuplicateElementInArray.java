package com.quest.Sample_Programs;
import java.util.Arrays;

public class DuplicateElementInArray  {
    public static void main(String[] args) {
        int[] array = {1, 4, 3, 54, 34, 33, 5, 4, 3};
        findduplicates(array); // call
    }

    public static void findduplicates(int[] array) {
        Arrays.sort(array);  // Sort
        System.out.print("Duplicate elements in array are : ");

        int i = 0;
        while (i < array.length - 1) {
            if (array[i] == array[i + 1]) {  // Check adjacent elements are equal
                System.out.print(array[i] + " ");
                // to ensure duplicate is printed only once
                while (i < array.length - 1 && array[i] == array[i + 1]) {
                    i++;
                }
            }
            i++;
        }
    }
}
