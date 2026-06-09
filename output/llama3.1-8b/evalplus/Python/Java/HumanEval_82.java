package com.example;
import java.util.Arrays;

public class HumanEval_82 {
    public static boolean primeLength(String string) {
        return isPrime(string.length());
    }

    private static boolean isPrime(int a) {
        if (a < 2) {
            return false;
        }
        for (int x = 2; x <= Math.sqrt(a); x++) {
            if (a % x == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(primeLength("Hello")); // prints: true
        System.out.println(primeLength("abcdcba")); // prints: true
        System.out.println(primeLength("kittens")); // prints: true
        System.out.println(primeLength("orange")); // prints: false
    }
}