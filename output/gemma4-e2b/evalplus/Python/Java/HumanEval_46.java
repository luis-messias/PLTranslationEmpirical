package com.example;
class Solution {
    public static int fib4(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 0;
        }

        // For n >= 4, use iteration
        // a = fib4(i-4)
        // b = fib4(i-3)
        // c = fib4(i-2)
        // d = fib4(i-1)
        
        // Initialize based on fib4(0) to fib4(3)
        int a = 0; // fib4(i-4) initially fib4(0)
        int b = 0; // fib4(i-3) initially fib4(1)
        int c = 2; // fib4(i-2) initially fib4(2)
        int d = 0; // fib4(i-1) initially fib4(3)

        for (int i = 4; i <= n; i++) {
            // Calculate fib4(i) = fib4(i-1) + fib4(i-2) + fib4(i-3) + fib4(i-4)
            int next = a