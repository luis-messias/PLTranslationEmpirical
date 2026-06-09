package com.example;
public class HumanEval_157 {
    public static boolean rightAngleTriangle(int a, int b, int c) {
        return (a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a);
    }

    public static void main(String[] args) {
        System.out.println(rightAngleTriangle(3, 4, 5)); // prints: true
        System.out.println(rightAngleTriangle(1, 2, 3)); // prints: false
    }
}