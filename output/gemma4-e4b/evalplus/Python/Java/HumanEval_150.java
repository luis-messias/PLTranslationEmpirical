package com.example;
class Solution {
    /**
     * Helper function to check if a number is prime.
     * @param a The number to check.
     * @return true if a is prime, false otherwise.
     */
    private static boolean isPrime(int a) {
        if (a < 2) {
            return false;
        }
        // Check divisibility up to the square root of a
        for (int i = 2; i * i <= a; i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the value of x if n is a prime number and y otherwise.
     * 
     * @param n The number to check for primality.
     * @param x The value to return if n is prime.
     * @param y The value to return if n is not prime.
     * @return x or y based on the primality of n.
     */
    public static int xOrY(int n, int x, int y) {
        if (isPrime(n)) {
            return x;
        } else {
            return y;
        }
    }
}