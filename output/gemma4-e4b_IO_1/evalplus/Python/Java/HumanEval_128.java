package com.example;
class Solution {
    /**
     * Calculates the sum of magnitudes of integers multiplied by the product of all signs
     * of each number in the array.
     * Returns null for empty array.
     *
     * @param arr The array of integers.
     * @return The calculated product, or null if the array is empty.
     */
    public Integer prodSigns(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        // Check if zero is present in the array. If so, the product of signs is 0.
        for (int x : arr) {
            if (x == 0) {
                return 0;
            }
        }

        // s stores the sum of magnitudes (using long to prevent overflow)
        long s =
