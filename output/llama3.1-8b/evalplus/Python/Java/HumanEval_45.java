package com.example;
public class HumanEval_45 {
    public static double triangleArea(double a, double h) {
        /**
         * Given length of a side and high return area for a triangle.
         */
        return a * h / 2;
    }

    public static void main(String[] args) {
        System.out.println(triangleArea(5, 3));
    }
}