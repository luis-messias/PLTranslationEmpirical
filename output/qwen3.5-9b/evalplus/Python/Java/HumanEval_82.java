package com.example;
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
}