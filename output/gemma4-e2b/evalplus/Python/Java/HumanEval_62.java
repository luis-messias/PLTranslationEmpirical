package com.example;
class Solution {
    public static int[] derivative(int[] xs) {
        int n = xs.length;
        if (n <= 1) {
            return new int[0];
        }

        int[] result = new int[n - 1];

        // The derivative rule is: d/dx (xs[i] * x^i) = i * xs[i] * x^(i-1)
        // We iterate i from 1 up to n-1 (which corresponds to the indices of xs we use)
        // The Python code iterates i from 1 to len(xs) - 1, using xs[i] and i as the multiplier.
        // In Java, we iterate i from 1 to n-1.
        // The result index is i - 1.
        for (int i = 1; i < n; i++) {
            // xs[i] is the coefficient of x^i
            // i is the power of x
            // The new coefficient for x^(i-1) is i * xs[i]
            result[i - 1] = xs[i] * i;
        }

        return result;
    }
}