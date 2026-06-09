package com.example;
class Solution {
    /**
     * Given an array representing a branch of a tree that has non-negative integer nodes,
     * your task is to pluck one of the nodes and return it.
     * The plucked node should be the node with the smallest even value.
     * If multiple nodes with the same smallest even value are found return the node that has smallest index.
     *
     * The plucked node should be returned in an array, [smallest_value, its_index].
     * If there are no even values or the given array is empty, return an empty array.
     *
     * @param arr The input array of node values.
     * @return An int array [value, index] or an empty array.
     */
    public int[] pluck(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }

        // Pass 1: Find the minimum even value
        int minEvenValue = Integer.MAX_VALUE;
        boolean foundEven = false;

        for (int x : arr) {
            if (x % 2 == 0) {
                foundEven = true;
                if (x < minEvenValue) {
                    minEvenValue = x;
                }
            }
        }

        // If no even values were found
        if (!foundEven) {
            return new int[0];
        }

        // Pass 2: Find the smallest index of minEvenValue
        // Since we iterate from i=0 upwards, the first match guarantees the smallest index.
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == minEvenValue) {
                return new int[]{minEvenValue, i};
            }
        }

        // Should not be reached if logic is correct and foundEven is true
        return new int[0];
    }
}