package com.example;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HumanEval_15 {
    public static String stringSequence(int n) {
        return IntStream.range(0, n + 1)
                .mapToObj(i -> Integer.toString(i))
                .collect(Collectors.joining(" "));
    }
}