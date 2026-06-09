package com.example;
class Solution {
    public boolean anyInt(int x, int y, int z) {
        // Since the method signature in Java forces x, y, and z to be integers (int),
        // the type checking for 'all numbers are integers' is implicitly handled by the function signature.
        // We only need to check the sum condition.
        return x == y + z || y == x + z || z == y + x;
    }
}