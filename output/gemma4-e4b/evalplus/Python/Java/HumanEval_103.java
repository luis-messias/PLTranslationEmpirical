package com.example;
class Solution {
    /**
     * You are given two positive integers n and m, and your task is to compute the
     * average of the integers from n through m (including n and m). 
     * Round the answer to the nearest integer and convert that to binary.
     * If n is greater than m, return -1.
     * Example:
     * rounded_avg(1, 5) => "0b11"
     * rounded_avg(7, 5) => -1
     * rounded_avg(10, 20) => "0b1111"
     * rounded_avg(20, 33) => "0b11010"
     */
    public String roundedAvg(int n, int m) {
        if (n > m) {
            return "-1"; // Assuming the return type should handle the string representation of -1 based on the Python example
        }
        
        // The average of an arithmetic progression (n to m) is (n + m) / 2.
        // Since we are dealing with integers, we calculate the average and round it.
        // The Python code uses round((n + m) / 2).
        // For integer arithmetic, (n + m) / 2 is sufficient if we assume standard rounding behavior 
        // for the average of integers.
        
        // Since n and m are positive integers, (n + m) / 2 will be calculated using floating point 
        // division in Python before rounding.
        double avgDouble = (double) (n + m) / 2.0;
        long avg = Math.round(avgDouble);
        
        // Convert the rounded average to binary string representation.
        // Java's Integer.toBinaryString() or Long.toBinaryString() is used.
        // The Python output format "0b..." is usually handled by the caller/test framework, 
        // but we replicate the core binary conversion.
        return "0b" + Long.toBinaryString(avg);
    }
}