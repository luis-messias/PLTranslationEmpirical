package com.example;
class Solution {
    public static long fibfib(int n) {
        if (n == 0 || n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        }

        // a = fibfib(i-3), b = fibfib(i-2), c = fibfib(i-1)
        long a = 0; // fibfib(0)
        long b = 0; // fibfib(1)
        long c = 1; // fibfib(2)

        // Loop starts from i=3 up to n
        for (int i = 3; i <= n; i++) {
            // Calculate the next term: fibfib(i) = a + b + c
            long next = a + b + c;
            
            // Shift values for the next iteration
            a = b;
            b = c;
            c = next;
        }
        return c;
    }
}