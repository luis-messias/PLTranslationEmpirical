package com.example;
class Solution {
    /**
     * Return n-th Fibonacci number.
     * @param n The index of the Fibonacci number to return.
     * @return The n-th Fibonacci number.
     */
    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }

        int a = 1;
        int b = 1;

        // We start the loop from the 3rd number up to the n-th number.
        // The loop runs n - 2 times.
        for (int i = 3; i <= n; i++) {
            int next = a + b;
            a = b;
            b = next;
        }
        return b;
    }
}