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
            int digit = n % 10;  //121%10 =1 to extract last digit
            reversedNo = reversedNo * 10 + digit; // 0*10+1=1
            n /= 10;           // 121/10 = 12 to remove last digit
        }

        if (originalNo == reversedNo) {
            System.out.println(" is a palindrome.");
        } else {
            System.out.println(" is not a palindrome.");
        }
    }
}
