package com.example;
import java.util.List;
import java.util.stream.Collectors;

public class HumanEval_21 {
    public static List<Double> rescaleToUnit(List<Double> numbers) {
        if (numbers == null || numbers.size() < 2) {
            if (numbers != null) {
                // If we must return a list, handle the case gracefully.
                // Since the requirement implies at least two elements, we might return an empty list or handle based on context.
                // Following the spirit of the provided error handling in the attempt:
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
            // If all numbers are equal, the scaled result is 0.0
            return numbers.stream().map(x -> 0.0).collect(Collectors.toList());
        }

        double k = 1.0 / range;

        return numbers.stream()
                .map(x -> (x - min) * k)
                .collect(Collectors.toList());
    }
}
