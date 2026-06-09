package com.example;
import java.util.Arrays;
import java.util.stream.Collectors;

public class HumanEval_86 {
    public static String antiShuffle(String s) {
        return Arrays.stream(s.split(" "))
                .map(word -> Arrays.stream(word.toCharArray())
                        .sorted((a, b) -> a - b)
                        .map(Object::toString)
                        .collect(Collectors.joining()))
                .collect(Collectors.joining(" "));
    }
}