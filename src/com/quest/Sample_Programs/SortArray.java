package com.quest.Sample_Programs;

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
/*
create a method that accepts the int[] array,
sort this int[] array and return the new sorted array or same array if you sorted the same array in place.
and finally print the sorted array in the new method with the name printArray(int[] arr)

{
{1,2,3,4,5,6}
{7,8,9,10,11,12}
{12,14,15,16,17,18}
}
*/
