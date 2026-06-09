package com.example;
public class HumanEval_44 {
    public static String changeBase(int x, int base) {
        if (x == 0) return "0";
        StringBuilder ret = new StringBuilder();
        while (x != 0) {
            ret.insert(0, x % base);
            x /= base;
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        System.out.println(changeBase(8, 3)); // '22'
        System.out.println(changeBase(8, 2)); // '1000'
        System.out.println(changeBase(7, 2)); // '111'
    }
}