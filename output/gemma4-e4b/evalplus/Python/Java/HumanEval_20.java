package com.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    /**
     * From a supplied list of numbers (of length at least two) select and return two that are the closest to each
     * other and return them in order (smaller number, larger number).
     * 
     * @param numbers The list of numbers.
     * @return A double array containing the two closest elements: [smaller, larger].
     */
    public double[] findClosestElements(List<Double> numbers) {
        // Create a mutable copy to avoid modifying the original list
        List<Double> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);

        double minDiff = Double.MAX_VALUE;
        // Initialize the pair array. Since the input length is guaranteed >= 2, this will be overwritten.
        double[] minPair = new double[2]; 

        // Iterate through adjacent elements
        for (int i = 0; i < sortedNumbers.size() - 1; i++) {
            double l = sortedNumbers.get(i);
            double r = sortedNumbers.get(i + 1);

            double diff = r - l;

            if (diff < minDiff) {
                minDiff = diff;
                // Store the pair (l, r)
                minPair[0] = l;
                minPair[1] = r;
            }
        }
        
        return minPair;
    }
}