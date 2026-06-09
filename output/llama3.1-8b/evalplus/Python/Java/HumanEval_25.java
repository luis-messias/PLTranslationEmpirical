package com.example;
import java.util.ArrayList;
import java.util.List;

public class HumanEval_25 {
    public static List<Integer> factorize(int n) {
        List<Integer> fact = new ArrayList<>();
        int i = 2;
        while (i <= Math.sqrt(n) + 1) {
            if (n % i == 0) {
                fact.add(i);
                n /= i;
            } else {
                i++;
            }
        }

        if (n > 1) {
            fact.add(n);
        }
        return fact;
    }

    public static void main(String[] args) {
        System.out.println(factorize(8));
        System.out.println(factorize(25));
        System.out.println(factorize(70));
    }
}