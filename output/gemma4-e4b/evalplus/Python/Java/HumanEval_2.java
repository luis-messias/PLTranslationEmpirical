package com.example;
public class HumanEval_2 {
    /**
     * Given a positive floating point number, it can be decomposed into
     * an integer part (largest integer smaller than given number) and decimals
     * (leftover part always smaller than 1).
     *
     * Return the decimal part of the number.
     *
     * @param number The positive floating point number.
     * @return The decimal part of the number.
     */
    public static double truncateNumber(double number) {
        return number - Math.floor(number);
    }
}