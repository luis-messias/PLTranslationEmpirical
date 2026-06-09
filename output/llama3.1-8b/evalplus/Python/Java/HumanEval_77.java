package com.example;
public class HumanEval_77 {
    public static boolean isCube(int a) {
        a = Math.abs(a);
        return (int)Math.round(Math.pow(a, 1.0/3)) * (int)Math.pow((int)Math.round(Math.pow(a, 1.0/3)), 3) == a;
    }

    public static void main(String[] args) {
        System.out.println(isCube(1)); // true
        System.out.println(isCube(2)); // false
        System.out.println(isCube(-1)); // true
        System.out.println(isCube(64)); // true
        System.out.println(isCube(0)); // true
        System.out.println(isCube(180)); // false
    }
}