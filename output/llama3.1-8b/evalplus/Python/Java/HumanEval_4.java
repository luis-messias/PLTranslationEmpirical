package com.example;
import java.util.List;
import java.util.stream.Collectors;

public class HumanEval_4 {
    public static double meanAbsoluteDeviation(List<Double> numbers) {
        double mean = numbers.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
        return numbers.stream()
                .mapToDouble(x -> Math.abs(x - mean))
                .average()
                .orElse(0.0);
    }
}