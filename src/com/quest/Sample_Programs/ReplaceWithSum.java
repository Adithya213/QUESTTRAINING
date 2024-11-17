package com.quest.Sample_Programs;

import java.util.Arrays;

public class ReplaceWithSum {
    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 7, 8};
        int i = 0;
        while (i < arr.length) {
            int sum = 0;
            int j = 0;
            while (j < arr.length) {
                if (i != j) {
                    sum += arr[j];
                }
                j++;
            }
            arr[i] = sum;
            i++;
        }

        System.out.println("Modified array:"+ Arrays.toString(arr)); //print it as array
//        int k=0;
//        while ( k< arr.length) {
//           System.out.print(arr[k] + " ");
//            k++;
//        }
    }
}
