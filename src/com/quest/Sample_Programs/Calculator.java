package com.quest.Sample_Programs;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double iNum = 0;
        while (true) {
            try {
                System.out.print("Enter the initial number: ");
                iNum = scanner.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.nextLine();  // Clear the invalid input
            }
        }

        while (true) {
            System.out.println("\nCurrent result: " + iNum);
            System.out.println("1. Addition\n2. Subtraction\n3. Multiplication\n4. Division");
            System.out.println("5. Square Root\n6. Clear Current Answer\n7. Exit Calculator\n");
            System.out.print("Enter your choice: ");
            int c;

            try {
                c = scanner.nextInt();  // Expecting integer input
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice. Please enter a numeric option from 1 to 7.");
                scanner.nextLine();  // Clear the invalid input
                continue;  // Restart the loop to show the options again
            }

            switch (c) {
                case 1:
                    System.out.print("Enter number to add: ");
                    try {
                        iNum += scanner.nextDouble();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a numeric value.");
                        scanner.nextLine();  // Clear the invalid input
                    }
                    break;

                case 2:
                    System.out.print("Enter number to subtract: ");
                    try {
                        iNum -= scanner.nextDouble();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a numeric value.");
                        scanner.nextLine();
                    }
                    break;

                case 3:
                    System.out.print("Enter number to multiply: ");
                    try {
                        iNum *= scanner.nextDouble();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a numeric value.");
                        scanner.nextLine();
                    }
                    break;

                case 4:
                    System.out.print("Enter number to divide by: ");
                    try {
                        double divisor = scanner.nextDouble();
                        if (divisor != 0) {
                            iNum /= divisor;
                        } else {
                            System.out.println("Error: Cannot divide by zero.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a numeric value.");
                        scanner.nextLine();
                    }
                    break;

                case 5:
                    if (iNum >= 0) {
                        iNum = Math.sqrt(iNum);
                    } else {
                        System.out.println("We cannot take the square root of a negative number.");
                    }
                    break;

                case 6:
                    iNum = 0;
                    System.out.println("Cleared Current Result.");
                    break;

                case 7:
                    System.out.println("Exiting the calculator. Thank you, visit again!");
                    return;

                default:
                    System.out.println("Invalid choice! Please choose a valid option.");
            }

            System.out.print("\nDo you want to perform another operation? (yes/no): ");
            String choice = scanner.next();

            if (choice.equalsIgnoreCase("yes")) {
                continue; //move to next iteration
            } else if (choice.equalsIgnoreCase("no")) {
                System.out.println("Exiting the calculator.");
                break;
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }
        }//while end
    }
}
