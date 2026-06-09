package com.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class HumanEval_21 {

    /**
     * Given list of numbers (of at least two elements), apply a linear transform to that list,
     * such that the smallest number will become 0 and the largest will become 1.
     *
     * @param numbers The list of numbers.
     * @return A new list with the numbers rescaled to the unit interval [0, 1].
     */
    public static List<Double> rescaleToUnit(List<Double> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return Collections.emptyList();
        }

        // Find min and max
        double min = numbers.get(0);
        double max = numbers.get(0);

        for (double num : numbers) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }

        double range = max - min;

        // Handle the case where all numbers are the same (range is 0)
        if (range == 0.0) {
            // All elements map to 0.0
            List<Double> result = new ArrayList<>();
            for (int i = 0; i < numbers.size(); i++) {
                result.add(0.0);
            }
            return result;
        }

        // Apply the transformation: (x - min) / range
        List<Double> result = new ArrayList<>();
        for (double x : numbers) {
            result.add((x - min) / range);
        }
        return result;
    }
}
