package com.example;

import java.util.Arrays;
import java.util.stream.IntStream;

public class HumanEval_74 {
    public static String[] totalMatch(String[] lst1, String[] lst2) {
        long c1 = Arrays.stream(lst1).mapToInt(s -> s.length()).sum();
        long c2 = Arrays.stream(lst2).mapToInt(s -> s.length()).sum();
        return (c1 <= c2) ? lst1 : lst2;
    }
}
