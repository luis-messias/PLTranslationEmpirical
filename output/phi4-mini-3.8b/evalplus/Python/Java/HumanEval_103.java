package com.example;
public class HumanEval_103 {

    public static String roundedAvg(int n, int m) {

        if (n > m) return "-1";

        double average = ((double)(n + m)) / 2;

        long roundedValue = Math.round(average);

        return Long.toBinaryString(roundedValue).substring(2); // Remove "0b" prefix

    }

}