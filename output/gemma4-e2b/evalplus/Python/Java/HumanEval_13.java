package com.example;
class Solution {
    public int greatestCommonDivisor(int a, int b) {
        // Euclidean algorithm implemented recursively
        if (b == 0) {
            return a;
        } else {
            return greatestCommonDivisor(b, a % b);
        }
    }
}