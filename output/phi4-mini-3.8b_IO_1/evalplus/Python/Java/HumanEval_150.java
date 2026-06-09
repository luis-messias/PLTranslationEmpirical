package com.example;
public class HumanEval_150 {

    public static void main(String[] args) {
        System.out.println(x_or_y(7, "x", "y")); // Example usage similar to provided examples.
        System.out.println(x_or_y("15", 8, 5));
    }

    public static String x_or_y(int n, String x, String y) {
        boolean isPrime = true;
        
        if (n < 2)
            return y;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        }

        return isPrime ? x : y;
    }
}
