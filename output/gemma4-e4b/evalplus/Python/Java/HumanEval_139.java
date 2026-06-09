package com.example;
class Solution {
    public static long specialFactorial(int n) {
        if (n < 1) {
            // Based on the definition (n > 0), we handle non-positive input.
            // If n=0, the product is empty, usually 1.
            return 1;
        }

        long fac = 1;
        long ans = 1;

        // The loop calculates the product of i! for i=2 to n.
        for (int i = 2; i <= n; i++) {
            // fac calculates i!
            fac *= i;
            // ans accumulates the product: 2! * 3! * ... * n!
            ans *= fac;
        }
        return ans;
    }
}