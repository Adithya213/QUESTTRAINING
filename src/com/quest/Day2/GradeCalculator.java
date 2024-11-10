package com.quest.Day2;

public class GradeCalculator {

    static char calculateGrade(double averageScore) {
        if (averageScore >= 90) return 'A';
        if (averageScore >= 80) return 'B';
        if (averageScore >= 70) return 'C';
        if (averageScore >= 60) return 'D';
        return 'F';
    }

    static String getFeedback(char grade) {
        switch (grade) {
            case 'A': return "Excellent performance!";
            case 'B': return "Good job, but you can aim higher!";
            case 'C': return "You need to put in more effort!";
            case 'D': return "Your performance is below expectations. Consider seeking help.";
            case 'F': return "Failure. You need significant improvement.";
            default: return "";
        }
    }
}
