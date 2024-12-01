package com.quest.ExceptionTest;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an operation:");
        System.out.println("1. Add two numbers\n2. Subtract two numbers\n3. Add numbers in an array\n4. Concatenate two strings\n5. Exit");
        int choice = 0;
        try {
            choice = getIntInput(scanner);

            switch (choice) {
                case 1:
                    System.out.print("Enter first number for addition: ");
                    double num1 = getDoubleInput(scanner);
                    System.out.print("Enter second number for addition: ");
                    double num2 = getDoubleInput(scanner);
                    CalculatorOperation a = new Addition(num1, num2);
                    System.out.println("Result: " + a.performOperation());
                    break;

                case 2:
                    System.out.print("Enter first number for subtraction: ");
                    num1 = getDoubleInput(scanner);
                    System.out.print("Enter second number for subtraction: ");
                    num2 = getDoubleInput(scanner);
                    CalculatorOperation s = new Subtraction(num1, num2);
                    System.out.println("Result: " + s.performOperation());
                    break;

                case 3:
                    System.out.print("Enter size of array for sum: ");
                    int size = getIntInput(scanner);
                    int[] numbers = new int[size];
                    System.out.println("Enter " + size + " numbers:");
                    for (int i = 0; i < size; i++) {
                        numbers[i] = getIntInput(scanner);
                    }
                    CalculatorOperation arrayAddOperation = new ArrayAddition(numbers);
                    System.out.println("Sum of array elements: " + arrayAddOperation.performOperation());
                    break;

                case 4:
                    System.out.print("Enter first string for concatenation: ");
                    String str1 = getStringInput(scanner);
                    System.out.print("Enter second string for concatenation: ");
                    String str2 = getStringInput(scanner);
                    CalculatorOperation stringAddOperation = new StringConcatenation(str1, str2);
                    System.out.println("Concatenated String: " + stringAddOperation.performOperation());
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } catch (InputMismatchException e) {
            System.err.println("Invalid input, expected a number.");
        }
    }

    // Method to safely get double input
    public static double getDoubleInput(Scanner scanner) {
        double input = 0;
        try {
            input = scanner.nextDouble();
        } catch (InputMismatchException e) {
            scanner.nextLine(); // clear buffer
            throw new InputMismatchException("Invalid input, expected a number.");
        }
        return input;
    }

    // Method to safely get int input
    public static int getIntInput(Scanner scanner) {
        int input = 0;
        try {
            input = scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            throw new InputMismatchException("Invalid input, expected a number.");
        }
        return input;
    }

    // Method to safely get string input
    public static String getStringInput(Scanner scanner) {
        return scanner.next(); // Get the string input
    }
}
