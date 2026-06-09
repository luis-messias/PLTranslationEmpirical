package com.example;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HumanEval_47 {
    /**
     * Return median of elements in the list l.
     * @param l The list of numbers.
     * @return The median value (double).
     */
    public static double median(List<Double> l) {
        if (l == null || l.isEmpty()) {
            throw new IllegalArgumentException("Input list cannot be null or empty.");
        }

        // Create a sorted copy of the list
        double[] sortedArray = l.stream().mapToDouble(Double.class::doubleValue).sorted().toArray();
        int n = sortedArray.length;

        if (n % 2 == 1) {
            // Odd number of elements: return the middle element
            return sortedArray[n / 2];
        } else {
            // Even number of elements: return the average of the two middle elements
            double middle1 = sortedArray[n / 2 - 1];
            double middle2 = sortedArray[n / 2];
            return (middle1 + middle2) / 2.0;
        }
    }
}