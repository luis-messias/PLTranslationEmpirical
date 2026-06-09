package com.example;
import java.util.Arrays;

public class HumanEval_32 {

    /**
     * Evaluates polynomial with coefficients xs at point x.
     * P(x) = xs[0] + xs[1] * x + xs[2] * x^2 + .... xs[n] * x^n
     *
     * @param xs The array of coefficients.
     * @param x The point at which to evaluate the polynomial.
     * @return The value of the polynomial at x.
     */
    public static double poly(double[] xs, double x) {
        double sum = 0.0;
        for (int i = 0; i < xs.length; i++) {
            // xs[i] * x^i
            sum += xs[i] * Math.pow(x, i);
        }
        return sum;