package com.example;
import java.util.function.Function;

public class HumanEval_81 {
    public static String[] numericalLetterGrade(double[] grades) {
        Function<Double, String> toLetterGrade = score -> {
            if (score == 4.0)
                return "A+";
            else if (score > 3.7)
                return "A";
            else if (score > 3.3)
                return "A-";
            else if (score > 3.0)
                return "B+";
            else if (score > 2.7)
                return "B";
            else if (score > 2.3)
                return "B-";
            else if (score > 2.0)
                return "C+";
            else if (score > 1.7)
                return "C";
            else if (score > 1.3)
                return "C-";
            else if (score > 1.0)
                return "D+";
            else if (score > 0.7)
                return "D";
            else if (score > 0.0)
                return "D-";
            else
                return "E";
        };

        String[] result = new String[grades.length];
        for (int i = 0; i < grades.length; i++) {
            result[i] = toLetterGrade.apply(grades[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        double[] grades = {4.0, 3, 1.7, 2, 3.5};
        String[] letterGrades = numericalLetterGrade(grades);
        for (String grade : letterGrades)
            System.out.println(grade);
    }
}