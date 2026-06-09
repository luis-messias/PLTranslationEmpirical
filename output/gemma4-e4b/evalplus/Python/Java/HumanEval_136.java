package com.example;
import java.util.List;
import java.util.Optional;
import java.util.Arrays;

class Solution {
    /**
     * Returns an array [largest_negative, smallest_positive].
     * If a value doesn't exist, the corresponding element will be null.
     */
    public Integer[] largestSmallestIntegers(List<Integer> lst) {
        // Find the largest negative integer
        Optional<Integer> largestNegativeOpt = lst.stream()
                .filter(n -> n < 0)
                .max(Integer::compareTo);

        Integer largestNegative = largestNegativeOpt.orElse(null);

        // Find the smallest positive integer
        Optional<Integer> smallestPositiveOpt = lst.stream()
                .filter(n -> n > 0)
                .min(Integer::compareTo);

        Integer smallestPositive = smallestPositiveOpt.orElse(null);

        // Return the result as an array (mimicking the tuple (a, b))
        return new Integer[]{largestNegative, smallestPositive};
    }
}