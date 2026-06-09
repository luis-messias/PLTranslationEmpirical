package com.example;
class Solution {
    /**
     * Given a non-empty array of integers arr and an integer k, return
     * the sum of the elements with at most two digits from the first k elements of arr.
     *
     * @param arr The input array of integers.
     * @param k The number of initial elements to consider.
     * @return The sum of elements from the first k elements that have at most two digits.
     */
    public int addElements(int[] arr, int k) {
        int sum = 0;

        // Iterate over the first k elements
        for (int i = 0; i < k; i++) {
            int x = arr[i];

            // Check if the number of digits is at most 2
            // We handle the case where x might be negative by taking the absolute value for digit counting,
            // although based on the example, inputs seem positive.
            // The Python implementation handles signs explicitly, but for positive integers, length check is sufficient.
            
            // Convert to string to find the number of digits
            String s = String.valueOf(Math.abs(x));
            
            if (s.length() <= 2) {
                sum += x;
            }
        }

        return sum;
    }
}