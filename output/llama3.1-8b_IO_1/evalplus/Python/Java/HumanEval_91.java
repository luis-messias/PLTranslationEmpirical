package com.example;

import java.util.Arrays;
import java.util.regex.Pattern;

public class HumanEval_91 {
    public static int isBored(String S) {
        String[] sentences = Arrays.stream(S.replace("?", ".")
                .replace("!", ".")
                .split("\\."))
                .map(s -> s.trim())
                .toArray(String[]::new);
        return (int) Arrays.stream(sentences)
                .filter(s -> s.startsWith("I "))
                .count();
    }
}
