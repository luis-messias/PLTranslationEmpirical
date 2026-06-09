package com.example;
public class HumanEval_138 {
    public static boolean isEqualToSumEven(int n) {
        /**
         * Evaluate whether the given number n can be written as the sum of exactly 4 positive even numbers.
         */
        return n >= 8 && n % 2 == 0;
    }

    public static void main(String[] args) {
        System.out.println(isEqualToSumEven(4)); // False
        System.out.println(isEqualToSumEven(6)); // False
        System.out.println(isEqualToSumEven(8)); // True
    }
}