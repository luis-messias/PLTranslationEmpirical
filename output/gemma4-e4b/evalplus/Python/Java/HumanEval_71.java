package com.example;
class Solution {
    public static double triangleArea(double a, double b, double c) {
        // Check if the sides form a valid triangle
        if (a + b <= c || a + c <= b || b + c <= a) {
            return -1.0;
        }

        // Calculate semi-perimeter (p)
        double p = (a + b + c) / 2.0;

        // Calculate area using Heron's formula
        double areaSquared = p * (p - a) * (p - b) * (p - c);
        double area = Math.sqrt(areaSquared);

        // Round the result to 2 decimal places
        // We multiply by 100, round to the nearest long integer, and then divide by 100.0
        return Math.round(area * 100.0) / 100.0;
    }
}