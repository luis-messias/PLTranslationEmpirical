package com.example;
public static double triangleArea(double a, double b, double c) {
    if (a + b <= c || a + c <= b || b + c <= a) {
        return -1;
    }
    double p = (a + b + c) / 2;
    double area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
    return Math.round(area * 100) / 100.0;
}