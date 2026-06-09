package com.example;

import java.util.Arrays;
public class HumanEval_15 {

    public static void main(String[] args) {
        System.out.println(stringSequence(0)); // Test cases can be run here if needed.
    }

    public static String stringSequence(int n) {
        return Arrays.toString(new int[]{n + 1}).replaceAll("[\\[\\],]", "").trim();
    }
}
