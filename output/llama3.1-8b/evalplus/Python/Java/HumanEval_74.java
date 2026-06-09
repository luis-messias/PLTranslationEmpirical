package com.example;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HumanEval_74 {
    public static String[] totalMatch(String[] lst1, String[] lst2) {
        long c1 = lst1.stream().mapToLong(s -> s.length()).sum();
        long c2 = lst2.stream().mapToLong(s -> s.length()).sum();
        return (c1 <= c2) ? lst1 : lst2;
    }
}