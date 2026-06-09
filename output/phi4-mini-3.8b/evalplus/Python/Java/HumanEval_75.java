package com.example;
public class HumanEval_75 {

    public static boolean isMultiplyPrime(int a) {

        if (a <= 1) return false;

        int[] prime = new int[a + 1];

        for (int i = 2; i * i <= a; i++) {

            if (prime[i] == true) {

                for (int j = i * i; j <= a; j += i)

                    prime[j] = false;

            }

        }


        int cnt, tmp = a;


        for (int i = 2; i < Math.sqrt(a); i++) {

            if (prime[i]) {

                while (tmp % i == 0) {

                    tmp /= i;

                    cnt++;

                }

            }

        }


        return cnt == 3 && tmp > 1;

    }



}