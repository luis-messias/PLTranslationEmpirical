package com.example;
class Solution {
    public static boolean simplify(String x, String n) {
        // Parse x: x1/x2
        String[] partsX = x.split("/");
        int x1 = Integer.parseInt(partsX[0]);
        int x2 = Integer.parseInt(partsX[1]);

        // Parse n: n1/n2
        String[] partsN = n.split("/");
        int n1 = Integer.parseInt(partsN[0]);
        int n2 = Integer.parseInt(partsN[1]);

        // The product is (x1 * n1) / (x2 * n2).
        // We check if (x1 * n1) is divisible by (x2 * n2).
        
        // Use long to prevent potential integer overflow during multiplication.
        long numerator = (long)x1 * n1;
        long denominator = (long)x2 * n2;

        return numerator % denominator == 0;
    }
}