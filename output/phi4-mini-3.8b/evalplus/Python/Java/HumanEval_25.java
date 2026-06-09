package com.example;
import java.util.ArrayList;
import java.util.List;

public class HumanEval_25 {

    public static List<Integer> factorize(int n) {
        List<Integer> factors = new ArrayList<>();
        int i = 2;

        while (i <= Math.sqrt(n) + 1) {
            if (n % i == 0) {
                factors.add(i);
                n /= i;
            } else {
                i++;
            }
        }

        if (n > 1) {
            factors.add(n);
        }

        return factors;
    }

    public static void main(String[] args) {
        System.out.println(factorize(8)); // [2, 2, 2]
        System.out.println(factorize(25)); // [5, 5]
        System.out.println(factorize(70)); // [2, 5, 7]
    }
}