package com.example;
class Solution {
    public boolean simplify(String x, String n) {
        // Parse x = x1/x2
        String[] xParts = x.split("/");
        int x1 = Integer.parseInt(xParts[0]);
        int x2 = Integer.parseInt(xParts[1]);

        // Parse n = n1/n2
        String[] nParts = n.split("/");
        int n1 = Integer.parseInt(nParts[0]);
        int n2 = Integer.parseInt(nParts[1]);

        // Calculate the product of numerators: x1 * n1
        long numeratorProduct = (long)x1 * n1;

        // Calculate the product of denominators: x2 * n2
        long denominatorProduct = (long)x2 * n2;

        // Check if (x1 * n1) is divisible by (x2 * n2)
        return numeratorProduct % denominatorProduct == 0;
    }
}