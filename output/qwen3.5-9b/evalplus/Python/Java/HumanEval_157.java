package com.example;
public static boolean rightAngleTriangle(int a, int b, int c) {
    /**
     * Given the lengths of the three sides of a triangle. Return true if the three
     * sides form a right-angled triangle, false otherwise.
     * A right-angled triangle is a triangle in which one angle is right angle or 
     * 90 degree.
     * Example:
     * rightAngleTriangle(3, 4, 5) == true
     * rightAngleTriangle(1, 2, 3) == false
     */
    return a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a;
}