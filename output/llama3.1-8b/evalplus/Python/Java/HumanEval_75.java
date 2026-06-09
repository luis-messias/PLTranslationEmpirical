package com.example;
import java.util.Arrays;

public class HumanEval_75 {
    public static boolean isMultiplyPrime(int a) {
        if (a <= 1) return false;
        boolean[] isprime = new boolean[a + 1];
        Arrays.fill(isprime, true);
        for (int i = 2; i < a + 1; i++) {
            if (isprime[i]) {
                for (int j = i + i; j < a + 1; j += i) {
                    isprime[j] = false;
                }
            }
        }
        int cnt = 0, tmp = a;
        for (int i = 2; i < a + 1; i++) {
            while (isprime[i] && tmp % i == 0) {
                tmp /= i;
                cnt++;
            }
        }
        return cnt == 3;
    }

    public static void main(String[] args) {
        System.out.println(isMultiplyPrime(30)); // prints: true
    }
}