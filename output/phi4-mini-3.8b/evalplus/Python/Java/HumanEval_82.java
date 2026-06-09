package com.example;
public class HumanEval_82 {

    public static boolean prime_length(String str) {
        // Write a function that takes a string and returns true if the string length is a prime number or false otherwise.
        
        int len = str.length();
        return isPrime(len);
    }

    private static boolean isPrime(int num) {
        // Helper method to check for primality
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

}