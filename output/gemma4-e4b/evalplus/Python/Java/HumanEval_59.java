package com.example;
import java.util.Arrays;

class Solution {
    /**
     * Return the largest prime factor of n. Assume n > 1 and is not a prime.
     * @param n The number.
     * @return The largest prime factor.
     */
    public static int largestPrimeFactor(int n) {
        // isprime[i] will be true if i is prime. Size n+1 to accommodate index n.
        boolean[] isprime = new boolean[n + 1];
        Arrays.fill(isprime, true);
        
        // 0 and 1 are not prime
        isprime[0] = false;
        isprime[1] = false;

        // Sieve of Eratosthenes up to n
        for (int i = 2; i <= n; i++) {
            if (isprime[i]) {
                // Mark multiples of i as composite.
                // Python's range(i + i, n, i) means starting at 2*i, up to n-1, step i.
                for (int j = i + i; j < n; j += i) {
                    isprime[j] = false;
                }
            }
        }

        // Iterate downwards from n-1 to 1 to find the largest prime factor
        for (int i = n - 1; i >= 1; i--) {
            // Check if i is prime AND if i divides n
            if (isprime[i] && (n % i == 0)) {
                return i;
            }
        }
        
        // Should not be reached given the assumption n > 1 and n is not prime.
        return -1; 
    }
}