package com.example;
public class HumanEval_31 {

    public static boolean isPrime(int number) {

        if (number <= 1) return false;

        int sqrt = 2;

        while ((sqrt * sqrt) < number) { sqrt++; }

        for (int i = 2; i <= Math.min(sqrt, number); i++) {

            if (number % i == 0) return false;

        }

        return true;

    }


    public static void main(String[] args) {

        System.out.println(isPrime(6)); // False

        System.out.println(isPrime(101)); // True

        System.out.println(isPrime(11)); // True

        System.out.println(isPrime(13441)); // True

        System.out.println(isPrime(61)); // True

        System.out.println(isPrime(4)); // False

        System.out.println(isPrime(1)); // False

    }

}