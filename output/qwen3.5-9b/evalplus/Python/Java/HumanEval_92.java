package com.example;
public static boolean anyInt(double x, double y, double z) {
    if (x != (int)x || y != (int)y || z != (int)z) {
        return false;
    }
    return x == y + z || y == x + z || z == y + x;
}