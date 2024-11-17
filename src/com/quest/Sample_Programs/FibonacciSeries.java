package com.quest.Sample_Programs;
import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no. of terms: ");
        int n = sc.nextInt();
         if(n<0){
             System.out.println("Invalid no. enter a positive no");
             return;//since main() tyoe is void so we cannot return anything. so simply write return
         }
        int firstTerm = 0;
         int secondTerm = 1;
        System.out.print("Fibonacci Series: " + firstTerm + ", " + secondTerm);

        for (int i = 3; i <= n; i++) {
            int nextTerm = firstTerm + secondTerm;//0+1
            System.out.print(", " + nextTerm);
            firstTerm = secondTerm;//swap
            secondTerm = nextTerm;
        }
    }
}

