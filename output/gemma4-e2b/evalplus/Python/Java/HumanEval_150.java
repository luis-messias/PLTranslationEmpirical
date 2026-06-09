package com.example;
class Solution {
    /**
     * A simple program which should return the value of x if n is 
     * a prime number and should return the value of y otherwise.
     *
     * Examples:
     * xOrY(7, 34, 12) == 34
     * xOrY(15, 8, 5) == 5
     */
    public int xOrY(int n, int x, int y) {
        // Helper function equivalent to is_prime(n)
        boolean isPrime = true;
        if (n < 2) {
            isPrime = false;
        } else {
            // Check for factors up to sqrt(n)
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        return isPrime ? x : y;
    }
}