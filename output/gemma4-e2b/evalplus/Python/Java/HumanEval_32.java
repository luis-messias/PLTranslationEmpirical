package com.example;
import java.util.ArrayList;
import java.util.List;

public class HumanEval_32 {

    /**
     * Evaluates polynomial with coefficients xs at point x.
     * return xs[0] + xs[1] * x + xs[2] * x^2 + .... xs[n] * x^n
     */
    public static double poly(List<Double> xs, double x) {
        double sum = 0.0;
        double x_pow = 1.0; // x^0
        for (double coeff : xs) {
            sum += coeff * x_pow;
            x_pow *= x;
        }
        return sum;
    }

    /**
     * Finds a zero of the polynomial using Newton's method.
     * xs are coefficients of a polynomial.
     * find_zero finds x such that poly(x) = 0.
     * find_zero returns only the zero point found.
     *
     * @param xs Coefficients of the polynomial. Must have an even number of coefficients.
     * @return The approximate zero point.
     */
    public static double find_zero(List<Double> xs) {
        int n = xs.size();
        
        // Calculate coefficients for the derivative polynomial P'(x)
        // If P(x) = xs[0] + xs[1]x + ... + xs[n]x^n
        // P'(x) = xs[1] + 2*xs[2]x + ... + n*xs[n]x^(n-1)
        // The coefficients for P'(x) are [1*xs[1], 2*xs[2], ..., n*xs[n]]
        List<Double> dxs = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            dxs.add(xs.get(i) * i);
        }

        // Define the function P(x)
        java.util.function.Function<Double, Double> func = x -> poly(xs, x);
        
        // Define the derivative P'(x)
        java.util.function.Function<Double, Double> derivative = x -> poly(dxs, x);
        
        double x = 0.0; // Initial guess
        double tol = 1e-5;
        int maxIterations = 1000;

        for (int iter = 0; iter < maxIterations; iter++) {
            double fx = func.apply(x);
            double dfx = derivative.apply(x);

            if (Math.abs(fx) < tol) {
                break;
            }
            
            // Check for division by zero (derivative is zero)
            if (Math.abs(dfx) < 1e-10) {
                // Cannot proceed with Newton's method if derivative is near zero
                break; 
            }
            
            x = x - fx / dfx;
        }

        return x;
    }
}