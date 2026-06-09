package com.example;
class Solution {
    /**
     * Given an array arr of integers, find the minimum number of elements that
     * need to be changed to make the array palindromic. A palindromic array is an array that
     * is read the same backwards and forwards. In one change, you can change one element to any other element.
     *
     * For example:
     * smallest_change(new int[]{1,2,3,5,4,7,9,6}) == 4
     * smallest_change(new int[]{1, 2, 3, 4, 3, 2, 2}) == 1
     * smallest_change(new int[]{1, 2, 3, 2, 1}) == 0
     */
    public int smallestChange(int[] arr) {
        int n = arr.length;
        int changes = 0;
        for (int i = 0; i < n / 2; i++) {
            // Compare arr[i] with arr[n - 1 - i]
            if (arr[i] != arr[n - 1 - i]) {
                changes++;
            }
        }
        return changes;
    }
}