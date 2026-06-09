package com.example;
class Solution {
    /**
     * Returns 2^n modulo p.
     * Uses long to prevent overflow during intermediate multiplications.
     * @param n The exponent.
     * @param p The modulus.
     * @return 2^n mod p.
     */
    public static long modp(long n, long p) {
        long res = 1;
        long x = 2;

        while (n > 0) {
            // If n is odd, multiply result by x
            if ((n & 1) == 1) {
                res = (res * x) % p;
            }
            
            // Square x
            x = (x * x) % p;
            
            // Halve n
            n >>= 1;
        }
        
        return res;
    }
}