package com.example;
class Solution {
    public static boolean isCube(long a) {
        long absA = Math.abs(a);
        
        // Calculate the cube root using Math.pow and round it.
        // We use 1.0/3.0 to ensure floating-point division.
        double root = Math.pow(absA, 1.0 / 3.0);
        long rootInt = Math.round(root);
        
        // Check if the cube of the rounded root equals the absolute value of a.
        // We must check the cube of the integer root.
        return rootInt * rootInt * rootInt == absA;
    }
}