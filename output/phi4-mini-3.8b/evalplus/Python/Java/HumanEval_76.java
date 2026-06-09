package com.example;
public class HumanEval_76 {

    public static boolean isSimplePower(int x, int n) {

        if (x == 1) return true;

        if (n == 0 && x != 0) return false; // Avoid division by zero and check for non-zero result.

        if (n == 1 || abs(n) > Math.abs(x)) return false;

        long p = n;

        while (Math.abs(p) <= Math.abs(x)) {

            if (p == x) return true;

            p *= n;
        }

        return false;

    }


    private static int abs(int value) {

        return (value < 0) ? -value : value;

    }

}