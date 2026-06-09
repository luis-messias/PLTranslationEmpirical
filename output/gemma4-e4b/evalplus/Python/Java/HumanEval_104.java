package com.example;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

class Solution {
    /**
     * Given a list of positive integers x. return a sorted list of all 
     * elements that hasn't any even digit.
     *
     * @param x The list of positive integers.
     * @return A sorted list containing only numbers with all odd digits.
     */
    public List<Integer> uniqueDigits(List<Integer> x) {
        // Filter the list using the helper method and then sort the results.
        return x.stream()
                .filter(this::hasOnlyOddDigits)
                .sorted()
                .collect(Collectors.toList());
    }

    /**
     * Checks if all digits of a positive integer are odd.
     * This corresponds to the Python 'judge' function.
     * @param n The number to check.
     * @return true if all digits are odd, false otherwise.
     */
    private boolean hasOnlyOddDigits(int n) {
        if (n < 0) {
            // Assuming positive integers based on problem description.
            return false; 
        }
        
        int current = n;
        while (current > 0) {
            int digit = current % 10;
            if (digit % 2 == 0) {
                return false; // Found an even digit
            }
            current /= 10;
        }
        return true; // All digits were odd
    }
}