package com.example;
public class HumanEval_59 {

    public static void main(String[] args) {
        System.out.println(largest_prime_factor(13195)); // Output: 29
        System.out.println(largest_prime_factor(2048));   // Output: 2

    }


    private static int largest_prime_factor(int n) {

        boolean[] isprime = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            isprime[i] = true;
        }

        for (int i = 2; i * i <= n; i++) {

            if (!isprime[i]) continue;

            for (int j = i * i; j <= n; j += i) {

                isprime[j] = false;

            }

        }


        int result = -1;

        for (int i = 0; i < n + 1; i++) {

            if (!isprime[i]) continue;

            if (n % i == 0) {

                result = Math.max(result, i);

            }

        }

        return result;

    }

}