package com.example;
import java.util.Arrays;

class Solution {
    /**
     * Returns true if the given number is the multiplication of exactly 3 prime numbers, and false otherwise.
     * Knowing that a is less than 100.
     * Example: isMultiplyPrime(30) == true (30 = 2 * 3 * 5)
     */
    public static boolean isMultiplyPrime(int a) {
        if (a <= 1) {
            return false;
        }

        // 1. Sieve of Eratosthenes to find primes up to a
        boolean[] isprime = new boolean[a + 1];
        Arrays.fill(isprime, true);
        isprime[0] = false;
        isprime[1] = false;

        for (int i = 2; i * i <= a; i++) {
            if (isprime[i]) {
                for (int j = i * i; j <= a; j += i) {
                    isprime[j] = false;
                }
            }
        }

        // 2. Prime Factorization and Counting
        int count = 0;
        int temp = a;

        for (int i = 2; i <= a; i++) {
            // Check if i is prime AND i divides the remaining number temp
            if (isprime[i] && temp % i == 0) {
                while (isprime[i] && temp % i == 0) {
                    temp /= i;
                    count++;
                }
            }
        }
        
        return count == 3;
    }
}
