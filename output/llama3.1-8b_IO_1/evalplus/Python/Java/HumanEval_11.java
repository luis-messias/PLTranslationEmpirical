package com.example;

import java.util.stream.IntStream;
import java.util.function.IntUnaryOperator;

public class HumanEval_11 {
    public static String stringXor(String a, String b) {
        return IntStream.range(0, Math.min(a.length(), b.length()))
                .map(i -> (a.charAt(i) - '0') ^ (b.charAt(i) - '0'))
                .mapToObj(x -> x % 2 == 1 ? "1" : "0")
                .reduce("", (acc, current) -> acc + current);
    }

    public static void main(String[] args) {
        System.out.println(stringXor("010", "110")); // prints: 100
    }
}
