package com.example;
import java.util.ArrayList;
import java.util.List;

class Solution {
    /**
     * From a given list of integers, generate a list of rolling maximum element found until given moment
     * in the sequence.
     *
     * @param numbers The input list of integers.
     * @return A list containing the rolling maximums.
     */
    public List<Integer> rollingMax(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        if (numbers == null || numbers.isEmpty()) {
            return result;
        }

        int currentMax = Integer.MIN_VALUE;

        for (int number : numbers) {
            if (number > currentMax) {
                currentMax = number;
            }
            result.add(currentMax);
        }
        return result;
    }
}