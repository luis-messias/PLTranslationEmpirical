package com.example;
public class HumanEval_13 {

    public static void main(String[] args) {

        System.out.println(greatestCommonDivisor(3, 5)); // Output: 1

        System.out.println(greatestCommonDivisor(25, 15)); // Output: 5
    }


    public static int greatestCommonDivisor(int a, int b) {

        return queryGCD(a, b);
    }

    private static int queryGCD(int a, int b) {

        if (b == 0) {
            return a;
        } else {
            return queryGCD(b, a % b);
        }
    }

}