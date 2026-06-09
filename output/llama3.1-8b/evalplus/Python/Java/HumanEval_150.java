package com.example;
public class HumanEval_150 {
    public static int xOrY(int n, int x, int y) {
        /**
         * A simple program which should return the value of x if n is 
         * a prime number and should return the value of y otherwise.
         */
        
        boolean isPrime = true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        }

        return isPrime ? x : y;
    }

    public static void main(String[] args) {
        System.out.println(xOrY(7, 34, 12)); // prints: 34
        System.out.println(xOrY(15, 8, 5)); // prints: 5
    }
}