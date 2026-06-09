package com.example;
class Solution {
    /**
     * Return a greatest common divisor of two integers a and b
     * @param a The first integer.
     * @param b The second integer.
     * @return The greatest common divisor of a and b.
     */
    public int greatestCommonDivisor(int a, int b) {
        return gcd(a, b);
    }

    private int gcd(int a, int b) {
        // Euclidean algorithm
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}