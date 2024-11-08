package com.quest.Sample_Programs;

import java.util.Scanner;

public class CheckNumPallindrom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();

        int originalNo = n;
        int reversedNo = 0;
        while (n != 0) {
            int digit = n % 10;
            reversedNo = reversedNo * 10 + digit;
            n /= 10;
        }

        if (originalNo == reversedNo) {
            System.out.println(" is a palindrome.");
        } else {
            System.out.println(" is not a palindrome.");
        }
    }
}
