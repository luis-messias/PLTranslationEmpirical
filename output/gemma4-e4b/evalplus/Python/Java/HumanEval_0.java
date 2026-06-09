package com.example;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HumanEval_0 {
    /**
     * Check if in given list of numbers, are any two numbers closer to each other than
     * given threshold.
     *
     * @param numbers The list of numbers.
     * @param threshold The maximum allowed difference.
     * @return True if any two numbers are closer than the threshold, false otherwise.
     */
    public static boolean hasCloseElements(List<Double> numbers, double threshold) {
        if (numbers == null || numbers.size() < 2) {
            return false;
        }

        // 1. Convert List<Double> to an array and sort it.
        // Since we need to sort, converting to an array or using a mutable list is best.
        // Using an array for simplicity in sorting.
        Double[] array = numbers.toArray(new Double[0]);
        Arrays.sort(array);

        // 2. Iterate through the sorted array and check the difference between adjacent elements.
        for (int i = 0; i < array.length - 1; i++) {
            double diff = array[i + 1] - array[i];
            if (diff < threshold) {
                return true;
            }
        }
        return false;
    }

    // Optional: Main method for testing (not required for the translation, but useful for completeness)
    public static void main(String[] args) {
        // Test case 1: [1.0, 2.0, 3.0], 0.5 -> False
        List<Double> list1 = Arrays.asList(1.0, 2.0, 3.0);
        System.out.println("Test 1: " + hasCloseElements(list1, 0.5)); // Expected: false

        // Test case 2: [1.0, 2.8, 3.0, 4.0, 5.0, 2.0], 0.3 -> True
        List<Double> list2 = Arrays.asList(1.0, 2.8, 3.0, 4.0, 5.0, 2.0);
        System.out.println("Test 2: " + hasCloseElements(list2, 0.3)); // Expected: true

        // Test case 3: [1.0, 1.1], 0.2 -> True
        List<Double> list3 = Arrays.asList(1.0, 1.1);
        System.out.println("Test 3: " + hasCloseElements(list3, 0.2)); // Expected: true
    }
}