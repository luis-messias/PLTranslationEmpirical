package com.example;
public class HumanEval_76 {
    public static boolean isSimplePower(int x, int n) {
        if (x == 1) return true;
        if (n == 0) return x == 0;
        if (n == 1) return x == 1;
        if (n == -1) return Math.abs(x) == 1;
        long p = n;
        while (Math.abs(p) <= Math.abs(x)) {
            if (p == x) return true;
            p *= n;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isSimplePower(1, 4)); // true
        System.out.println(isSimplePower(2, 2)); // true
        System.out.println(isSimplePower(8, 2)); // true
        System.out.println(isSimplePower(3, 2)); // false
        System.out.println(isSimplePower(3, 1)); // false
        System.out.println(isSimplePower(5, 3)); // false
    }
}