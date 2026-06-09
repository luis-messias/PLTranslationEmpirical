package com.example;
import java.util.ArrayList;

public class HumanEval_96 {

    public static ArrayList<Integer> countUpTo(int n) {

        if (n <= 1) {
            return new ArrayList<>();
        }

        boolean[] isPrime = new boolean[n + 1];

        for (int i = 2; i < Math.sqrt(n); i++) {

            if (!isPrime[i]) continue;

            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }

        }


        ArrayList<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= n; i++) {

            if (!isPrime[i]) continue;

            primes.add(i);

        }

        return primes;

    }

}