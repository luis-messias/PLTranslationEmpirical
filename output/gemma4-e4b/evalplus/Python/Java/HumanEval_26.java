package com.example;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    /**
     * From a list of integers, remove all elements that occur more than once.
     * Keep order of elements left the same as in the input.
     * 
     * @param numbers The input list of integers.
     * @return A new list containing only the elements that appeared exactly once.
     */
    public static List<Integer> removeDuplicates(List<Integer> numbers) {
        // 1. Count the frequency of each number
        Map<Integer, Integer> numCnt = new HashMap<>();
        for (int number : numbers) {
            numCnt.put(number, numCnt.getOrDefault(number, 0) + 1);
        }

        // 2. Build the result list, preserving order
        List<Integer> result = new ArrayList<>();
        for (int number : numbers) {
            // Check if the count is exactly 1
            if (numCnt.get(number) == 1) {
                result.add(number);
            }
        }
        return result;
    }

    // Optional main method for testing purposes (not required for translation, but helpful)
    /*
    public static void main(String[] args) {
        List<Integer> input = List.of(1, 2, 3, 2, 4);
        List<Integer> output = removeDuplicates(input);
        System.out.println(output); // Expected: [1, 3, 4]
    }
    */
}