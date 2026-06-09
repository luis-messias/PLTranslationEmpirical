package com.example;

public class HumanEval_75 {

    public static boolean isMultiplyPrime(int a) {
        if (a <= 1) return false;
        
        int[] prime = new int[a + 1];
        for (int i = 2; i * i < a; ++i) {
            if (!prime[i]) continue;

            for (int j = i * i, k = i; j <= a; j += k)
                prime[j] = false;
        }

        int cnt = 0, tmp = a;
        
        while (tmp > 1 && !isPrime[tmp])
            --cnt;

        return ++cnt == 3;
    }
    
    private static boolean isPrime(int num) {
        for (int i = 2; i * i <= num; ++i)
            if (!prime[i] || prime[num % i + 1]) return false;
        
        return true;
    }

}
