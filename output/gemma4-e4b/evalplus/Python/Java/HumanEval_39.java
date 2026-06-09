package com.example;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

public class HumanEval_39 {

    /**
     * Test if n is prime using the Miller-Rabin primality test.
     * @param n The number to test.
     * @param k The number of iterations (higher k means higher certainty).
     * @return true if n is likely prime, false otherwise.
     */
    private static boolean millerRabin(BigInteger n, int k) {
        // Handle small cases
        if (n.compareTo(BigInteger.valueOf(2)) < 0) return false;
        if (n.equals(BigInteger.valueOf(2)) || n.equals(BigInteger.valueOf(3))) return true;
        if (n.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) return false;

        // Find r and d such that n - 1 = 2^r * d
        BigInteger nMinusOne = n.subtract(BigInteger.ONE);
        BigInteger d = nMinusOne;
        int r = 0;
        while (d.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
            r++;
            d = d.divide(BigInteger.valueOf(2));
        }

        SecureRandom random = new SecureRandom();
        
        for (int i = 0; i < k; i++) {
            // Select random base a in [2, n - 2]
            BigInteger a;
            do {
                // Generate a random BigInteger of the same bit length as n
                a = new BigInteger(n.bitLength(), random);
            } while (a.compareTo(BigInteger.valueOf(2)) < 0 || a.compareTo(n.subtract(BigInteger.valueOf(2))) > 0);
            
            // Calculate x = a^d mod n
            BigInteger x = a.modPow(d, n);

            if (x.equals(BigInteger.ONE) || x.equals(nMinusOne)) {
                continue;
            }

            boolean composite = true;
            for (int j = 0; j < r - 1; j++) {
                // x = x^2 mod n
                x = x.modPow(BigInteger.valueOf(2), n);
                if (x.equals(nMinusOne)) {
                    composite = false;
                    break;
                }
            }

            if (composite) {
                return false; // Definitely composite
            }
        }

        return true; // Likely prime
    }

    /**
     * prime_fib returns n-th number that is a Fibonacci number and it's also prime.
     * @param n The index (1-based) of the prime Fibonacci number to find.
     * @return The n-th prime Fibonacci number as a BigInteger.
     */
    public static BigInteger prime_fib(int n) {
        // Fibonacci sequence: F(0)=0, F(1)=1, F(2)=1, F(3)=2, F(4)=3, F(5)=5, ...
        
        // We use BigInteger for Fibonacci numbers as they grow very fast.
        BigInteger a = BigInteger.ZERO; // F(i-2)
        BigInteger b = BigInteger.ONE;  // F(i-1)
        
        int count = 0;
        
        // We need to iterate until we find the n-th prime Fibonacci number.
        // The first few Fibonacci numbers are 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89...
        // Primes are 2, 3, 5, 13, 89...
        
        // Skip the first two (0 and 1) as they are not prime (or are trivial).
        // Start checking from F(3) = 2.
        
        // Initial state: a=0, b=1. We need to calculate the next term (F(3)=2) first.
        
        while (count < n) {
            // Calculate next Fibonacci number: next = a + b
            BigInteger next = a.add(b);
            
            // Update sequence: a = b, b = next
            a = b;
            b = next;
            
            // Check if the current Fibonacci number 'b' is prime.
            // We use k=10 iterations for high certainty.
            if (millerRabin(b, 10)) {
                count++;
            }
        }
        
        return b;
    }
}