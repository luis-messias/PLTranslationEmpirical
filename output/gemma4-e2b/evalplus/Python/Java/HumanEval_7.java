package com.example;
import java.util.List;
import java.util.stream.Collectors;

public class HumanEval_7 {
    public static List<String> filterBySubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(s -> s.contains(substring))
                .collect(Collectors.toList());
    }
}