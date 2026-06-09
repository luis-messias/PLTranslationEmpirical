package com.example;
public class HumanEval_79 {
    public static String decimalToBinary(int decimal) {
        String binaryString = Integer.toBinaryString(decimal);
        return "db" + binaryString + "db";
    }
}