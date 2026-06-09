package com.example;
import java.util.List;
import java.util.stream.Collectors;

public class HumanEval_81 {

    public static List<String> numericalLetterGrade(List<Double> grades) {
        return grades.stream()
                .map(GradeConverter::toLetterGrade)
                .collect(Collectors.toList());
    }

    private