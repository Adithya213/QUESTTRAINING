package com.quest.Day2_StudentGrade;
import java.util.Scanner;

public class Main {
    static final int MAX_SCORE = 100; // it is max score.so it is final.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int noStud;

        // Asking user to enter the number of students with input validation.
        do {
            System.out.print("Enter the number of students (1-100): ");
            noStud = scanner.nextInt();
        } while (noStud < 1 || noStud > 100);  // Ensuring the number of students is between 1 and 100.

        //creating an array to store Student objects based on the number of students entered.
        Student[] students = new Student[noStud];

         // reading details
        for (int i = 0; i < noStud; i++) {
            System.out.println("\nEnter details for student :");
            System.out.print("\nEnter name: ");
            scanner.nextLine();
            String name = scanner.nextLine();

            // Taking math score with validation.
            int mathScore;
            do {
                System.out.print("Enter score for Math (0-100): ");
                mathScore = scanner.nextInt();
            } while (mathScore < 0 || mathScore > MAX_SCORE);  // Ensuring math score is between 0 and 100.

            // Taking science score with validation.
            int scienceScore;
            do {
                System.out.print("Enter score for Science (0-100): ");
                scienceScore = scanner.nextInt();
            } while (scienceScore < 0 || scienceScore > MAX_SCORE);

            // Taking English score with validation.
            int englishScore;
            do {
                System.out.print("Enter score for English (0-100): ");
                englishScore = scanner.nextInt();
            } while (englishScore < 0 || englishScore > MAX_SCORE);

            // creating  Student object & pass data and storing it in the students array.
            students[i] = new Student(name, mathScore, scienceScore, englishScore);

            // calling the displayResults() to show the results of the current student.
            students[i].displayResults();

            // Checking if the total score of the student is below 50.
            if (students[i].getTotalScore() < 50) {
                System.out.println("\nTotal score below 50. Stopping further processing.");
                break; // Exiting the loop if the condition is met.
            }
        } //end foorloop

        System.out.println("\nSummary-->     Students processed Successfully.");
    }
}

