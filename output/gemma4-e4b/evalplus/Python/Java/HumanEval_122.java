package com.example;
class Solution {
    /**
     * Given a non-empty array of integers arr and an integer k, return
     * the sum of the elements with at most two digits from the first k elements of arr.
     */
    public static int addElements(int[] arr, int k) {
        int sum = 0;
        
        // Iterate over the first k elements (indices 0 to k-1)
        for (int i = 0; i < k; i++) {
            int element = arr[i];
            if (countDigits(element) <= 2) {
                sum += element;
            }
        }
        return sum;
    }

    /**
     * Helper function to count the number of digits in an integer, 
     * matching the logic of the Python implementation (handling negative signs).
     */
    private static int countDigits(int x) {
        String s = String.valueOf(x);
        if (s.startsWith("-")) {
            // Exclude the negative sign
            return s.length() - 1;
        } else {
            return s.length();
        }
    }
}