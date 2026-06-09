package com.example;
import java.util.List;
import java.util.Collections;

public class HumanEval_94 {

    private boolean isPrime(int a) {
        if (a < 2) {
            return false;
        }
        for (int i = 2; i * i <= a; i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int skjkasdkd(List<Integer> lst) {
        int largestPrime = -1;

        // Find the largest prime in the list
        for (int x : lst) {
            if (isPrime(x)) {
                if (x > largestPrime) {
                    largestPrime = x;
                }
            }
        }

        if (largestPrime == -1) {
            // Handle case where no prime is found (though examples suggest primes exist)
            return 0; 
        }

        // Calculate the sum of the digits of the largest prime
        int sum = 0;
        String primeStr = String.valueOf(largestPrime);
        for (char ch : primeStr.toCharArray()) {
            sum += ch - '0';
        }
        
        return sum;
    }
}