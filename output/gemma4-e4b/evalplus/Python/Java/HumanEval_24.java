package com.example;
class Solution {
    public static int largestDivisor(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return n / i;
            }
        }
        return 1;
    }
}