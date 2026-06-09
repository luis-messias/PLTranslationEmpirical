package com.example;
class Solution {
    public static String solve(int N) {
        // Calculate the sum of the digits of N
        int sum = 0;
        int tempN = N;

        // Handle the case where N might be 0 initially, although the loop handles it fine if we start with tempN > 0
        if (tempN == 0) {
            sum = 0;
        } else {
            while (tempN > 0) {
                sum += tempN % 10;
                tempN /= 10;
            }
        }

        // Return the binary representation of the sum as a string
        return Integer.toBinaryString(sum);
    }
}