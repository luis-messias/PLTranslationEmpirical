package com.example;
public class HumanEval_31 {
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        int n_sqrt = 1;
        while (n_sqrt * n_sqrt < n) n_sqrt++;
        for (int i = 2; i <= Math.min(n_sqrt, n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(6)); // False
        System.out.println(isPrime(101)); // True
        System.out.println(isPrime(11)); // True
        System.out.println(isPrime(13441)); // True
        System.out.println(isPrime(61)); // True
        System.out.println(isPrime(4)); // False
        System.out.println(isPrime(1)); // False
    }
}