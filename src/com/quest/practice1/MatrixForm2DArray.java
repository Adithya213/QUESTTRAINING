package com.quest.practice1;

public class MatrixForm2DArray {
    public static void main(String[] args) {
        // initialize a 2D array (3x3)
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        // print the 2D array in matrix form
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}


