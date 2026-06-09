package com.example;
import java.util.List;

class Solution {
    /**
     * Given a list of numbers, return the sum of squares of the numbers
     * in the list that are odd. Ignore numbers that are negative or not integers.
     *
     * double_the_difference([1, 3, 2, 0]) == 1 + 9 + 0 + 0 = 10
     * double_the_difference([-1, -2, 0]) == 0
     * double_the_difference([9, -2]) == 81
     * double_the_difference([0]) == 0
     *
     * If the input list is empty, return 0.
     *
     * Note: The original Python implementation assumes the input list contains numbers
     * that can be checked for integer status and oddness. In Java, if the list
     * contains Objects, we must cast/check types. Assuming the input list is List<Integer>
     * or List<Double> that should be treated as integers.
     * Based on the Python logic (num % 2 == 1 and num > 0 and "." not in str(num)),
     * we assume the input list contains numeric types that are intended to be integers.
     * We will use List<Integer> for simplicity and adherence to the constraints.
     */
    public static int doubleTheDifference(List<Integer> lst) {
        int ans = 0;
        for (int num : lst) {
            // Check if the number is odd, positive, and an integer (which is guaranteed if List<Integer> is used)
            // The original Python logic: num % 2 == 1 and num > 0 and "." not in str(num)
            // Since we are using List<Integer>, the "not in str(num)" check is redundant.
            // We only need to check for odd and positive.
            if (num % 2 != 0 && num > 0) {
                ans += num * num;
            }
        }
        return ans;
    }
}