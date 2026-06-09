package com.example;
import java.util.ArrayList;
import java.util.List;

class Solution {

    /**
     * Converts a numerical GPA score to a corresponding letter grade.
     * 
     * @param score The GPA score (double).
     * @return The letter grade (String).
     */
    private static String toLetterGrade(double score) {
        if (score == 4.0) {
            return "A+";
        } else if (score > 3.7) {
            return "A";
        } else if (score > 3.3) {
            return "A-";
        } else if (score > 3.0) {
            return "B+";
        } else if (score > 2.7) {
            return "B";
        } else if (score > 2.3) {
            return "B-";
        } else if (score > 2.0) {
            return "C+";
        } else if (score > 1.7) {
            return "C";
        } else if (score > 1.3) {
            return "C-";
        } else if (score > 1.0) {
            return "D+";
        } else if (score > 0.7) {
            return "D";
        } else if (score > 0.0) {
            return "D-";
        } else {
            return "E";
        }
    }

    /**
     * Translates a list of numerical GPAs into a list of letter grades.
     * 
     * @param grades A list of GPA scores.
     * @return A list of corresponding letter grades.
     */
    public static List<String> numericalLetterGrade(List<Double> grades) {
        List<String> letterGrades = new ArrayList<>();
        for (double grade : grades) {
            letterGrades.add(toLetterGrade(grade));
        }
        return letterGrades;
    }
}