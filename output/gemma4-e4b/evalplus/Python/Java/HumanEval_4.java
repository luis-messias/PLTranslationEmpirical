package com.example;
import java.util.List;
import java.lang.Math;

class Solution {
    /**
     * For a given list of input numbers, calculate Mean Absolute Deviation
     * around the mean of this dataset.
     * Mean Absolute Deviation is the average absolute difference between each
     * element and a centerpoint (mean in this case):
     * MAD = average | x - x_mean |
     *
     * @param numbers The list of floating-point numbers.
     * @return The Mean Absolute Deviation.
     */
    public double meanAbsoluteDeviation(List<Double> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0.0;
        }

        // Calculate the mean
        double sum = 0.0;
        for (double number : numbers) {
            sum += number;
        }
        double mean = sum / numbers.size();

        // Calculate the sum of absolute differences
        double absoluteDifferenceSum = 0.0;
        for (double number : numbers) {
            absoluteDifferenceSum += Math.abs(number - mean);
        }

        // Calculate MAD
        return absoluteDifferenceSum / numbers.size();
    }
}