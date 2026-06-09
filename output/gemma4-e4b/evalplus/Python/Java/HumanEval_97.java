package com.example;
class Solution {
    /**
     * Complete the function that takes two integers and returns 
     * the product of their unit digits.
     * Assume the input is always valid.
     */
    public static int multiply(int a, int b) {
        // Get the unit digit of 'a'. Math.abs ensures the result is 0-9 even for negative numbers.
        int unitA = Math.abs(a % 10);
        
        // Get the unit digit of 'b'.
        int unitB = Math.abs(b % 10);
        
        return unitA * unitB;
    }
}