package com.quest.Sample_Programs;

import java.util.Arrays;

public class ReverseMatrixRows {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3}, // 2D array
                {4, 5, 6},
                {7, 8, 9}};

        // Iterate each row
        for (int[] row : matrix) {
            reverseRow(row); // Reverse the row
            System.out.println(Arrays.toString(row)); // Print the reversed row
        }
    }
    private static void reverseRow(int[] row) {
        int i = 0, j = row.length - 1;
        while (i < j) {
            int temp = row[i];  // Swap elements
            row[i] = row[j];
            row[j] = temp;
            i++;
            j--;
        }
    }
}
