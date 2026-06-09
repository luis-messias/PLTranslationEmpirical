package com.example;
public class HumanEval_55 {

    public static int fib(int n) {

        if (n == 0) return 0;

        if (n <= 2) return 1;


        long a = 1, b = 1;

        for (int i = 3; i <= n; i++) {

            long temp = a + b;

            a = b;

            b = temp;

        }

        return (int)b;

    }


    public static void main(String[] args) {

        System.out.println(fib(10)); // Output: 55

        System.out.println(fib(1));  // Output: 1

        System.out.println(fib(8));  // Output: 21

    }

}