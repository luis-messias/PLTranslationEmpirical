package com.example;
class Solution {
    /**
     * Given a positive integer N, return the total sum of its digits in binary.
     *
     * @param N integer
     * @return a string of binary number
     */
    public String solve(int N) {
        // Calculate the sum of digits
        int sum = 0;
        String sN = String.valueOf(N);
        for (char c : sN.toCharArray()) {
            // Convert character digit to integer value
            sum += c - '0';
        }

        // Convert the sum to its binary string representation
        return Integer.toBinaryString(sum);
    }
}