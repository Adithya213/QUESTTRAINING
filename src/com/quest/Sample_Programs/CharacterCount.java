package com.quest.Sample_Programs;

public class CharacterCount {
    public static void main(String[] args) {
        String s = "Hello World";

        System.out.println("Characters vertically:");
        for (int i=0;i< s.length(); i++) {
            System.out.println(s.charAt(i));
        }

        s = s.replace(" ", "").toLowerCase(); //to remove space
        int[] countArray = new int[26]; //to store count of each letter

        // count occurrences of each character
        for (int i=0; i<s.length(); i++) { //iterates through string
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') { //check char is lowercase
                int index = ch - 'a';
                countArray[index]++; // increment the count at index
            }
        }
        System.out.println("\nCharacter count:");
        for (int i=0; i< countArray.length; i++) {
            if (countArray[i] > 0) { //check if array is not emptg
                char ch = (char) (i + 'a'); //  Convert index back to character
                System.out.print(ch + "->" + countArray[i] + " ");
            }
        }
    }
}
