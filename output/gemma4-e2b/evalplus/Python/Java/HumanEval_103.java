package com.example;
class Solution {
    public String roundedAvg(int n, int m) {
        if (n > m) {
            return "-1";
        }

        // Calculate the average of the endpoints and round it.
        // Python's round() behavior (round half to even) is replicated by Math.round()
        // when dealing with doubles, although standard mathematical rounding might be expected.
        // We use double division first.
        double avgDouble = (n + m) / 2.0;
        int avg = (int) Math.round(avgDouble);

        // Convert the integer to its binary string representation.
        // We need to prepend "0b" to match the Python output format.
        String binaryString = Integer.toBinaryString(avg);
        return "0b" + binaryString;
    }
}