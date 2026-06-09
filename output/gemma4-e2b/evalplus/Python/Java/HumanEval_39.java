package com.example;
import java.util.Random;

public class HumanEval_39 {

    /**
     * Tests if n is prime using the Miller-Rabin primality test.
     * This implementation mimics the logic structure of the Python version.
     */
    private static boolean millerRabin(long n, int k) {
        if (n < 2) {
            return false;
        }
        if (n == 2 || n == 3) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }

        long d = n - 1;
        int r = 0;
        while (d % 2 == 0) {
            r++;
            d /= 2;
        }

        Random random = new Random();

        for (int i = 0; i < k; i++) {
            // Generate a random base a in [2, n - 2]
            // Note: For small n, n-2 might be less than 2, handle edge cases if necessary, 
            // but for n > 3, n-2 >= 2.
            long a;
            if (n <= 3) {
                // Should not happen if called correctly, but handle defensively
                return true; 
            } else {
                a = 2 + random.nextInt((int) (n - 3));
            }
            
            // Use modular exponentiation: x = a^d mod n
            long x = power(a, d, n);

            if (x == 1 || x == n - 1) {
                continue;
            }

            boolean composite = true;
            for (int j = 0; j < r - 1; j++) {
                x = power(x, 2, n);
                if (x == n - 1) {
                    composite = false;
                    break;
                }
            }
            if (composite) {
                return false;
            }
        }

        return true;
    }

    /**
     * Helper function for modular exponentiation (a^b mod m)
     */
    private static long power(long a, long b, long m) {
        long res = 1;
        a %= m;
        while (b > 0) {
            if (b % 2