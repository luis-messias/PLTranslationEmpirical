package com.example;
import java.util.List;
import java.util.Collections;

public class HumanEval_20 {

    /**
     * From a supplied list of numbers (of length at least two) select and return two that are the closest to each
     * other and return them in order (smaller number, larger number).
     *
     * @param numbers The list of numbers.
     * @return An array containing the two closest elements in ascending order.
     */
    public static double[] findClosestElements(List<Double> numbers) {
        // Create a mutable copy and sort it, mirroring the Python behavior of sorting the list.
        List<Double> sortedNumbers = new java.util.ArrayList<>(numbers);
        Collections.sort(sortedNumbers);

        double minDiff = Double.MAX_VALUE;
        double[] minPair = new double[2];

        // Iterate through adjacent elements
        for (int i = 0; i < sortedNumbers.size() - 1; i++) {
            double l = sortedNumbers.get(i);
            double r = sortedNumbers.get(i + 1);
            double diff = r - l;

            if (diff < minDiff) {
                minDiff = diff;
                minPair[0] = l;
                minPair[1] = r;
            }
        }
        return minPair;
    }
}