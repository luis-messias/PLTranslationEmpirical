package com.example;
import java.lang.Math;

public class HumanEval_32 {

    public static double poly(double[] xs, double x) {
        double result = 0;
        for (int i = 0; i < xs.length; i++) {
            result += xs[i] * Math.pow(x, i);
        }
        return result;
    }

    public static double findZero(double[] xs) {
        if (xs.length % 2 != 0) {
            throw new IllegalArgumentException("List of coefficients must have an even number of elements");
        }

        double[] dxs = new double[xs.length];
        for (int i = 1; i < xs.length; i++) {
            dxs[i - 1] = xs[i] * i;
        }

        double x = 0, tol = 1e-5;
        int iterations = 0;
        while (iterations < 1000) {
            double fx = poly(xs, x);
            if (Math.abs(fx) < tol) break;
            x -= fx / poly(dxs, x);
            iterations++;
        }

        return x;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(Math.round(findZero(new double[]{1, 2}) * 100.0) / 100.0); // f(x) = 1 + 2x
        System.out.println(Math.round(findZero(new double[]{-6, 11, -6, 1}) * 100.0) / 100.0); // (x - 1) * (x - 2) * (x - 3) = -6 + 11x - 6x^2 + x^3
    }
}
