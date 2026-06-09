package com.example;
class Solution {
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        
        // Check for divisors up to the square root of n
        int limit = (int) Math.sqrt(n);
        
        for (int i = 2; i <= limit; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}