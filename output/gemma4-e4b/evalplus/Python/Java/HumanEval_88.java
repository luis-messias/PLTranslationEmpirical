package com.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> sortArray(List<Integer> array) {
        if (array == null || array.isEmpty()) {
            return new ArrayList<>();
        }

        // Create a copy to ensure the original array is not changed
        List<Integer> result = new ArrayList<>(array);

        // Calculate the sum of the first and last elements
        int first = array.get(0);
        int last = array.get(array.size() - 1);
        int sum = first + last;

        // Determine if sorting should be descending (reverse=True)
        // Descending if sum is even (sum % 2 == 0)
        boolean isDescending = (sum % 2 == 0);

        if (isDescending) {
            // Sort in descending order
            Collections.sort(result, Collections.reverseOrder());
        } else {
            // Sort in ascending order (default)
            Collections.sort(result);
        }

        return result;
    }
}