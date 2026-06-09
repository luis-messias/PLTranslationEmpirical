package com.example;
import java.util.List;

public class HumanEval_4 {
    /**
     * For a given list of input numbers, calculate Mean Absolute Deviation
     * around the mean of this dataset.
     * Mean Absolute Deviation is the average absolute difference between each
     * element and a centerpoint (mean in this case):
     * MAD = average | x - x_mean |
     * 
     * @param numbers the list of numbers
     * @return the mean absolute deviation
     */
    public static double meanAbsoluteDeviation(List<Double> numbers) {
        double sum = 0.0;
        for (Double num : numbers) {
            sum += num;
        }
        double mean = sum / numbers.size();
        
        double absSum = 0.0;
        for (Double num : numbers) {
            absSum += Math.abs(num - mean);
        }
        
        return absSum / numbers.size();
    }
}