package com.quest.practice1;

public class ControlFlow {
    public static void main(String[] args) {
        int number = 10;

        // if-else control flow
        if (number < 0) {
            System.out.println(number + " is a negative number");
        } else if (number == 0) {
            System.out.println(number + " is zero");
        } else {
            System.out.println(number + " is a positive number");
        }

        // switch case control flow
        String day = "Monday";
        switch (day) {
            case "Monday":
                System.out.println("Monday");
                break;
            case "Tuesday":
                System.out.println("Tuesday");
                break;
            case "Wednesday":
                System.out.println("Wednesday");
                break;
            case "Thursday":
                System.out.println("Thursday");
                break;
            case "Friday":
                System.out.println("Friday");
                break;
            default:
                System.out.println("Invalid day");
                break;
        }

        // Calling the TestForLoop and TestWhile methods
        TestForLoop();
        TestWhile();
    }

    // Method to demonstrate a for loop with continue statement
    //to print even numbers
    private static void TestForLoop() {
        for (int i = 0; i < 21; i++) {
            if (i % 2 != 0) {
                continue;  // skips the odd numbers
            }
            System.out.println("even no.: " + i);
        }
    }

    // Method to demonstrate a while loop
    public static void TestWhile() {
        int i = 1;
        while (i <= 5) {
            System.out.println(i);
            i++;
        }
    }
}
