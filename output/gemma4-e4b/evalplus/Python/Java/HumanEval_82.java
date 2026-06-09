package com.example;
class Solution {
    private static boolean isPrime(int a) {
        if (a < 2) {
            return false;
        }
        for (int i = 2; i * i <= a; i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean primeLength(String string) {
        return isPrime(string.length());
    }
}