package com.quest.practice1;

public class StudentScores {
    public static void main(String[] args) {
        // Initialize arrays
        String[] names = {"Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace"};
        int[] ages = {20, 21, 22, 23, 24, 25, 26};
        int[][] scores = {
                {85, 90, 78, 92, -1}, // 7 x 5
                {88, 92, 80, -1, 85},
                {75, 80, 70, 60, 72},
                {90, 85, 88, 95, 92},
                {65, 70, 60, 68, 67},
                {80, 85, -1, 90, 95},
                {90, 88, 92, 85, 80}  // -1 represent missing data
        };

        // Calculate average scores
        calculateAverageScores(names, ages, scores);

        // Find the highest scorer
        findHighestScorer(names, ages, scores);

        // Ranking students by average score
        rankStudents(names, ages, scores);

        // Detect missing data
        detectMissingData(names, scores);
    }

    // Method to calculate and print average scores
    public static void calculateAverageScores(String[] names, int[] ages, int[][] scores) {
        // Loop through each student
        for (int i = 0; i < names.length; i++) {
            double total = 0; // to store the total all valid scores
            int count = 0; //to count valid score

            // Loop through each score for the current student
            for (int j = 0; j < scores[i].length; j++) {
                if (scores[i][j] != -1) { // Check if it is not missing/invalid score(-1)
                    total = total + scores[i][j];
                    count++;
                }
            }

            // calculate the average score
            double average;
            if (count > 0) {
                average = total / count;
            } else {
                average = 0; // If no valid score make average = 0
            }

            // Print the result: student's name, age, and average score
            System.out.println(names[i] + "| Age " + ages[i] + " | : Average Score = " + average);
        }
    }


    // Method to find the student with the highest average score
    public static void findHighestScorer(String[] names, int[] ages, int[][] scores) {
        double highestAvg = -1;
        String highestScorer = "";
        int age = 0;

        for (int i = 0; i < names.length; i++) {
            int total = 0;
            int count = 0;

            for (int j = 0; j < scores[i].length; j++) {
                if (scores[i][j] != -1) {
                    total += scores[i][j];
                    count++;
                }
            }

            double average = (count > 0) ? (double) total / count : 0;
            if (average > highestAvg) {
                highestAvg = average;
                highestScorer = names[i];
                age = ages[i];
            }
        }

        System.out.println("\nHighest Scorer: " + highestScorer + " (Age " + age + "), Average Score = " + highestAvg);
    }

    // Method to rank students based on average score
    public static void rankStudents(String[] names, int[] ages, int[][] scores) {
        double[] averages = new double[names.length];

        // Calculate averages for each student
        for (int i = 0; i < names.length; i++) {
            int total = 0;
            int count = 0;

            for (int j = 0; j < scores[i].length; j++) {
                if (scores[i][j] != -1) {
                    total += scores[i][j];
                    count++;
                }
            }

            averages[i] = (count > 0) ? (double) total / count : 0;
        }

        // Sort the students by their averages in descending order
        for (int i = 0; i < averages.length; i++) {
            for (int j = i + 1; j < averages.length; j++) {
                if (averages[i] < averages[j]) {
                    // Swap averages
                    double temp = averages[i];
                    averages[i] = averages[j];
                    averages[j] = temp;

                    // Swap names and ages accordingly
                    String tempName = names[i];
                    names[i] = names[j];
                    names[j] = tempName;

                    int tempAge = ages[i];
                    ages[i] = ages[j];
                    ages[j] = tempAge;
                }
            }
        }

        // Print the ranking of students
        System.out.println("Ranking of Students by Average Score:");
        for (int i = 0; i < names.length; i++) {
            System.out.println((i + 1) + ". " + names[i] + " (Age " + ages[i] + "): Average Score = " + averages[i]);
        }
    }

    // Method to detect missing data in the scores array
    public static void detectMissingData(String[] names, int[][] scores) {
        for (int i = 0; i < names.length; i++) {
            StringBuilder missingSubjects = new StringBuilder();

            for (int j = 0; j < scores[i].length; j++) {
                if (scores[i][j] == -1) {
                    missingSubjects.append("Subject ").append(j + 1).append(" ");
                }
            }

            if (missingSubjects.length() > 0) {
                System.out.println(names[i] + ": Missing data in " + missingSubjects.toString());
            }
        }
    }
}
