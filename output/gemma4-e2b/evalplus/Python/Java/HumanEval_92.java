package com.example;
class Solution {
    public static boolean anyInt(int x, int y, int z) {
        // The Python code checks if all inputs are integers. In Java, if we define the method
        // to take int, this condition is met. The core logic is checking if one number equals the sum of the other two.
        return x == y + z || y == x + z || z == y + x;
    }
}