package com.example;
class Solution {
    public int multiply(int a, int b) {
        int unitA = Math.abs(a % 10);
        int unitB = Math.abs(b % 10);
        return unitA * unitB;
    }
}