package com.example;
public class HumanEval_139 {

    public static long specialFactorial(int n) {

        if (n <= 0) throw new IllegalArgumentException("Input must be greater than zero");

        long fac = 1, ans = 1;

        for (int i = 2; i <= n; i++) {

            fac *= i;
            ans *= fac;

        }

        return ans;

    }


    public static void main(String[] args) {

        int inputNumber = 4;

        System.out.println("Special Factorial of " + inputNumber + ": " + specialFactorial(inputNumber));

    }

}