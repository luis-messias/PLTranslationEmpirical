package com.example;
class Solution {
    public boolean rightAngleTriangle(double a, double b, double c) {
        return (a * a + b * b == c * c) || (a * a + c * c == b * b) || (b * b + c * c == a * a);
    }
}