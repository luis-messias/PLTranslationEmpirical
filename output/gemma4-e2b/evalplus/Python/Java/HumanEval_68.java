package com.example;
class Solution {
    public int[] pluck(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }

        int minEven = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            
            // Check if the value is even
            if (value % 2 == 0) {
                // We are looking for the smallest even value.
                // If we find a strictly smaller even value, update both minEven and minIndex.
                // If we find an equal even value, we ignore it because we want the smallest index (which is already stored).
                if (value < minEven) {
                    minEven = value;
                    minIndex = i;
                }
            }
        }

        // If minIndex remains -1, it means no even values were found.
        if (minIndex == -1) {
            return new int[0];
        } else {
            // Return [smallest_even_value, its_index]
            return new int[]{minEven, minIndex};
        }
    }
}