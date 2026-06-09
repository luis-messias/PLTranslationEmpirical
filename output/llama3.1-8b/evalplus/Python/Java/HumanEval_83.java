package com.example;
public class HumanEval_83 {
    public static int startsOneEnds(int n) {
        /**
         * Given a positive integer n, return the count of the numbers of n-digit
         * positive integers that start or end with 1.
         */
        
        if (n == 1) return 1;
        return 18 * Math.pow(10, n - 2);
    }
}