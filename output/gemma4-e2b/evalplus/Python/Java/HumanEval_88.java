package com.example;
import java.util.Arrays;

class Solution {
    public int[] sortArray(int[] array) {
        if (array == null || array.length == 0) {
            return new int[0];
        }

        int first = array[0];
        int last = array[array.length - 1];

        // Determine the sorting direction based on the parity of the sum of the first and last elements.
        // If (first + last) is even, sort in descending order (reverse=true).
        // If (first + last) is odd, sort in ascending order (reverse=false).
        boolean shouldReverse = ((first + last) % 2 == 0);

        // Create a copy of the array to avoid modifying the original
        int[] result = Arrays.copyOf(array, array.length);

        // Sort the copy
        Arrays.sort(result, reverse = shouldReverse);

        return result;
    }
}