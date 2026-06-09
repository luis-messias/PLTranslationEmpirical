package com.example;
import java.util.Random;

public class HumanEval_39 {
    public static int primeFib(int n) {
        Random random = new Random();
        boolean millerRabin(int n, int k) {
            if (n < 2)
                return false;
            if (n == 2 || n == 3)
                return true;
            if (n % 2 == 0)
                return false;

            int r = 0;
            int d = n - 1;
            while (d % 2 == 0) {
                r += 1;
                d /= 2;
            }

            for (int i = 0; i < k; i++) {
                int a = random.nextInt(n - 2) + 2;
                int x = powMod(a, d, n);
                if (x == 1 || x == n - 1)
                    continue;
                for (int j = 0; j < r - 1; j++) {
                    x = powMod(x, 2, n);
                    if (x == n - 1)
                        break;
                }
                else
                    return false;
            }

            return true;
        }

        int cPrime = 0;
        int a = 0, b = 1;
        while (cPrime < n) {
            int temp = a;
            a = b;
            b = temp + b;
            if (millerRabin(b))
                cPrime++;
        }
        return b;
    }

    private static int powMod(int base, int exponent, int mod) {
        int result = 1;
        while (exponent > 0) {
            if ((exponent & 1) == 1)
                result = (int) ((long) result * base % mod);
            base = (int) ((long) base * base % mod);
            exponent >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(primeFib(1));
        System.out.println(primeFib(2));
        System.out.println(primeFib(3));
        System.out.println(primeFib(4));
        System.out.println(primeFib(5));
    }
}