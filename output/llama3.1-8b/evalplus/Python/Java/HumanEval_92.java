package com.example;
public class HumanEval_92 {
    public static boolean anyInt(int x, int y, int z) {
        if (x != (int)x || y != (int)y || z != (int)z) return false;
        return x == y + z || y == x + z || z == y + x;
    }
}