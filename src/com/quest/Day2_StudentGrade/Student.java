package com.quest.Day2_StudentGrade;
public class Student {

    String name;
    int mathScore;
    int scienceScore;
    int englishScore;
    int totalScore;
    double averageScore;  // Average score of all subjects
    char grade;  // Grade assigned based on average score

    // Constructor to initialize the student's details
    public Student(String name, int mathScore, int scienceScore, int englishScore) {
        this.name = name;
        this.mathScore = mathScore;
        this.scienceScore = scienceScore;
        this.englishScore = englishScore;
        calculateScores();  // Call method to calculate
    }

    // Method to calculate total score, average score, and grade
    void calculateScores() {
        totalScore = mathScore + scienceScore + englishScore;  // Sum of all subject scores
        averageScore = totalScore / 3.0;  // Calculate the average of the 3 subjects
        grade = GradeCalculator.calculateGrade(averageScore);  // Get the grade based on average score
    }

    // Method to display the student's results
    void displayResults() {
        System.out.println("\nName: " + name);
        System.out.println("Total Score: " + totalScore);
        System.out.println("Average Score: " + averageScore);
        System.out.println("Grade: " + grade);
        System.out.println(GradeCalculator.getFeedback(grade));  // Provide feedback based on grade

        // Display a warning if any subject score is below 60
        if (mathScore < 60 || scienceScore < 60 || englishScore < 60) {
            System.out.println("Warning: Needs improvement in individual subjects.");
        }
    }

    // Getter method to return the total score of the student
    int getTotalScore() {
        return totalScore;  // Return the total score
    }
}
