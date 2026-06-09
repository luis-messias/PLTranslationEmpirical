package com.example;
import java.util.List;
import java.util.Collections;

public class HumanEval_0 {
    public static boolean hasCloseElements(List<Double> numbers, double threshold) {
        if (numbers == null || numbers.size() < 2) {
            return false;
        }

        // Sort the list
        // Create a mutable copy to sort, or sort the input list if modification is allowed.
        // Sorting the input list is simpler here.
        Collections.sort(numbers);

        // Check adjacent elements
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i + 1) - numbers.get(i) < threshold) {
                return true;
            }
        }
        return false;
    }
}