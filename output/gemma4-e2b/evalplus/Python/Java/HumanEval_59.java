package com.example;
import java.util.Arrays;

public class HumanEval_59 {
    public static int largestPrimeFactor(int n) {
        // 1. Sieve of Eratosthenes to determine primality up to n
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        
        if (n < 2) {
            // Based on assumption n > 1, this case shouldn't happen, but handle