package com.example;
public class HumanEval_103 {
    public static String roundedAvg(int n, int m) {
        if (n > m) return "-1";
        double avg = Math.round((n + m) / 2.0);
        return Integer.toBinaryString((int)avg);
    }

    public static void main(String[] args) {
        System.out.println(roundedAvg(1, 5));
        System.out.println(roundedAvg(7, 5));
        System.out.println(roundedAvg(10, 20));
        System.out.println(roundedAvg(20, 33));
    }
}