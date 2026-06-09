package com.example;
import java.util.Arrays;

public class HumanEval_59 {
    public static int largestPrimeFactor(int n) {
        boolean[] isprime = new boolean[n + 1];
        Arrays.fill(isprime, true);
        for (int i = 2; i <= n; i++) {
            if (isprime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isprime[j] = false;
                }
            }
        }
        for (int i = n - 1; i > 0; i--) {
            if (isprime[i] && n % i == 0) {
                return i;
            }
        }
        return -1; // This should not happen according to the problem statement
    }

    public static void main(String[] args) {
        System.out.println(largestPrimeFactor(13195)); // prints: 29
        System.out.println(largestPrimeFactor(2048)); // prints: 2
    }
}