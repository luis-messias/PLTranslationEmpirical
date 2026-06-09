package com.example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    /**
     * Finds all prime numbers less than n using a variation of the Sieve of Eratosthenes.
     * @param n The upper bound (exclusive).
     * @return A list of prime numbers less than n.
     */
    public List<Integer> countUpTo(int n) {
        List<Integer> ans = new ArrayList<>();

        if (n <= 2) {
            return ans;
        }

        // isPrime[i] tracks if i is prime. We need indices up to n-1.
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        // 0 and 1 are not prime
        isPrime[0] = false;
        isPrime[1] = false;

        // Iterate up to n-1
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                // i is prime
                ans.add(i);

                // Mark multiples of i as not prime.
                // Start marking from 2*i, as per the Python logic (i + i).
                for (int j = i * 2; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return ans;
    }
}