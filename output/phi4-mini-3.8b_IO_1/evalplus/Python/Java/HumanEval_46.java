package com.example;

public class HumanEval_46 {

    public static int fib4(int n) {
        if (n == 0 || n == 1) {
            return 0;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 0;
        }

        long a = 0, b = 0, c = 2L, d = 0;

        for (int i = 4; i <= n; i++) {
            int tempA = (a + b + c + d);
            a = b;
            b = c;
            c = d;
            d = tempA;
        }

        return (int) d;
    }

    public static void main(String[] args) {
        System.out.println(fib4(5)); // Output: 8
        System.out.println(fib4(6)); // Output: 14
        System.out.println(fib4(7)); // Output: 24
    }
}
