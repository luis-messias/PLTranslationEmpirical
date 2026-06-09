package com.example;
import java.util.List;
import java.lang.Math;

public class HumanEval_4 {
    public static double meanAbsoluteDeviation(List<Double> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("Input list cannot be null or empty.");
        }

        // Calculate the mean
        double sum = 0;
        for (double x : numbers) {
            sum += x;
        }
        double mean = sum / numbers.size();

        // Calculate the sum of absolute differences from the mean
        double sumOfAbsoluteDifferences = 0;
        for (double x : numbers) {
            sumOfAbsoluteDifferences += Math.abs(x - mean);
        }

        // Calculate the Mean Absolute Deviation
        return sumOfAbsoluteDifferences / numbers.size();
    }
}