package com.example;
public class HumanEval_99 {
    public static double closestInteger(String value) {
        return Double.parseDouble(value);
    }

    public static void main(String[] args) {
        System.out.println(closestInteger("10"));
        System.out.println(closestInteger("15.3"));
        System.out.println(closestInteger("14.5"));
        System.out.println(closestInteger("-14.5"));
    }
}