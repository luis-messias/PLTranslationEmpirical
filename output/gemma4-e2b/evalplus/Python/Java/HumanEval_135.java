package com.example;
class Solution {
    public static int canArrange(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return -1;
        }

        // Iterate backwards from the second-to-last element
        for (int i = arr.length - 1; i > 0; i--) {
            // Check if the current element is strictly less than the preceding element
            // This corresponds to the condition: not (arr[i] >= arr[i - 1])
            if (arr[i] < arr[i - 1]) {
                return i;
            }
        }
        
        return -1;
    }
}