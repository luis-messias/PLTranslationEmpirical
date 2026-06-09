package com.example;
public class HumanEval_60 {

    public static int sumToN(int n) {

        return ((n + 1) * n) / 2;

    }


    public static void main(String[] args) {

        System.out.println(sumToN(30)); // Output: 465

        System.out.println(sumToN(100)); // Output: 5050

        System.out.println(sumToN(5));   // Output: 15

        System.out.println(sumToN(10));  // Output: 55

        System.out.println(sumToN(1));    // Output: 1

    }

}