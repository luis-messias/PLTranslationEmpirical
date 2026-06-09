package com.example;
class Solution {
    public boolean primeLength(String string) {
        int n = string.length();

        if (n < 2) {
            return false;
        }

        // Check if n is prime
        // The logic is: a number n is prime if it is greater than 1 and
        // not divisible by any integer from 2 up to sqrt(n).
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}