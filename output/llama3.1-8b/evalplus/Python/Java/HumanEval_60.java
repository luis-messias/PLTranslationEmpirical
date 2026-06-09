package com.example;
public class HumanEval_60 {
    public static int sumToN(int n) {
        /**
         * This function calculates the sum of numbers from 1 to n.
         */
        return (n + 1) * n / 2;
    }

    public static void main(String[] args) {
        System.out.println(sumToN(30));
        System.out.println(sumToN(100));
        System.out.println(sumToN(5));
        System.out.println(sumToN(10));
        System.out.println(sumToN(1));
    }
}