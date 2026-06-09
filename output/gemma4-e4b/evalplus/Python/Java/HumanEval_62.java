package com.example;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<Integer> derivative(List<Integer> xs) {
        List<Integer> result = new ArrayList<>();
        
        // The derivative coefficients are calculated for indices i = 1 up to xs.size() - 1.
        // The coefficient for x^(i-1) in the derivative is i * xs[i].
        for (int i = 1; i < xs.size(); i++) {
            // xs.get(i) is the coefficient of x^i in the original polynomial.
            // The derivative term is i * xs.get(i) * x^(i-1).
            int newCoefficient = xs.get(i) * i;
            result.add(newCoefficient);
        }
        return result;
    }
}