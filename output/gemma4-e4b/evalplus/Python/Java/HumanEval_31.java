package com.example;
class Solution {
    /**
     * Return true if a given number is prime, and false otherwise.
     * @param n The number to check.
     * @return true if n is prime, false otherwise.
     */
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        
        // We only need to check divisibility up to the square root of n.
        // We use long for the square root calculation to prevent potential overflow 
        // if n was close to Integer.MAX_VALUE, although for standard int inputs, 
        // Math.sqrt(n) cast to int is usually sufficient.
        int limit = (int) Math.sqrt(n);

        for (int i = 2; i <= limit; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}