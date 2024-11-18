package com.quest.Sample_Programs;

public class SearchKeyInArray {
    public static int searchValue(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return i; // if found key
            }
        }
        return -1; // if key not present
    }

    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 7, 9};
        int value = 5;

        int index = searchValue(numbers, value);
        System.out.println("The value " + value + "is at index : " + index);
    }
}
/*
create a method to search a int value from the int[] array.
Method should accept both int[] and int to search and return the index of the value to search.
If the value is not found , return -1

 */