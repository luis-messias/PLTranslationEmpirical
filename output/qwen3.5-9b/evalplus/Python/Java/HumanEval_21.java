package com.example;
import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;

public class HumanEval_21 {
    public static List<Double> rescaleToUnit(List<Double> numbers) {
        double max = Collections.max(numbers);
        double min = Collections.min(numbers);
        double k = 1.0 / (max - min);
        return numbers.stream()
            .map(x -> (x - min) * k)
            .collect(Collectors.toList());
    }
}