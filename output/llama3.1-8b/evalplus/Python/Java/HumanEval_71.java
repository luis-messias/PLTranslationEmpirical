package com.example;
public class HumanEval_71 {
    public static double triangleArea(double a, double b, double c) {
        if (a + b <= c || a + c <= b || b + c <= a) return -1;
        double p = (a + b + c) / 2;
        return Math.round(Math.pow(p * (p - a) * (p - b) * (p - c), 0.5) * 100.0) / 100.0;
    }
}