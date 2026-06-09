package com.example;
import java.util.List;
import java.util.ArrayList;

public class HumanEval_62 {
    /**
     * xs represent coefficients of a polynomial.
     * xs[0] + xs[1] * x + xs[2] * x^2 + ....
     * Return derivative of this polynomial in the same form.
     */
    public static List<Integer> derivative(List<Integer> xs) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < xs.size(); i++) {
            result.add(xs.get(i) * i);
        }
        return result;
    }
}