package com.example;
public class HumanEval_13 {
    public static int greatestCommonDivisor(int a, int b) {
        /**
         * Return a greatest common divisor of two integers a and b
         */
        return queryGCD(a, b);
    }

    private static int queryGCD(int a, int b) {
        return (b == 0) ? a : queryGCD(b, a % b);
    }
}