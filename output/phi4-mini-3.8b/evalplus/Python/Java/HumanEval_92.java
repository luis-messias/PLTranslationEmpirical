package com.example;
public class HumanEval_92 {

    public static boolean anyInt(int x, int y, int z) {

        if (x != Integer.valueOf(x) || y != Integer.valueOf(y) || z != Integer.valueOf(z)) return false;

        return x == y + z || y == x + z || z == x + y;


    }

}