package com.example;
public class HumanEval_84 {
    public static String solve(int N) {
        int s = 0;
        for (char c : Integer.toString(N).toCharArray()) {
            s += Character.getNumericValue(c);
        }
        return Integer.toBinaryString(s);
    }

    public static void main(String[] args) {
        System.out.println(solve(1000));
        System.out.println(solve(150));
        System.out.println(solve(147));
    }
}