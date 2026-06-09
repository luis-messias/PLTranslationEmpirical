package com.example;
public class HumanEval_79 {
    public static String decimalToBinary(int decimal) {
        return "db" + Integer.toBinaryString(decimal) + "db";
    }

    public static void main(String[] args) {
        System.out.println(decimalToBinary(15));   // returns "db1111db"
        System.out.println(decimalToBinary(32));   // returns "db100000db"
    }
}