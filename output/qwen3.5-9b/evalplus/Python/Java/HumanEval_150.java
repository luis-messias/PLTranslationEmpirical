package com.example;
public class HumanEval_150 {
    public static int x_or_y(int n, int x, int y) {
        return is_prime(n) ? x : y;
    }
    
    private static boolean is_prime(int a) {
        if (a < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }
}