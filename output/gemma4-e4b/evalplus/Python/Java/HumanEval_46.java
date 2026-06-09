package com.example;
class Solution {
    public long fib4(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 0;
        } else {
            // a = fib4(i-4), b = fib4(i-3), c = fib4(i-2), d = fib4(i-1)
            // Initialize for i=4 calculation:
            // a = fib4(0) = 0
            // b = fib4(1) = 0
            // c = fib4(2) = 2
            // d = fib4(3) = 0
            long a = 0;
            long b = 0;
            long c = 2;
            long d = 0;

            // Loop starts from i=4 up to n
            for (int i = 4; i <= n; i++) {
                // Calculate the next term: fib4(i) = a + b + c + d
                long next_d = a + b + c + d;

                // Shift the values: (a, b, c, d) -> (b, c, d, next_d)
                a = b;
                b = c;
                c = d;
                d = next_d;
            }
            return d;
        }
    }
}