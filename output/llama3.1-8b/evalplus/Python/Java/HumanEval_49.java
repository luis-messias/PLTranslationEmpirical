package com.example;
public class HumanEval_49 {
    public static int modp(int n, int p) {
        long res = 1;
        long x = 2;
        while (n != 0) {
            if ((n & 1) == 1) {
                res = (res * x) % p;
            }
            x = (x * x) % p;
            n >>= 1;
        }
        return (int) (res % p);
    }

    public static void main(String[] args) {
        System.out.println(modp(3, 5));
        System.out.println(modp(1101, 101));
        System.out.println(modp(0, 101));
        System.out.println(modp(3, 11));
        System.out.println(modp(100, 101));
    }
}