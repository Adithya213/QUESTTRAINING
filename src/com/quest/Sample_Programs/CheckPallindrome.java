package com.quest.Sample_Programs;

import java.util.Scanner;

public class CheckPallindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();
        if (str == null) {
            System.out.println("The string is null");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder(str);
        StringBuilder reverse = stringBuilder.reverse();
        String reverseString = reverse.toString();
        if (reverseString.equals(str)) {
            System.out.println("The String is Pallindrome");
        } else {
            System.out.println("The String is not Pallindrome");
        }

    }
}




