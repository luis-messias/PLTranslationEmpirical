package com.example;
import java.util.stream.IntStream;

public class HumanEval_121 {
    public static int solution(int[] lst) {
        return IntStream.range(0, lst.length)
                .filter(i -> i % 2 == 0 && lst[i] % 2 == 1)
                .map(i -> lst[i])
                .sum();
    }
}