package com.example;
public class HumanEval_49 {
    public static long modp(long n, long p) {
        long res = 1;
        long x = 2;

        // Handle the case where p=1, although typically p >= 2 for modulo operations.
        if (p == 1) return 0;

        while (n != 0) {
            // If n is odd, update result: res = (res * x) % p
            if (n % 2 == 1) {
                res = (res * x) % p;
            }
            
            // Square x: x = (x * x) % p
            x = (x * x) % p;
            
            // n = n / 2
            n /= 2;
        }
        
        // The final result is res (which already holds the result modulo p)
        return res;
    }
}