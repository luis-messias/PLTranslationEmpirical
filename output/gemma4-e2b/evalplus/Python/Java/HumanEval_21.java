package com.example;
import java.util.List;
import java.util.stream.Collectors;

public class HumanEval_21 {
    public static List<Double> rescaleToUnit(List<Double> numbers) {
        if (numbers == null || numbers.size() < 2) {
            // Handle cases where scaling is not meaningful or possible based on the requirement
            if (numbers != null) {
                return numbers.stream().map(x -> 0.0).collect(Collectors.toList());
            }
            return List.of();
        }

        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;

        for (double x : numbers) {
            if (x < min) {
                min = x;
            }
            if (x > max) {
                max = x;
            }
        }

        double range = max - min;

        if (range == 0.0) {
            // If all numbers are equal, the scaled result is 0.0 (or 1.0, depending on convention, 0.0 is safer here)
            return numbers.stream().map(x -> 0.0).collect(Collectors.toList());
        }

        double k = 1.0 / range;

        return numbers.stream()
                .map(x -> (x - min) * k)
                .collect(Collectors.toList());
    }
}