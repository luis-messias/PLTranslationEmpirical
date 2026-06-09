package com.example;
class Solution {
    /**
     * Given a positive integer n, return the count of the numbers of n-digit
     * positive integers that start or end with 1.
     */
    public long startsOneEnds(int n) {
        if (n == 1) {
            return 1;
        }
        // The total number of n-digit numbers is 9 * 10^(n-1).
        // Numbers starting with 1: 1 * 10^(n-1)
        // Numbers ending with 1: 9 * 10^(n-2) * 1
        // Numbers starting AND ending with 1: 1 * 10^(n-2) * 1
        // Count = (Starts with 1) + (Ends with 1) - (Starts and Ends with 1)
        // Count = 10^(n-1) + 9 * 10^(n-2) - 10^(n-2)
        // Count = 10 * 10^(n-2) + 8 * 10^(n-2)
        // Count = 18 * 10^(n-2)
        return 18 * (long) Math.pow(10, n - 2);
    }
}