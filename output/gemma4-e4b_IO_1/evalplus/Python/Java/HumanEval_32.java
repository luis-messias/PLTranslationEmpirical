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
    }

    /**
     * xs are coefficients of a polynomial.
     * find_zero finds x such that poly(x) = 0 using Newton's method.
     *
     * @param xs The array of coefficients of the polynomial.
     * @return An approximation of the zero point.
     */
    public static double find_zero(double[] xs) {
        // Calculate coefficients of the derivative polynomial P'(x)
        // P'(x) = sum_{i=1}^{N-1} i * xs[i] * x^{i-1}
        // The coefficient for x^j in P'(x) is (j+1) * xs[j+1]
        double[] dxs = new double[xs.length - 1];
        for (int j = 0; j < xs.length - 1; j++) {
            dxs[j] = (j + 1) * xs[j + 1];
        }

        double x = 0.0;
        double tol = 1e-5;

        // Newton's method iteration
        for (int k = 0; k < 1000; k++) {
            double fx = poly(xs, x);
            double dfx =
