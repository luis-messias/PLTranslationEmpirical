package com.example;

import java.util.Arrays;
import java.util.stream.Collectors;

public class HumanEval_86 {
    public static String antiShuffle(String s) {
        return Arrays.stream(s.split(" "))
                .map(word -> new StringBuilder(word).reverse().toString())
                .collect(Collectors.joining(" "));
    }
}
