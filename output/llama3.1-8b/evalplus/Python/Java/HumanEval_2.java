package com.example;
public class HumanEval_2 {
    public static double truncateNumber(double number) {
        /**
         * Given a positive floating point number, it can be decomposed into 
         * an integer part (largest integer smaller than given number) and decimals 
         * (leftover part always smaller than 1).
         * 
         * Return the decimal part of the number.
         */
        return number - (int)number;
    }

    public static void main(String[] args) {
        System.out.println(truncateNumber(3.5));
    }
}