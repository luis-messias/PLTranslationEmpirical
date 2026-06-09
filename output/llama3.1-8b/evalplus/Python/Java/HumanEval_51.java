package com.example;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HumanEval_51 {
    public static String removeVowels(String text) {
        return Stream.of(text.split(""))
                .filter(ch -> !"aeiouAEIOU".contains(ch))
                .collect(Collectors.joining());
    }
}