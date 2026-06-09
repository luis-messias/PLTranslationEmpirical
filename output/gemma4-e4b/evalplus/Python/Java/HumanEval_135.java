package com.example;
class Solution {
    /**
     * Creates a function which returns the largest index of an element which
     * is not greater than or equal to the element immediately preceding it. If
     * no such element exists then return -1. The given array will not contain
     * duplicate values.
     *
     * Examples:
     * can_arrange([1,2,4,3,5]) = 3
     * can_arrange([1,2,3]) = -1
     */
    public static int canArrange(int[] arr) {
        for (int i = arr.length - 1; i >= 1; i--) {
            if (!(arr[i] >= arr[i - 1])) {
                return i;
            }
        }
        return -1;
    }
}