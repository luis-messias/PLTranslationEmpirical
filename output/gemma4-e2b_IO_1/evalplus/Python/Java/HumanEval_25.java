package com.example;
import java.util.ArrayList;
import java.util.List;

public class HumanEval_25 {

    public static List<Integer> factorize(int n) {
        List<Integer> fact = new ArrayList<>();
        int tempN = n;

        // Handle factor 2
        while (tempN % 2 == 0) {
            fact.add(2);
            tempN /= 2;
        }

        // Handle odd factors
        for (int i = 3; i * i <= tempN; i += 2) {
            while (tempN % i == 0) {
                fact.add(i);
                tempN /= i;
            }
        }

        // If tempN is still greater than 1, it is the remaining prime factor
        if (tempN > 1) {
            fact.add(tempN);
        }

        return fact;
    }
}
