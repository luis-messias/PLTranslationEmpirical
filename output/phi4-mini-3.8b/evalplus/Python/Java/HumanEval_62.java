package com.example;
import java.util.ArrayList;
import java.util.List;

public class HumanEval_62 {

    public static List<Integer> derivative(List<Integer> xs) {
        List<Integer> result = new ArrayList<>();
        
        for (int i = 1; i < xs.size(); i++) {
            int coefficient = xs.get(i);
            if (!result.isEmpty()) {
                // Shift the coefficients to their correct positions
                result.add(0, coefficient * i);
            } else {
                result.add(coefficient * i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> polynomial = new ArrayList<>();
        polynomial.add(3); // 3 + 1*x^2
        polynomial.add(1); // x term, coefficient is implicitly 0 for this example.
        polynomial.add(2);
        polynomial.add(4);
        polynomial.add(5);

        System.out.println(polynomialDerivative(polynomial)); // Output: [6, 8]
    }
}