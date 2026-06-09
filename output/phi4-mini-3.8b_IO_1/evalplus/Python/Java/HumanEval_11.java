package com.example;

import java.util.List;
import java.util.Arrays;

public class HumanEval_11 {

    public static void main(String[] args) {
        System.out.println(string_xor("010", "110")); // Example usage, should print '100'
    }

    public static String string_xor(List<String> a: List<String>, List<String> b: List<String>) {
        if (a.size() != b.size()) throw new IllegalArgumentException("Lists must be of equal size");

        return IntStream.range(0, a.size())
                .mapToObj(i -> Integer.toBinaryString(a.get(i).equals("1") ? 1 : 0) + 
                               Integer.toBinaryString(b.get(i).equals("1") ? 1 : 0))
                .filter(str -> str.length() == (a.get(0).length()) * 2)
                .mapToObj(Integer::parseInt)
                .reduce((x, y) -> x ^ y)
                .toString()
                .substring(32);
    }
}
