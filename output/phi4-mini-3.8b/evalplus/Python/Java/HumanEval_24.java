package com.example;
public class HumanEval_24 {

    public static int largest_divisor(int n) {

        for (int i = 2; i < n; i++) {

            if (n % i == 0) return n / i;

        }

        return 1;

    }


    public static void main(String[] args) {

        System.out.println(largest_divisor(15)); // Output: 5

    }

}